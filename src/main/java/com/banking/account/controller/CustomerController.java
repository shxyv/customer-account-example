package com.banking.account.controller;

import com.banking.account.model.dto.CustomerRequestDto;
import com.banking.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        customerService.createCustomer(customerRequestDto);
    }
}
