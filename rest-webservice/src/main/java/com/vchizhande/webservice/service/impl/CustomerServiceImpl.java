package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.CustomerDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.Role;
import com.vchizhande.webservice.model.Customer;
import com.vchizhande.webservice.repository.CustomerRepository;
import com.vchizhande.webservice.service.RoleService;
import com.vchizhande.webservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Collection<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Customer with id " + id + " not found"));
    }

    @Override
    public Customer create(CustomerDto customerDto) {
        Customer customer = customerDto.toCustomer();
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDto customerDto) {
        Customer customer = findById(customerDto.getId());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        customer.setFirstName(customerDto.getFirstName());
        customer.setCustomerNumber(customerDto.getCustomerNumber());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setGender(customerDto.getGender());
        customer.setLastName(customerDto.getLastName());
        customer.setNationalId(customerDto.getNationalId());
        return customerRepository.save(customer);
    }
}
