package co.ecommerce.order.persistence.entity;

import co.ecommerce.order.domain.valueobject.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity //to create table name = order
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID customerId;
    private UUID businessId;

    private BigDecimal price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderAddressEntity orderAddress;

    private UUID trackingId;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;
    private String failureMessages; //message1;message2


}
