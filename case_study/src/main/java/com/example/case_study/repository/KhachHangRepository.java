package com.example.case_study.repository;

import com.example.case_study.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {

    // Kiểm tra email đã tồn tại chưa
    boolean existsByEmail(String email);


    // Tìm khách hàng theo tên đăng nhập của tài khoản liên kết
    KhachHang findByTaiKhoan_TenDangNhap(String tenDangNhap);
}
