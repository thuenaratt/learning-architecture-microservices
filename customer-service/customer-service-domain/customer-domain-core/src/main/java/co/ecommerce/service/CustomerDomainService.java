package co.ecommerce.service;

import co.ecommerce.order.domain.valueobject.Email;
import co.ecommerce.order.domain.valueobject.PhoneNumber;
import co.ecommerce.entity.Customer;
import co.ecommerce.event.CustomerCreatedEvent;
import co.ecommerce.event.CustomerDeactivatedEvent;
import co.ecommerce.event.CustomerUpdatedEvent;


public interface CustomerDomainService {
    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);

    CustomerUpdatedEvent updateCustomer(Customer customer, String familyName, String givenName,
                                        Email email, PhoneNumber phoneNumber);

    CustomerDeactivatedEvent deactivateCustomer(Customer customer);
}
