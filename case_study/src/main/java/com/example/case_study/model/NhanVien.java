package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nhan_vien")
    private Integer idNhanVien;

    @Column(name = "ho_ten", length = 100, nullable = false)
    private String hoTen;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "so_dien_thoai", length = 15)
    private String soDienThoai;

    @Column(name = "dia_chi", columnDefinition = "TEXT")
    private String diaChi;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Enumerated(EnumType.STRING)
    @Column(name = "gioi_tinh", length = 10)
    private GioiTinh gioiTinh;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tai_khoan", unique = true)
    private TaiKhoanDangNhap taiKhoan;

    public enum GioiTinh {
        Nam, Nữ, Khác
    }
}

