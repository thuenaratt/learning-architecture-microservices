package co.ecomerce.domain.event.service;

import co.ecomerce.domain.event.entity.Business;
import co.ecomerce.domain.event.entity.Order;
import co.ecomerce.domain.event.event.OrderCancelledEvent;
import co.ecomerce.domain.event.event.OrderCreatedEvent;
import co.ecomerce.domain.event.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Business business);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    void cancelOrder(Order order, List<String> failureMessages);


}
