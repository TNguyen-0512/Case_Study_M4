package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "laptop")
@Getter
@Setter
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laptop")
    private Integer idLaptop;

    @Column(name = "ten_laptop", length = 200, nullable = false)
    private String tenLaptop;

    @Column(name = "model", length = 100)
    private String model;

    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;

    @Column(name = "gia_ban", precision = 15, scale = 2, nullable = false)
    private BigDecimal giaBan;

    @Column(name = "gia_nhap", precision = 15, scale = 2)
    private BigDecimal giaNhap;

    @Column(name = "cpu", length = 100)
    private String cpu;

    @Column(name = "ram", length = 50)
    private String ram;

    @Column(name = "o_cung", length = 100)
    private String oCung;

    @Column(name = "card_do_hoa", length = 100)
    private String cardDoHoa;

    @Column(name = "man_hinh", length = 100)
    private String manHinh;

    @Column(name = "pin", length = 50)
    private String pin;

    @Column(name = "trong_luong", length = 20)
    private String trongLuong;

    @Column(name = "he_dieu_hanh", length = 50)
    private String heDieuHanh;

    @Column(name = "mau_sac", length = 50)
    private String mauSac;

    @Column(name = "mo_ta_ngan", columnDefinition = "TEXT")
    private String moTaNgan;

    @Column(name = "mo_ta_chi_tiet", columnDefinition = "LONGTEXT")
    private String moTaChiTiet;

    @Column(name = "hinh_anh_chinh", length = 255)
    private String hinhAnhChinh;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon = 0;

    @Column(name = "so_luong_ban")
    private Integer soLuongBan = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", length = 20)
    private TrangThai trangThai = TrangThai.Còn_hàng;

    @Column(name = "slug", length = 255, unique = true)
    private String slug;

    @Column(name = "meta_title", length = 255)
    private String metaTitle;

    @Column(name = "meta_description", columnDefinition = "TEXT")
    private String metaDescription;

    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao = LocalDateTime.now();

    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat = LocalDateTime.now();

    @Column(name = "ngay_ra_mat")
    private LocalDate ngayRaMat;

    public enum TrangThai {
        Còn_hàng, Hết_hàng, Ngừng_bán, Sắp_về
    }
    @OneToMany(mappedBy = "laptop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HinhAnhLaptop> hinhAnhPhu;

}

