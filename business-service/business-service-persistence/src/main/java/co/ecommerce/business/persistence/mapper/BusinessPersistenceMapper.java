package co.ecommerce.business.persistence.mapper;

import co.ecommerce.business.domain.entity.Business;
import co.ecommerce.business.domain.entity.OrderDetail;
import co.ecommerce.business.domain.entity.Product;
import co.ecommerce.business.persistence.entity.BusinessEntity;
import co.ecommerce.persistence.business.exception.BusinessPersistenceException;
import co.ecommerce.order.domain.valueobject.BusinessId;
import co.ecommerce.order.domain.valueobject.Money;
import co.ecommerce.order.domain.valueobject.ProductId;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface BusinessPersistenceMapper {

    default List<UUID> businessToBusinessProducts(Business business) {
        return business.getOrderDetail().getProducts().stream().map(product -> product.getId().value()).toList();
    }

    default Business businessEntityToBusiness(List<BusinessEntity> businessEntities) {
        BusinessEntity businessEntity = businessEntities.stream().findFirst().orElseThrow(() -> new BusinessPersistenceException("Business could not be found"));

        List<Product> products = businessEntities.stream().map(entity -> Product.builder()
                .id(new ProductId(entity.getProductId()))
                .name(entity.getProductName())
                .price(new Money(entity.getProductPrice()))
                .available(entity.getProductAvailable())
                .build()).toList();

        return Business.builder()
                .id(new BusinessId(businessEntity.getBusinessId()))
                .active(businessEntity.getBusinessActive())
                .orderDetail(OrderDetail.builder().products(products).build())
                .build();
    }

}

