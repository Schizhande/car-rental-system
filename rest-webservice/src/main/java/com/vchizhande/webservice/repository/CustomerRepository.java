package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
