package co.ecommerce.business.domain.service;

import co.ecommerce.business.domain.entity.Business;
import co.ecommerce.business.domain.event.OrderApprovalEvent;

import java.util.List;

public interface BusinessDomainService {
    OrderApprovalEvent validateOrder(Business business, List<String> failureMessages);
}

