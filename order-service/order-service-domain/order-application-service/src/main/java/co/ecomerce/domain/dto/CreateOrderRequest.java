package co.ecomerce.domain.dto;

import co.ecomerce.domain.valueobject.BusinessId;
import co.ecomerce.domain.valueobject.CustomerId;
import co.ecomerce.domain.valueobject.Money;
import co.ecomerce.domain.valueobject.StreetAddress;

public record CreateOrderRequest(
        CustomerId customerId,
        BusinessId businessId,
        StreetAddress deliveryAddress,
        Money price

) {
}
