package com.example.springbootrest.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.api.CustomerDTO;
import com.example.springbootrest.api.CustomersDTO;
import com.example.springbootrest.mapper.CustomerMapper;
import com.example.springbootrest.service.CustomerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("${app.base.url}")
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public CustomersDTO findAllCustomers() {
        return CustomersDTO.builder()
            .customerDTOS(this.customerService.getAllCustomers().stream()
                .map(this.customerMapper::toDTOEntity)
                .collect(Collectors.toList()))
            .build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO findCustomerById(@PathVariable final Long id) {
        return this.customerMapper.toDTOEntity(this.customerService.getCustomerById(id));
    }

}
