package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Customer;
import com.vchizhande.webservice.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
}
