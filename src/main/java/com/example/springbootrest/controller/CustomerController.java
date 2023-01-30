package com.example.springbootrest.controller;

import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.api.CustomerDTO;
import com.example.springbootrest.api.CustomersDTO;
import com.example.springbootrest.mapper.CustomerMapper;
import com.example.springbootrest.service.CustomerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    @GetMapping("/rest/customers/all")
    public ResponseEntity<CustomersDTO> findAllCustomers() {
        final CustomersDTO customersDTO = CustomersDTO.builder()
            .customerDTOS(this.customerService.getAllCustomers().stream()
                .map(this.customerMapper::toDTOEntity)
                .collect(Collectors.toList()))
            .build();

        return ResponseEntity.ok(customersDTO);
    }

    @GetMapping("/rest/customers/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable final Long id) {
        final CustomerDTO customerDTO = this.customerMapper.toDTOEntity(this.customerService.getCustomerById(id));

        return ResponseEntity.ok(customerDTO);
    }

}
