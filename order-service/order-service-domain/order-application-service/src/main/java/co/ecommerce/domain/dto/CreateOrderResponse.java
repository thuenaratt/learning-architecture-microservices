package co.ecommerce.domain.dto;

import co.ecommerce.domain.valueobject.OrderId;

public record CreateOrderResponse(
        OrderId orderId
) {
}
