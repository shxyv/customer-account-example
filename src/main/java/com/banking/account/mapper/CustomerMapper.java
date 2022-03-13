package com.banking.account.mapper;


import com.banking.account.dao.entity.Customer;
import com.banking.account.model.dto.CustomerRequestDto;

public class CustomerMapper {

    public static Customer mapDtoToEntity(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .fullName(customerRequestDto.getFullName())
                .build();
    }
}
