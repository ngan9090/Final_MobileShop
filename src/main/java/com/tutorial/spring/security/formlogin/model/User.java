package com.tutorial.spring.security.formlogin.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable=false, unique=true)
    private Integer userId;

    @Column(name="username")
    private String username;

    @Column(name="name")
    private String account;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="role_id")
    private Integer roleId;

    @Column(name="account_non_locked")
    private boolean accountNonLocked;

    public User() {
    }

    public User(String username, String account, String password, String email, String phone, Integer roleId,boolean accountNonLocked) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roleId = roleId;
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }

    public String getAccountName() {
        return account;
    }

    public Integer getUserId() {
        return userId;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(() -> "read");
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
}
