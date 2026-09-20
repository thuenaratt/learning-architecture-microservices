package co.ecommerce.order.domain.port.output;

import co.ecommerce.order.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {

    Optional<Business> findBusinessInformation(Business business);
}
