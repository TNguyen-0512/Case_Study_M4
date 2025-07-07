package com.example.case_study.service;

import com.example.case_study.model.TaiKhoanDangNhap;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final TaiKhoanDangNhap user;

    public CustomUserDetails(TaiKhoanDangNhap user) {
        this.user = user;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        // Spring mặc định prefix ROLE_
        String role = "ROLE_" + user.getVaiTro().getTenVaiTro();
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return user.getMatKhau();
    }

    @Override
    public String getUsername() {
        return user.getTenDangNhap();
    }

    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled()               { return true; }
}
