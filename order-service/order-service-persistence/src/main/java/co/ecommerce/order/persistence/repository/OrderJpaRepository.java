package co.ecommerce.order.persistence.repository;

import co.ecommerce.order.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//Benifit of using spring JPA => Relational DB
//1. Boilerplate code
//2. Abstraction Repository
//3. Derived Query Method (Auto generate SQL)
//4. Object Relation Mapping (ORM) Hibernate
//5. Specification (Dynamic Query)

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {


}
