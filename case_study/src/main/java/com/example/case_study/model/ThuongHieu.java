package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "thuong_hieu")
@Getter
@Setter
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thuong_hieu")
    private Integer idThuongHieu;

    @Column(name = "ten_thuong_hieu", length = 50, nullable = false, unique = true)
    private String tenThuongHieu;

    @Column(name = "quoc_gia", length = 50)
    private String quocGia;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "logo", length = 255)
    private String logo;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", length = 20)
    private TrangThai trangThai = TrangThai.Hoạt_động;

    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao = LocalDateTime.now();

    public enum TrangThai {
        Hoạt_động, Ngừng_hoạt_động
    }
}

