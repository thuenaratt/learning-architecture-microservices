package co.ecommerce.order.restapi.maper;


import co.ecommerce.order.domain.dto.CreateOrderCommand;
import co.ecommerce.order.domain.dto.CreateOrderResult;
import co.ecommerce.order.restapi.dto.OrderCreateRequest;
import co.ecommerce.order.restapi.dto.OrderCreateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface OrderWebMapper {
    CreateOrderCommand orderCreateRequestToCreateOrderCommand(
        OrderCreateRequest orderCreateRequest
    );

//        source = OrderCreateRequest
//        target = CreateOrderCommand
        OrderCreateResponse createOrderResultToOrderCreateResponse(
                CreateOrderResult createOrderResult
        );

}
