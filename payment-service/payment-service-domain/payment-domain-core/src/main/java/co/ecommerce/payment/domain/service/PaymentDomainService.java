package co.ecommerce.payment.domain.service;

import co.ecommerce.order.domain.valueobject.PaymentStatus;
import co.ecommerce.payment.domain.entity.CreditEntry;
import co.ecommerce.payment.domain.entity.CreditHistory;
import co.ecommerce.payment.domain.entity.Payment;

public interface PaymentDomainService {
  CreditHistory validateAndInitiatePayment(Payment payment, CreditEntry creditEntry);

  void updatePaymentStatus(Payment payment, PaymentStatus newPaymentStatus);
}
