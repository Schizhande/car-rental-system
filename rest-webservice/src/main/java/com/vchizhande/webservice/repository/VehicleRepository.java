package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Customer;
import com.vchizhande.webservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
