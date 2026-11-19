package co.ecommerce.customer.persistence.adapter;

import co.ecommerce.core.PageResponse;
import co.ecommerce.customer.domain.dto.CustomerResult;
import co.ecommerce.customer.domain.port.output.CustomerRepository;
import co.ecommerce.customer.persistence.entity.CustomerEntity;
import co.ecommerce.customer.persistence.mapper.CustomerPersistenceMapper;
import co.ecommerce.customer.persistence.repository.CustomerJpaRepository;
import co.ecommerce.entity.Customer;
import co.ecommerce.order.domain.valueobject.CustomerId;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerPersistenceMapper customerPersistenceMapper;


    @CacheEvict(cacheNames = "customer", key = "#customerId.value")
    @Override
    public void deleteById(CustomerId customerId) {
        customerJpaRepository.deleteById(customerId.value());
    }


    @Cacheable(key = "'allCustomers'", value = "customer")
    @Override
    public PageResponse<CustomerResult> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CustomerEntity> customerEntityPage = customerJpaRepository.findAll(pageable);
        Page<CustomerResult> customerResultPage = customerEntityPage.map(customerPersistenceMapper::toCustomerResult);
        return PageResponse.<CustomerResult>builder()
                .items(customerResultPage.getContent())
                .page(customerResultPage.getNumber())
                .size(customerResultPage.getSize())
                .totalPages(customerResultPage.getTotalPages())
                .totalElements(customerResultPage.getTotalElements())
                .hasNext(customerResultPage.hasNext())
                .build();
    }


    @CachePut(key = "#customer.id.value", cacheNames = "customer")
    @Override
    public CustomerResult save(Customer customer) {
        CustomerEntity savedEntity = customerJpaRepository.save(
                customerPersistenceMapper.customerToCustomerEntity(customer));
        return customerPersistenceMapper.customerEntityToCustomerResult(savedEntity);
    }

    @Cacheable(cacheNames = "customer", key = "#customerId.value")
    @Override
    public Optional<CustomerResult> findByIdWithCache(CustomerId customerId) {
        return customerJpaRepository.findById(customerId.value())
                .map(customerPersistenceMapper::customerEntityToCustomerResult);
    }

    @Override
    public Optional<Customer> findById(CustomerId customerId) {
        return customerJpaRepository.findById(customerId.value())
                .map(customerPersistenceMapper::customerEntityToCustomer);
    }

    @Override
    public boolean existsByUsername(String username) {
        return customerJpaRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerJpaRepository.existsByEmail(email);
    }
}
