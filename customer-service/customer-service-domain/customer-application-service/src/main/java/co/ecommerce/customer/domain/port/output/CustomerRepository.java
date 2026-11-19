package co.ecommerce.customer.domain.port.output;


import co.ecommerce.customer.domain.dto.CustomerResult;
import co.ecommerce.order.domain.valueobject.CustomerId;
import co.ecommerce.entity.Customer;
import co.ecommerce.core.PageResponse;

import java.util.Optional;

public interface CustomerRepository {

    PageResponse<CustomerResult> findAll(int page, int size);

    CustomerResult save(Customer customer);

    Optional<Customer> findById(CustomerId customerId);

    Optional<CustomerResult> findByIdWithCache(CustomerId customerId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void deleteById(CustomerId customerId);

}
