package co.ecommerce.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "order_addresses")
public class StreetAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String street;
    private String postalCode;
    private String city;

    @OneToOne(mappedBy = "streetAddress")
    private OrderEntity order;

}
