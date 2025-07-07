package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "hinh_anh_laptop")
@Getter
@Setter
public class HinhAnhLaptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hinh_anh")
    private Integer idHinhAnh;

    @ManyToOne
    @JoinColumn(name = "id_laptop")
    private Laptop laptop;

    @Column(name = "duong_dan_hinh", length = 255, nullable = false)
    private String duongDanHinh;

    @Column(name = "alt_text", length = 255)
    private String altText;

    @Column(name = "thu_tu_hien_thi")
    private Integer thuTuHienThi = 0;

    @Column(name = "la_hinh_chinh")
    private Boolean laHinhChinh = false;

    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao = LocalDateTime.now();
}

