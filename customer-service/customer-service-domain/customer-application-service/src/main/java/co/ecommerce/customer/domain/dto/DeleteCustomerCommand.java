package co.ecommerce.customer.domain.dto;

import java.util.UUID;

public record DeleteCustomerCommand (
        UUID customerId
) {

}
