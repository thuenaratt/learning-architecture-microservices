package co.ecommerce.customer;

import co.ecommerce.service.CustomerDomainService;
import co.ecommerce.service.CustomerDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// How to configure bean
// 1. Annotation based
// 2. Java based (method)
@Configuration
public class BeanConfiguration {

    @Bean
    public CustomerDomainService customerDomainService() {
        return new CustomerDomainServiceImpl();
    }

}
