package com.example.springbootrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springbootrest.domain.Customer;
import com.example.springbootrest.service.CustomerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {

    private final CustomerService customerService;

    @Override
    public void run(String... args) {
        final Customer mariana = Customer.builder()
            .name("Mariana")
            .surname("Surname1")
            .orderUrl("")
            .build();

        final Customer maria = Customer.builder()
            .name("Maria")
            .surname("Surname2")
            .orderUrl("order/url/1")
            .build();

        this.customerService.saveCustomer(mariana);
        this.customerService.saveCustomer(maria);
    }
}
