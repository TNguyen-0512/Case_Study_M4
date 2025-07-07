package com.example.case_study.service;

import com.example.case_study.model.TaiKhoanDangNhap;
import com.example.case_study.repository.TaiKhoanDangNhapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TaiKhoanDetailsService implements UserDetailsService {

    @Autowired
    private TaiKhoanDangNhapRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String trimmedUsername = username.trim();
        System.out.println("Đang tìm username: [" + trimmedUsername + "]");

        TaiKhoanDangNhap taiKhoan = repo.findByTenDangNhap(trimmedUsername)
                .orElseThrow(() -> {
                    System.out.println("Không tìm thấy tài khoản: " + trimmedUsername);
                    return new UsernameNotFoundException("Không tìm thấy tài khoản: " + trimmedUsername);
                });

        System.out.println("Tìm thấy tài khoản: " + taiKhoan.getTenDangNhap());

        String role = "ROLE_" + taiKhoan.getVaiTro().getTenVaiTro().toUpperCase();

        return new User(
                taiKhoan.getTenDangNhap(),
                taiKhoan.getMatKhau(),
                Collections.singleton(new SimpleGrantedAuthority(role))
        );
    }
}
