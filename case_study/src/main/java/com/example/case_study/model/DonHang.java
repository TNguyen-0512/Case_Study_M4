package com.example.case_study.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDonHang;

    @Column(nullable = false, unique = true)
    private String maDonHang;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    private String tenNguoiNhan;
    private String emailNguoiNhan;
    private String soDienThoaiNguoiNhan;
    private String diaChiGiaoHang;

    private BigDecimal tongTienHang;
    private BigDecimal phiVanChuyen;
    private BigDecimal tienGiamGia;
    private BigDecimal tongThanhToan;

    @Enumerated(EnumType.STRING)
    private TrangThaiDonHang trangThaiDonHang;

    @Enumerated(EnumType.STRING)
    private PhuongThucThanhToan phuongThucThanhToan;

    @Enumerated(EnumType.STRING)
    private TrangThaiThanhToan trangThaiThanhToan;

    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien_xu_ly")
    private NhanVien nhanVienXuLy;

    private Timestamp ngayDatHang;
    private Timestamp ngayXacNhan;
    private Timestamp ngayGiaoHang;
    private Timestamp ngayHoanThanh;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> chiTietDonHangList;

    // Thêm method này để tự động set ngày tạo
    @PrePersist
    public void prePersist() {
        if (ngayDatHang == null) {
            ngayDatHang = new Timestamp(System.currentTimeMillis());
        }
        if (trangThaiDonHang == null) {
            trangThaiDonHang = TrangThaiDonHang.Cho_xac_nhan;
        }
        if (trangThaiThanhToan == null) {
            trangThaiThanhToan = TrangThaiThanhToan.Chua_thanh_toan;
        }
    }

    public enum TrangThaiDonHang {
        Cho_xac_nhan, Da_xac_nhan, Dang_chuan_bi, Dang_giao, Da_giao, Da_huy, Tra_hang
    }

    public enum PhuongThucThanhToan {
        Tien_mat, Chuyen_khoan, The_tin_dung, Vi_dien_tu
    }

    public enum TrangThaiThanhToan {
        Chua_thanh_toan, Da_thanh_toan, Thanh_toan_mot_phan, Hoan_tien
    }
}