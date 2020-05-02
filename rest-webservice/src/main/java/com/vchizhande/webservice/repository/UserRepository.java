package com.vchizhande.webservice.repository;

import com.vchizhande.webservice.model.Role;
import com.vchizhande.webservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Page<User> findByRole(Role role, Pageable pageable);

    Optional<User> findByEmail(String email);
}
