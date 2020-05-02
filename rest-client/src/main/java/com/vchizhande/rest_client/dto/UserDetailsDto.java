package com.vchizhande.rest_client.dto;

import com.vchizhande.rest_client.domain.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserDetailsDto implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String address;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private Role role;

    private Long roleId;

    public UserDetailsDto() {
    }

    public Collection<CustomGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

@Data
class CustomGrantedAuthority implements GrantedAuthority{

    private String authority;

    CustomGrantedAuthority(){

    }
    @Override
    public String getAuthority() {
        return authority;
    }
}