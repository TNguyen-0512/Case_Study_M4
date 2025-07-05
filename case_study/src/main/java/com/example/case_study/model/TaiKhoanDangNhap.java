package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "nguoi_dung")
@Getter
@Setter
public class TaiKhoanDangNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nguoi_dung")
    private Integer idNguoiDung;

    @Column(name = "ten_dang_nhap", length = 50, nullable = false, unique = true)
    private String tenDangNhap;

    @Column(name = "mat_khau", length = 255, nullable = false)
    private String matKhau;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vai_tro", nullable = false)
    private VaiTro vaiTro;
}
