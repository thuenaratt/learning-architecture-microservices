package co.ecommerce.event;

import co.ecommerce.order.domain.event.DomainEvent;
import co.ecommerce.entity.Customer;
import lombok.Getter;

@Getter
public abstract class CustomerEvent implements DomainEvent<Customer> {
    private final Customer customer;

    public CustomerEvent(Customer customer){
        this.customer = customer;
    }

}