package co.ecommerce.customer.domain.port.output;


import co.ecommerce.order.domain.valueobject.CustomerId;
import co.ecommerce.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(CustomerId customerId);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
