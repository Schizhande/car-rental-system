package com.vchizhande.webservice.repository;


import com.vchizhande.webservice.model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission,Long> {
}
