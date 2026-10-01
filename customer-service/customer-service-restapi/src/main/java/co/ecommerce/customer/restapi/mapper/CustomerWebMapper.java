package co.ecommerce.customer.restapi.mapper;

import co.ecommerce.customer.domain.dto.CreateCustomerCommand;
import co.ecommerce.customer.domain.dto.CreateCustomerResult;
import co.ecommerce.customer.domain.dto.UpdateCustomerCommand;
import co.ecommerce.customer.domain.dto.UpdateCustomerResult;
import co.ecommerce.customer.restapi.dto.CustomerCreateRequest;
import co.ecommerce.customer.restapi.dto.CustomerCreateResponse;
import co.ecommerce.customer.restapi.dto.CustomerUpdateRequest;
import co.ecommerce.customer.restapi.dto.CustomerUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CustomerWebMapper {
    CreateCustomerCommand customerCreateRequestToCreateCustomerCommand(CustomerCreateRequest customerCreateRequest);
    CustomerCreateResponse createCustomerResultToCustomerCreateResponse(CreateCustomerResult createCustomerResult);

    // customerId comes from the path, the rest from the request body
    @Mapping(source = "customerId", target = "customerId")
    UpdateCustomerCommand customerUpdateRequestToUpdateCustomerCommand(UUID customerId, CustomerUpdateRequest customerUpdateRequest);
    CustomerUpdateResponse updateCustomerResultToCustomerUpdateResponse(UpdateCustomerResult updateCustomerResult);
}
