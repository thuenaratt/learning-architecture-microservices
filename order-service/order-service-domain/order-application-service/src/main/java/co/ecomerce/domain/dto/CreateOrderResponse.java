package co.ecomerce.domain.dto;

import co.ecomerce.domain.valueobject.OrderId;

public record CreateOrderResponse(
        OrderId orderId
) {
}
