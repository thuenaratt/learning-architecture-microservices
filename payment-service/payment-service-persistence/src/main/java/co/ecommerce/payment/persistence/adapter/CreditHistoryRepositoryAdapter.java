package co.ecommerce.payment.persistence.adapter;

import co.ecommerce.payment.domain.entity.CreditHistory;
import co.ecommerce.payment.domain.port.output.CreditHistoryRepository;
import co.ecommerce.payment.persistence.entity.CreditHistoryEntity;
import co.ecommerce.payment.persistence.mapper.CreditHistoryPersistenceMapper;
import co.ecommerce.payment.persistence.repository.CreditHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreditHistoryRepositoryAdapter implements CreditHistoryRepository {
  private final CreditHistoryJpaRepository creditHistoryJpaRepository;
  private final CreditHistoryPersistenceMapper creditHistoryPersistenceMapper;

  @Override
  public CreditHistory save(CreditHistory creditHistory) {
    CreditHistoryEntity creditHistoryEntity =
        creditHistoryPersistenceMapper.creditHistoryToCreditHistoryEntity(creditHistory);
    CreditHistoryEntity savedCreditHistoryEntity = creditHistoryJpaRepository.save(creditHistoryEntity);
    return creditHistoryPersistenceMapper.creditHistoryEntityToCreditHistory(savedCreditHistoryEntity);
  }
}
