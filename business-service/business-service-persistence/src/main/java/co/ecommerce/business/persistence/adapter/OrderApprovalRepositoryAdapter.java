package co.ecommerce.business.persistence.adapter;

import co.ecommerce.business.domain.entity.OrderApproval;
import co.ecommerce.business.domain.port.output.OrderApprovalRepository;
import co.ecommerce.business.persistence.entity.OrderApprovalEntity;
import co.ecommerce.business.persistence.mapper.OrderApprovalPersistenceMapper;
import co.ecommerce.business.persistence.repository.OrderApprovalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderApprovalRepositoryAdapter implements OrderApprovalRepository {

    private final OrderApprovalJpaRepository orderApprovalJpaRepository;
    private final OrderApprovalPersistenceMapper orderApprovalPersistenceMapper;

    @Override
    public OrderApproval save(OrderApproval orderApproval) {
        OrderApprovalEntity orderApprovalEntity = orderApprovalPersistenceMapper.orderApprovalToOrderApprovalEntity(orderApproval);

        return orderApprovalPersistenceMapper.orderApprovalEntityToOrderApproval(orderApprovalJpaRepository.save(orderApprovalEntity));
    }
}

