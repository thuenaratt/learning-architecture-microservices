package co.ecommerce.customer.domain.dto;

import java.util.UUID;

public record DeactivateCustomerCommand(
        UUID customerId
) {
}
