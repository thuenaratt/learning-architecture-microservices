package co.ecommerce.order.persistence.mapper;

import ch.qos.logback.core.model.ComponentModel;
import co.ecommerce.order.domain.entity.Customer;
import co.ecommerce.order.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    @Mapping(source = "id", target = "id.value")

    Customer customerEntityToCustomer(CustomerEntity customerEntity);
}
