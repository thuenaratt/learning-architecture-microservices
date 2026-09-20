package co.ecommerce.order.restapi.controller;

import co.ecommerce.order.domain.dto.CreateOrderCommand;
import co.ecommerce.order.domain.dto.CreateOrderResult;
import co.ecommerce.order.domain.entity.Order;
import co.ecommerce.order.domain.usecase.CreateOrderUseCase;
import co.ecommerce.order.restapi.dto.OrderCreateRequest;
import co.ecommerce.order.restapi.dto.OrderCreateResponse;
import co.ecommerce.order.restapi.maper.OrderWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderCommandController {


//    Declare requried dependancy

    private final CreateOrderUseCase createOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(
            @Valid @RequestBody OrderCreateRequest orderCreateRequest
            ){
//        Mapping logic
        CreateOrderCommand createOrderCommand = orderWebMapper.orderCreateRequestToCreateOrderCommand(orderCreateRequest);
            createOrderUseCase.execute(createOrderCommand);


        CreateOrderResult createOrderResult = createOrderUseCase.execute(createOrderCommand);
//
        return orderWebMapper.createOrderResultToOrderCreateResponse(
                createOrderResult
        );
    }
}
