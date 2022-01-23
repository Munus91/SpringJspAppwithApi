package com.nmironov.internetshop.dto.admin;

import com.nmironov.internetshop.model.UserRole;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDto implements UserDetails {

    private long userId;
    private String username; // user login
    private String name;
    private String surname;
    @Size(min = 5, message = "The password must contain at least 5 characters")
    private String password;
    private UserRole role;
    private String city;
    private String addressLine1; //street address,company name
    private String addressLine2; //apartment,suite,building,floor
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean archived;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setRole(UserRole role) {
        this.role = role;
    }
}
