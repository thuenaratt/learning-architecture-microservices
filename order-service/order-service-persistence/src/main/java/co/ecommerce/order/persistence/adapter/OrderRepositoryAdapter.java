package co.ecommerce.order.persistence.adapter;

import co.ecommerce.order.domain.entity.Order;
import co.ecommerce.order.domain.port.output.OrderRepository;
import co.ecommerce.order.persistence.entity.OrderEntity;
import co.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import co.ecommerce.order.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order saveOrder(Order order) {
        // Map Order to OrderEntity
        OrderEntity orderEntity = orderPersistenceMapper.orderToOrderEntity(order);
//        save into database
//        orderEntity = orderJpaRepository.save(orderEntity);
        // Map OrderEntity to Order
        return orderPersistenceMapper.orderEntityToOrder(orderJpaRepository.save(orderEntity));
    }


}

