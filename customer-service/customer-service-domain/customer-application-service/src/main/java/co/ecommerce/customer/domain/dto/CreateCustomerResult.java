package co.ecommerce.customer.domain.dto;

import java.util.UUID;

public record CreateCustomerResult(
        UUID customerId
) {
}
