package co.ecommerce.order.persistence.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
public class BusinessIdEntity implements Serializable {
    private UUID businessId;
    private UUID productId;

}
