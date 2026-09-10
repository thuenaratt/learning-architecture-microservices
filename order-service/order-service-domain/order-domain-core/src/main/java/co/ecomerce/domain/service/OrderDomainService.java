package co.ecomerce.domain.service;

import co.ecomerce.domain.entity.Business;
import co.ecomerce.domain.entity.Order;
import co.ecomerce.domain.event.OrderCancelledEvent;
import co.ecomerce.domain.event.OrderCreatedEvent;
import co.ecomerce.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Business business);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    void cancelOrder(Order order, List<String> failureMessages);


}
