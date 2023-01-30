package com.example.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootrest.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
