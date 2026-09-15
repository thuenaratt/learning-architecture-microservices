package co.ecommerce.order.restapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record OrderCreateResponse(
        @NotNull
        UUID productId,
        @NotNull
        Integer quantity,
        @NotNull
        BigDecimal price,
        @NotNull
        BigDecimal subTotal

){
}
