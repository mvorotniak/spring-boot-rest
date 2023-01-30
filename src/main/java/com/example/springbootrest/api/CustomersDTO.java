package com.example.springbootrest.api;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class CustomersDTO {

    private List<CustomerDTO> customerDTOS;

}
