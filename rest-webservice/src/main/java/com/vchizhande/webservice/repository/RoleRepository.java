package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
