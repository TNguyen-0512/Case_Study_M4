package com.example.case_study.service;


import com.example.case_study.model.TaiKhoanDangNhap;
import com.example.case_study.repository.TaiKhoanDangNhapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private TaiKhoanDangNhapRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
        Optional<TaiKhoanDangNhap> user = userRepo.findByTenDangNhap(tenDangNhap);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Không tìm thấy user: " + tenDangNhap);
        }
        return new CustomUserDetails(user.orElse(null));
    }
}
