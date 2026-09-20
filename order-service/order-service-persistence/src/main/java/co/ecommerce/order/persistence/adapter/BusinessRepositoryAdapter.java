package co.ecommerce.order.persistence.adapter;

import co.ecommerce.order.domain.entity.Business;
import co.ecommerce.order.domain.port.output.BusinessRepository;
import co.ecommerce.order.persistence.entity.BusinessEntity;
import co.ecommerce.order.persistence.mapper.BusinessPersistenceMapper;
import co.ecommerce.order.persistence.repository.BusinessJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BusinessRepositoryAdapter implements BusinessRepository {

    private final BusinessJpaRepository businessJpaRepository;
    private final BusinessPersistenceMapper businessPersistenceMapper;

    @Override
    public Optional<Business> findBusinessInformation(Business business) {
        List<UUID> productIds = business.getProducts().stream()
                .map(product -> product.getId().value())
                .toList();

        List<BusinessEntity> businessEntities = businessJpaRepository
                .findByBusinessIdAndProductIdIn(business.getId().value(), productIds);

        if (businessEntities.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(businessPersistenceMapper.businessEntitiesToBusiness(businessEntities));
    }
}
