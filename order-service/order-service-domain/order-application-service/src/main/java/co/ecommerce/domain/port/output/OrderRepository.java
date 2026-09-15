package co.ecommerce.domain.port.output;

import co.ecommerce.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
}