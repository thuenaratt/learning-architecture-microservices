package co.ecomerce.domain.port.output;

import co.ecomerce.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
}