package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "phieu_nhap_kho")
public class PhieuNhapKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phieu_nhap")
    private Integer idPhieuNhap;

    @Column(name = "ma_phieu_nhap", nullable = false, unique = true, length = 20)
    private String maPhieuNhap;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien_nhap")
    private NhanVien nhanVienNhap;

    @Column(name = "nha_cung_cap", length = 200)
    private String nhaCungCap;

    @Column(name = "tong_tien", precision = 15, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "ngay_nhap")
    private LocalDateTime ngayNhap = LocalDateTime.now();

    @OneToMany(mappedBy = "phieuNhapKho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietNhapKho> chiTietNhapKhoList = new ArrayList<>();
}
