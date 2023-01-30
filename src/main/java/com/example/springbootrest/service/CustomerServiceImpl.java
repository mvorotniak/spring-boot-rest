package com.example.springbootrest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootrest.domain.Customer;
import com.example.springbootrest.entity.CustomerEntity;
import com.example.springbootrest.mapper.CustomerMapper;
import com.example.springbootrest.repository.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll().stream()
            .map(this.customerMapper::toDomainEntity)
            .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerById(final Long id) {
        return this.customerMapper.toDomainEntity(this.customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("404")));
    }

    @Transactional
    @Override
    public Customer saveCustomer(final Customer customer) {
        final CustomerEntity customerEntity = this.customerRepository.save(this.customerMapper.toDbEntity(customer));

        return this.customerMapper.toDomainEntity(customerEntity);
    }
}
