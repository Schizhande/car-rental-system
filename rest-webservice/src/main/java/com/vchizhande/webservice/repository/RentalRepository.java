package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
