package co.ecommerce.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity //anotation to create table
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID customerId;
    private UUID businessId;

    @OneToOne
    private StreetAddressEntity streetAddress;
}
