package co.ecommerce.persistence.Adapter;

import co.ecomerce.domain.entity.Order;
import co.ecomerce.domain.port.output.OrderRepository;

public class OrderRepositoryAdapter implements OrderRepository {
    @Override
    public Order saveOrder(Order order) {
        return null;
    }
}
