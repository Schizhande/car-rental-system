package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Customer;
import com.vchizhande.webservice.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments, Long> {
}
