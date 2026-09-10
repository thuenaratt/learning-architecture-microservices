package co.ecommerce.persistence.entity;

import co.ecomerce.domain.valueobject.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity //anotation to create table
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
    private StreetAddressEntity streetAddress;

    private UUID trackingId;
    private OrderStatus orderStatus;
    private String failureMessage; //message1;message2

}
