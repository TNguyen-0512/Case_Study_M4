package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@Table(name = "chi_tiet_nhap_kho")
public class ChiTietNhapKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChiTietNhap;

    @ManyToOne
    @JoinColumn(name = "id_phieu_nhap")
    private PhieuNhapKho phieuNhapKho;

    @ManyToOne
    @JoinColumn(name = "id_laptop")
    private Laptop laptop;

    private Integer soLuongNhap;

    private BigDecimal giaNhap;

    private BigDecimal thanhTien;

    private Date ngaySanXuat;

    private Date hanBaoHanh;
}

