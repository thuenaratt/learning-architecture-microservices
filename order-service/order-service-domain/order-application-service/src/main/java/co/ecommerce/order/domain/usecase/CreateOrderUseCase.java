package co.ecommerce.order.domain.usecase;

import co.ecommerce.order.domain.dto.CreateOrderCommand;
import co.ecommerce.order.domain.dto.CreateOrderResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CreateOrderUseCase {
    public CreateOrderResult execute(CreateOrderCommand createOrderCommand){
        log.info("executing CreateOrderUseCase: {}", createOrderCommand);

        return new CreateOrderResult(UUID.randomUUID());
    }
}

//insert , update , delete  call Command and Transition
//select -> Query -> Transition read Only
//pattern: CQRS = command query Resposibility segregate