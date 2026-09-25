package co.ecommerce.order.domain.usecase;

import co.ecommerce.order.domain.dto.CreateOrderCommand;
import co.ecommerce.order.domain.dto.CreateOrderResult;
import co.ecommerce.order.domain.entity.Business;
import co.ecommerce.order.domain.entity.Order;
import co.ecommerce.order.domain.entity.Product;
import co.ecommerce.order.domain.event.OrderCreatedEvent;
import co.ecommerce.order.domain.exception.OrderDomainException;
import co.ecommerce.order.domain.mapper.OrderDomainMapper;
import co.ecommerce.order.domain.port.output.BusinessRepository;
import co.ecommerce.order.domain.port.output.CustomerRepository;
import co.ecommerce.order.domain.port.output.OrderRepository;
import co.ecommerce.order.domain.service.OrderDomainService;
import co.ecommerce.order.domain.valueobject.BusinessId;
import co.ecommerce.order.domain.valueobject.Money;
import co.ecommerce.order.domain.valueobject.ProductId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateOrderUseCase {
    private final OrderDomainService orderDomainService;
    private final OrderDomainMapper orderDomainMapper;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;
    public CreateOrderResult execute(CreateOrderCommand createOrderCommand){
        log.info("executing CreateOrderUseCase: {}", createOrderCommand);

//        validate customer
        customerRepository.findCustomer(createOrderCommand.customerId())
                .orElseThrow(() -> new OrderDomainException("Could not find customer with ID: " + createOrderCommand.customerId()));

//        validate Business
        List<Product> products = createOrderCommand.items().stream()
                .map(commandOrderItem -> Product.builder()
                        .id(new ProductId(commandOrderItem.productId()))
                        .price(new Money(commandOrderItem.price()))
                        .build())
                .toList();
        Business business = Business.builder()
                .id(new BusinessId(createOrderCommand.businessId()))
                .products(products)
                .build();

        businessRepository.findBusiness(business)
                .orElseThrow(() -> new OrderDomainException("Could not fine business with ID: " + createOrderCommand.businessId()));

        log.info("Found business: {}", business);
//        invoke order domain login
        Order order = orderDomainMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, business);
        log.info("Order created: {}", orderCreatedEvent.getOrder().getId());
//          save order to database
        Order saveOrder = orderRepository.saveOrder(order);
        if (saveOrder == null){
            throw new OrderDomainException("Cloud not save data into database");
        }
        return new CreateOrderResult(saveOrder.getId().value());
    }
}

//insert , update , delete  call Command and Transition
//select -> Query -> Transition read Only
//pattern: CQRS = command query Repository segregate
