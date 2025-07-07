package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chi_tiet_don_hang")
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChiTiet;

    @ManyToOne
    @JoinColumn(name = "id_don_hang")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "id_laptop")
    private Laptop laptop;

    private String tenLaptop;

    private BigDecimal giaBan;

    private Integer soLuong;

    private BigDecimal thanhTien;
}

