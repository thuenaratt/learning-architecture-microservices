package co.ecommerce.business.domain.port.output;

import co.ecommerce.business.domain.entity.OrderApproval;

public interface OrderApprovalRepository {

    OrderApproval save(OrderApproval orderApproval);

}

