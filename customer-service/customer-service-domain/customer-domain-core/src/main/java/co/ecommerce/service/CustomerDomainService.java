package co.ecommerce.service;

import co.ecommerce.event.CustomerCreatedEvent;
import co.ecommerce.event.CustomerDeactivatedEvent;
import co.ecommerce.event.CustomerUpdatedEvent;
import co.ecommerce.entity.Customer;

public interface CustomerDomainService {

    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);

    CustomerUpdatedEvent updateCustomer(Customer customer);

    CustomerDeactivatedEvent deactivateCustomer(Customer customer);

}
