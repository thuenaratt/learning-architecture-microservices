package co.ecommerce.customer.domain.mapper;

import co.ecommerce.customer.domain.dto.CreateCustomerCommand;
import co.ecommerce.order.domain.valueobject.Email;
import co.ecommerce.order.domain.valueobject.PhoneNumber;
import co.ecommerce.entity.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerDataMapper {

    // id and status are not set here: the domain sets them in initiateCustomer()
    public Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand) {
        return Customer.builder()
                .username(createCustomerCommand.username())
                .familyName(createCustomerCommand.familyName())
                .givenName(createCustomerCommand.givenName())
                .email(new Email(createCustomerCommand.email()))
                .phoneNumber(toPhoneNumber(createCustomerCommand.phoneNumber()))
                .build();
    }

    public PhoneNumber toPhoneNumber(String phoneNumber) {
        return phoneNumber == null ? null : new PhoneNumber(phoneNumber);
    }

}
