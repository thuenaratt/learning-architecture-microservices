package co.ecommerce.order.persistence.mapper;

import co.ecommerce.order.domain.entity.Business;
import co.ecommerce.order.domain.entity.Product;
import co.ecommerce.order.domain.valueobject.BusinessId;
import co.ecommerce.order.domain.valueobject.Money;
import co.ecommerce.order.domain.valueobject.ProductId;
import co.ecommerce.order.persistence.entity.BusinessEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessPersistenceMapper {

    public Business businessEntitiesToBusiness(List<BusinessEntity> businessEntities) {
        BusinessEntity firstEntity = businessEntities.getFirst();

        return Business.builder()
                .id(new BusinessId(firstEntity.getBusinessId()))
                .active(firstEntity.isBusinessActive())
                .products(businessEntities.stream()
                        .map(this::businessEntityToProduct)
                        .toList())
                .build();
    }

    private Product businessEntityToProduct(BusinessEntity businessEntity) {
        return Product.builder()
                .id(new ProductId(businessEntity.getProductId()))
                .name(businessEntity.getProductName())
                .price(new Money(businessEntity.getProductPrice()))
                .build();
    }
}
