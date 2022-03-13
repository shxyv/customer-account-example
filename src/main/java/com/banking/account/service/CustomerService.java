package com.banking.account.service;

import com.banking.account.dao.entity.Customer;
import com.banking.account.dao.repository.CustomerRepository;

import com.banking.account.mapper.CustomerMapper;
import com.banking.account.model.dto.CustomerRequestDto;
import com.banking.account.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.banking.account.mapper.CustomerMapper.*;
import static com.banking.account.model.constant.ExceptionConstants.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(CustomerRequestDto customerRequestDto){
        log.info("ActionLog.createCustomer.started");
        customerRepository.save(mapDtoToEntity(customerRequestDto));
        log.info("ActionLog.createCustomer.ended");
    }



    private Customer fetchCustomerIfExists(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> {
            log.error("ActionLog.fetchCustomerIfExists.error id:" + id);
            throw new NotFoundException(UNEXPECTED_EXCEPTION_CODE, String.format(CUSTOMER_NOT_FOUND_MESSAGE, id));
        });
    }
}
