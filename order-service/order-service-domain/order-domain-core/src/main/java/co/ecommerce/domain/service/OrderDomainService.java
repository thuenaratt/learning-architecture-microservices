package co.ecommerce.domain.service;

import co.ecommerce.domain.entity.Business;
import co.ecommerce.domain.entity.Order;
import co.ecommerce.domain.event.OrderCancelledEvent;
import co.ecommerce.domain.event.OrderCreatedEvent;
import co.ecommerce.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Business business);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    void cancelOrder(Order order, List<String> failureMessages);


}
