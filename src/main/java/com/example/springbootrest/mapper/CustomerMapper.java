package com.example.springbootrest.mapper;

import com.example.springbootrest.api.CustomerDTO;
import com.example.springbootrest.domain.Customer;
import com.example.springbootrest.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO toDTOEntity(Customer customer);

    Customer toDomainEntity(CustomerEntity customerEntity);

    CustomerEntity toDbEntity(Customer customer);

}
