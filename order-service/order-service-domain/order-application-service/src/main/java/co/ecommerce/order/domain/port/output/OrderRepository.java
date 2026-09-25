package co.ecommerce.order.domain.port.output;

import co.ecommerce.order.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
//    Order saveOrder(Order order);
}