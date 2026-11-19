package co.ecommerce.customer.restapi.mapper;

import co.ecommerce.customer.domain.dto.*;
import co.ecommerce.customer.restapi.dto.*;
import co.ecommerce.core.PageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

//@Mapper(componentModel = "spring")
//public interface CustomerWebMapper {
//    CreateCustomerCommand customerCreateRequestToCreateCustomerCommand(CustomerCreateRequest customerCreateRequest);
//    CustomerCreateResponse createCustomerResultToCustomerCreateResponse(CreateCustomerResult createCustomerResult);
//
//    // customerId comes from the path, the rest from the request body
//    @Mapping(source = "customerId", target = "customerId")
//    UpdateCustomerCommand customerUpdateRequestToUpdateCustomerCommand(UUID customerId, CustomerUpdateRequest customerUpdateRequest);
//    CustomerUpdateResponse updateCustomerResultToCustomerUpdateResponse(UpdateCustomerResult updateCustomerResult);
//}
@Mapper(componentModel = "spring")
public interface CustomerWebMapper {

    CustomerResponse toCustomerResponse(CustomerResult customerResult);

    CreateCustomerCommand customerCreateRequestToCreateCustomerCommand(CustomerCreateRequest customerCreateRequest);

    CustomerCreateResponse createCustomerResultToCustomerCreateResponse(CreateCustomerResult createCustomerResult);

    // customerId comes from the path, the rest from the request body
    @Mapping(source = "customerId", target = "customerId")
    UpdateCustomerCommand customerUpdateRequestToUpdateCustomerCommand(UUID customerId, CustomerUpdateRequest customerUpdateRequest);

    CustomerUpdateResponse updateCustomerResultToCustomerUpdateResponse(UpdateCustomerResult updateCustomerResult);

    PageResponse<CustomerResponse> toCustomerResponse(PageResponse<CustomerResult> result);
}
