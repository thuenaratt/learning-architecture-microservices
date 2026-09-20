package co.ecommerce.order.domain.service;

import co.ecommerce.order.domain.entity.Business;
import co.ecommerce.order.domain.entity.Order;
import co.ecommerce.order.domain.event.OrderCancelledEvent;
import co.ecommerce.order.domain.event.OrderCreatedEvent;
import co.ecommerce.order.domain.event.OrderPaidEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Business business) {
        // validateBusiness(business);
        //setOrderProductInformation(order, business);
        order.validateOrder();
        order.initializeOrder();
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        return null;
    }

    @Override
    public void approveOrder(Order order) {

    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        return null;
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {

    }
}