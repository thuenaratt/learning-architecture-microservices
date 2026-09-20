package co.ecommerce.order.persistence.mapper;

import co.ecommerce.order.domain.entity.Customer;
import co.ecommerce.order.domain.valueobject.CustomerId;
import co.ecommerce.order.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    default Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return Customer.Builder.builder()
                .id(new CustomerId(customerEntity.getId()))
                .username(customerEntity.getUsername())
                .familyName(customerEntity.getFamilyName())
                .givenName(customerEntity.getGivenName())
                .build();
    }
}
