package co.ecommerce.order.persistence.adapter;

import co.ecommerce.domain.entity.Order;
import co.ecommerce.domain.port.output.OrderRepository;
import co.ecommerce.order.persistence.repository.OrderJpaRepository;


public class OrderRepositoryAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        // Map Order to OrderEntity
        // Map OrderEntity to Order
        return null;
    }


}

