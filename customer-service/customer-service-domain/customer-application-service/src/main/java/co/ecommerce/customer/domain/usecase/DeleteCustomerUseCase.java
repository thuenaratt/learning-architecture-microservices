package co.ecommerce.customer.domain.usecase;


import co.ecommerce.customer.domain.dto.DeleteCustomerCommand;
import co.ecommerce.customer.domain.port.output.CustomerRepository;
import co.ecommerce.order.domain.valueobject.CustomerId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;

    public void execute(DeleteCustomerCommand deleteCustomerCommand) {
        CustomerId customerId = new CustomerId(deleteCustomerCommand.customerId());
        customerRepository.deleteById(customerId);
    }

}