package co.ecommerce.payment.domain.port.output;

import co.ecommerce.payment.domain.entity.Payment;

public interface PaymentRepository {
  Payment savePayment(Payment payment);
}
