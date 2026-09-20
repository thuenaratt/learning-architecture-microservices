package co.ecommerce.order.domain.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

//if dto type is command use name react
public record CreateOrderCommand(
        UUID customerId,
        UUID businessId,
        CommandOrderAddress deliveryAddress,
        BigDecimal price,
        List<CommandOrderItem> items

) {
}
