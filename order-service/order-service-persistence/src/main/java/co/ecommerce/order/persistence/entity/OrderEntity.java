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

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;

    @OneToOne
    private OrderAddressEntity orderAddress;

    private UUID trackingId;
    private OrderStatus orderStatus;
    private String failureMessage; //message1;message2

}
