package co.ecommerce.payment.domain.port.output;

import co.ecommerce.order.domain.valueobject.CustomerId;
import co.ecommerce.payment.domain.entity.CreditEntry;

public interface CreditEntityRepository  {
    CreditEntry findByCustomerId(CustomerId customerId);

    CreditEntry save(CreditEntry creditEntry);
}
