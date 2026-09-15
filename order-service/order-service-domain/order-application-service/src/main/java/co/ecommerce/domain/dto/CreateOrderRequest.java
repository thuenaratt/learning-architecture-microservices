package co.ecommerce.domain.dto;

import co.ecommerce.domain.valueobject.BusinessId;
import co.ecommerce.domain.valueobject.CustomerId;
import co.ecommerce.domain.valueobject.Money;
import co.ecommerce.domain.valueobject.StreetAddress;

public record CreateOrderRequest(
        CustomerId customerId,
        BusinessId businessId,
        StreetAddress deliveryAddress,
        Money price

) {
}
