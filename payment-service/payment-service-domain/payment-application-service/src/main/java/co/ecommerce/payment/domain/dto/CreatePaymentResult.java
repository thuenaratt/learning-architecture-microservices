package co.ecommerce.payment.domain.dto;

import co.ecommerce.order.domain.valueobject.PaymentStatus;

import java.util.UUID;

public record CreatePaymentResult(
    UUID paymentId,
    PaymentStatus paymentStatus
) {
}
