package co.ecommerce.customer.domain.usecase;

import co.ecommerce.customer.domain.dto.CustomerResult;
import co.ecommerce.customer.domain.mapper.CustomerDomainMapper;
import co.ecommerce.customer.domain.port.output.CustomerRepository;
import co.ecommerce.exception.CustomerDomainException;
import co.ecommerce.order.domain.valueobject.CustomerId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetCustomerByIdUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerDomainMapper customerDomainMapper;

    public CustomerResult execute(UUID id) {
        return customerRepository.findByIdWithCache(new CustomerId(id))
                .orElseThrow(() -> new CustomerDomainException("Customer not found"));
    }

}
