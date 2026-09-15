package co.ecommerce.domain.port.input;

import co.ecommerce.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {

    void execute(CreateOrderRequest createOrderRequest);
}
