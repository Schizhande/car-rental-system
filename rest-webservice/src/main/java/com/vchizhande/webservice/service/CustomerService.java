package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.CustomerDto;
import com.vchizhande.webservice.model.Customer;

import java.util.Collection;

public interface CustomerService {

    Collection<Customer> findAllCustomers();

    void delete(Long id);

    Customer findById(Long id);

    Customer update(CustomerDto customerDto);

    Customer create(CustomerDto customerDto);
}
