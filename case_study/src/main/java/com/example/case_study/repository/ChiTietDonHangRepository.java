package com.example.case_study.repository;

import com.example.case_study.model.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, Integer> {
    @Query(value = "SELECT c.ten_laptop, SUM(c.so_luong) FROM chi_tiet_don_hang c " +
            "JOIN don_hang d ON c.id_don_hang = d.id_don_hang " +
            "WHERE d.trang_thai_don_hang = 'Đã giao' " +
            "GROUP BY c.ten_laptop ORDER BY SUM(c.so_luong) DESC",
            nativeQuery = true)
    List<Object[]> soLuongXuatTheoLaptop();

    @Query(value = "SELECT DATE_FORMAT(d.ngay_dat_hang, '%Y-%m') AS thang, SUM(c.so_luong) " +
            "FROM chi_tiet_don_hang c JOIN don_hang d ON c.id_don_hang = d.id_don_hang " +
            "WHERE d.trang_thai_don_hang = 'Đã giao' " +
            "GROUP BY thang ORDER BY thang",
            nativeQuery = true)
    List<Object[]> soLuongXuatTheoThang();
}
