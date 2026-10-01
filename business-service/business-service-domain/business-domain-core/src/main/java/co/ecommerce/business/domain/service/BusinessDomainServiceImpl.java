package co.ecommerce.business.domain.service;

import co.ecommerce.business.domain.entity.Business;
import co.ecommerce.business.domain.event.OrderApprovalEvent;
import co.ecommerce.business.domain.event.OrderApprovedEvent;
import co.ecommerce.business.domain.event.OrderRejectedEvent;
import co.ecommerce.order.domain.valueobject.OrderApprovalStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class BusinessDomainServiceImpl implements BusinessDomainService {

    @Override
    public OrderApprovalEvent validateOrder(Business business, List<String> failureMessages) {
        business.validateOrder(failureMessages);

        if (failureMessages.isEmpty()) {
            business.constructOrderApproval(OrderApprovalStatus.APPROVED);
            return new OrderApprovedEvent(business.getOrderApproval(), business.getId(),
                    failureMessages, ZonedDateTime.now(ZoneId.of("UTC")));
        }

        business.constructOrderApproval(OrderApprovalStatus.REJECTED);
        return new OrderRejectedEvent(business.getOrderApproval(), business.getId(),
                failureMessages, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}

