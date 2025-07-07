package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "danh_muc")
@Getter
@Setter
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_danh_muc")
    private Integer idDanhMuc;

    @Column(name = "ten_danh_muc", length = 100, nullable = false)
    private String tenDanhMuc;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "thu_tu_hien_thi")
    private Integer thuTuHienThi = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", length = 20)
    private TrangThai trangThai = TrangThai.Hoạt_động;

    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao = LocalDateTime.now();

    public enum TrangThai {
        Hoạt_động, Ẩn
    }
}

