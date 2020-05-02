package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Data
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String address;

    private Long roleId;

    public User toUser(PasswordEncoder passwordEncoder) {
        log.info("---> password {}", password);
        return new User(username,passwordEncoder.encode(password), fullName, phoneNumber, email, address);
    }
}
