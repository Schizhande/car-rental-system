package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payments, Long> {

    @Query(value = "select IFNULL(sum(amount), 0) from payments", nativeQuery = true)
    Long sumAmount();

}
