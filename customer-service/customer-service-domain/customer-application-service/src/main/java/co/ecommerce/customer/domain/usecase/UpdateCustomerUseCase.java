package co.ecommerce.customer.domain.usecase;

import co.ecommerce.customer.domain.dto.CustomerResult;
import co.ecommerce.customer.domain.dto.UpdateCustomerCommand;
import co.ecommerce.customer.domain.dto.UpdateCustomerResult;
import co.ecommerce.customer.domain.mapper.CustomerDomainMapper;
import co.ecommerce.customer.domain.port.output.CustomerRepository;
import co.ecommerce.exception.CustomerDomainException;
import co.ecommerce.order.domain.valueobject.CustomerId;
import co.ecommerce.order.domain.valueobject.Email;
import co.ecommerce.entity.Customer;
import co.ecommerce.event.CustomerUpdatedEvent;
import co.ecommerce.order.domain.valueobject.PhoneNumber;
import co.ecommerce.service.CustomerDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Use case: change an existing customer's name, email and phone number.
// Called by the REST API controller (PUT /api/v1/customers/{customerId}).
// Flow: load customer -> check new email -> domain updates -> save -> return id
@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateCustomerUseCase {

    private final CustomerDomainService customerDomainService;
    private final CustomerRepository customerRepository;
    private final CustomerDomainMapper customerDomainMapper;

    @Transactional
    public UpdateCustomerResult execute(UpdateCustomerCommand updateCustomerCommand) {

        Customer customer = customerRepository.findById(new CustomerId(updateCustomerCommand.customerId()))
                .orElseThrow(() -> new CustomerDomainException(
                        "Customer not found: " + updateCustomerCommand.customerId()));

        Email newEmail = new Email(updateCustomerCommand.email());

        if (!newEmail.equals(customer.getEmail()) && customerRepository.existsByEmail(newEmail.value())) {
            throw new CustomerDomainException("Email already exists");
        }

        customer.updateCustomer(
                updateCustomerCommand.familyName(),
                updateCustomerCommand.givenName(),
                newEmail,
                new PhoneNumber(updateCustomerCommand.phoneNumber())
        );

        CustomerUpdatedEvent customerUpdatedEvent = customerDomainService.updateCustomer(customer);
        CustomerResult savedCustomer = customerRepository.save(customer);

        log.info("Customer updated with id: {} at {}",
                savedCustomer.id(), customerUpdatedEvent.getUpdatedAt());
        return new UpdateCustomerResult(savedCustomer.id());
    }
}