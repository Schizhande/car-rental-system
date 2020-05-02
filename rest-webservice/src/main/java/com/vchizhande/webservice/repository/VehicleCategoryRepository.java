package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long> {
}
