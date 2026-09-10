package co.ecommerce.persistence.adapter;

import co.ecomerce.domain.entity.Order;
import co.ecomerce.domain.port.output.OrderRepository;
import co.ecommerce.persistence.repository.OrderJpaRepository;

public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }


    @Override
    public Order saveOrder(Order order) {
        //Map Order to OrderEntity;
        //Map OrderEntity to Order;
        return null;
    }
}
