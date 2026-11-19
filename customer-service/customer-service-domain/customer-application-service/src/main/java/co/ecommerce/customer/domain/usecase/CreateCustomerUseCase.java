package co.ecommerce.customer.domain.usecase;

import co.ecommerce.customer.client.dto.UserResponse;
import co.ecommerce.customer.client.exception.UserServiceUnavailableException;
import co.ecommerce.customer.client.feign.UserFeignClient;
import co.ecommerce.customer.domain.dto.CreateCustomerCommand;
import co.ecommerce.customer.domain.dto.CreateCustomerResult;
import co.ecommerce.customer.domain.dto.CustomerResult;
import co.ecommerce.customer.domain.mapper.CustomerDomainMapper;
import co.ecommerce.customer.domain.port.output.CustomerRepository;
import co.ecommerce.entity.Customer;
import co.ecommerce.event.CustomerCreatedEvent;
import co.ecommerce.exception.CustomerDomainException;
import co.ecommerce.service.CustomerDomainService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Use case: register a new customer.
// Called by the REST API controller (POST /api/v1/customers).
// Flow: check duplicates -> build domain Customer -> domain validates & initiates -> save -> return new id
@Component
@Slf4j
@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerDomainService customerDomainService; // business rules (from customer-domain-core)
    private final CustomerRepository customerRepository;
    private final CustomerDomainMapper customerDomainMapper;

    private final UserFeignClient userFeignClient;

    @Transactional
    public CreateCustomerResult execute(CreateCustomerCommand createCustomerCommand) {
        log.info("Execute CreateCustomerUseCase : {}", createCustomerCommand);

        // ACL - verify user with user-service
        try {
            UserResponse userResponse = userFeignClient.getById(createCustomerCommand.userId());
            log.info("User found: {}", userResponse);
        } catch (FeignException.NotFound e) {
            throw new CustomerDomainException("User not found");
        } catch (UserServiceUnavailableException e) {
            throw new CustomerDomainException(e.getMessage());
        }

        if (customerRepository.existsByUsername(createCustomerCommand.username())) {
            throw new CustomerDomainException("Username already exists");
        }

        if (customerRepository.existsByEmail(createCustomerCommand.email())) {
            throw new CustomerDomainException("Email already exists");
        }

        Customer customer = customerDomainMapper.createCustomerCommandToCustomer(createCustomerCommand);
        CustomerCreatedEvent customerCreatedEvent = customerDomainService.validateAndInitiateCustomer(customer);
        CustomerResult savedCustomer = customerRepository.save(customer);

        if (savedCustomer == null) {
            log.error("Could not save customer with id: {}", createCustomerCommand.customerId());
            throw new CustomerDomainException("Could not save customer with id " + createCustomerCommand.customerId());
        }

        return new CreateCustomerResult(savedCustomer.id());
    }
}