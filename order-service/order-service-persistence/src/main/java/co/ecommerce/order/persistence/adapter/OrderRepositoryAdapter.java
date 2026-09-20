package co.ecommerce.order.persistence.adapter;

import co.ecommerce.order.domain.entity.Order;
import co.ecommerce.order.domain.port.output.OrderRepository;
import co.ecommerce.order.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order saveOrder(Order order) {
        // Map Order to OrderEntity
        // Map OrderEntity to Order
        return null;
    }


}

