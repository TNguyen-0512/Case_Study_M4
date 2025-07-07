package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKhachHang;

    private String hoTen;

    @Column(unique = true)
    private String email;

    private String soDienThoai;

    @Lob
    private String diaChi;

    private Date ngaySinh;

    @Enumerated(EnumType.STRING)
    private GioiTinh gioiTinh;

    @OneToOne
    @JoinColumn(name = "id_tai_khoan")
    private TaiKhoanDangNhap taiKhoanDangNhap;

    public enum GioiTinh {
        Nam, Nữ, Khác
    }
}

