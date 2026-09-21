package co.ecommerce.order.persistence.mapper;

import co.ecommerce.order.domain.entity.Business;
import co.ecommerce.order.domain.entity.Product;
import co.ecommerce.order.domain.valueobject.BusinessId;
import co.ecommerce.order.domain.valueobject.Money;
import co.ecommerce.order.domain.valueobject.ProductId;
import co.ecommerce.order.persistence.entity.BusinessEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface BusinessPersistenceMapper {

    default List<UUID> businessToBusinessProducts(Business business) {
        return business.getProducts().stream()
                .map(product -> product.getId().value())
                .toList();
    }

    default Business businessEntityToBusiness(List<BusinessEntity> businessEntities) {
        BusinessEntity businessEntity = businessEntities.getFirst();

        List<Product> businessProducts = businessEntities.stream()
                .map(entity -> Product.builder()
                        .id(new ProductId(entity.getProductId()))
                        .name(entity.getProductName())
                        .price(new Money(entity.getProductPrice()))
                        .build())
                .toList();

        return Business.builder()
                .id(new BusinessId(businessEntity.getBusinessId()))
                .products(businessProducts)
                .active(businessEntity.isBusinessActive())
                .build();
    }
}
