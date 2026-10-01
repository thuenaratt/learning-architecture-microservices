package co.ecommerce.payment.domain.port.output;

import co.ecommerce.payment.domain.entity.CreditHistory;

public interface CreditHistoryRepository {
    CreditHistory save(CreditHistory creditHistory);
}
