package co.ecommerce.order.domain.service;

import co.ecommerce.order.domain.entity.Business;
import co.ecommerce.order.domain.entity.Order;
import co.ecommerce.order.domain.event.OrderCancelledEvent;
import co.ecommerce.order.domain.event.OrderCreatedEvent;
import co.ecommerce.order.domain.event.OrderPaidEvent;
import co.ecommerce.order.domain.exception.OrderDomainException;
import co.ecommerce.order.domain.entity.Product;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Business business) {
        // validateBusiness(business);
        if(!business.isActive()){
            throw new OrderDomainException("Business is not currently active");
        }
        setOrderProductInformation(order, business);
        order.validateOrder();
        order.initializeOrder();
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    private void setOrderProductInformation(Order order, Business business) {
        order.getItems().forEach(orderItem -> {
            Product businessProduct = business.getProducts().stream()
                    .filter(product -> product.getId().equals(orderItem.getProduct().getId()))
                    .findFirst()
                    .orElseThrow(() -> new OrderDomainException(
                            "Product " + orderItem.getProduct().getId().value()
                                    + " is not available for this business"));

            orderItem.getProduct().updateWithConfirmedNameAndPrice(
                    businessProduct.getName(),
                    businessProduct.getPrice()
            );
        });
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();

    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);

    }
}
