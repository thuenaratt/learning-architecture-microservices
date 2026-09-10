package co.ecomerce.domain.port.input;

import co.ecomerce.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {

    void execute(CreateOrderRequest createOrderRequest);
}
