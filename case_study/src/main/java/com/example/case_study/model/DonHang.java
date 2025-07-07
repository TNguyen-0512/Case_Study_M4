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

    public enum TrangThaiDonHang {
        Cho_xac_nhan,
        Dang_giao,
        Da_giao,
        Huy
    }

    public enum TrangThaiThanhToan {
        Chua_thanh_toan,
        Da_thanh_toan
    }

    public enum PhuongThucThanhToan {
        Tien_mat("Tiền mặt"),
        Chuyen_khoan("Chuyển khoản"),
        The_tin_dung("Thẻ tín dụng"),
        Vi_dien_tu("Ví điện tử");

        private final String value;

        PhuongThucThanhToan(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    public static PhuongThucThanhToan fromString(String text) {
        for (PhuongThucThanhToan pt : PhuongThucThanhToan.values()) {
            if (pt.toString().equalsIgnoreCase(text)) {
                return pt;
            }
        }
        throw new IllegalArgumentException("Không tồn tại phương thức thanh toán: " + text);
    }

    public List<ChiTietDonHang> getChiTietDonHangList() {
        return chiTietDonHangList;
    }

    public void setChiTietDonHangList(List<ChiTietDonHang> chiTietDonHangList) {
        this.chiTietDonHangList = chiTietDonHangList;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public String getEmailNguoiNhan() {
        return emailNguoiNhan;
    }

    public void setEmailNguoiNhan(String emailNguoiNhan) {
        this.emailNguoiNhan = emailNguoiNhan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(Integer idDonHang) {
        this.idDonHang = idDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Timestamp getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Timestamp ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Timestamp getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Timestamp ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public Timestamp getNgayHoanThanh() {
        return ngayHoanThanh;
    }

    public void setNgayHoanThanh(Timestamp ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public Timestamp getNgayXacNhan() {
        return ngayXacNhan;
    }

    public void setNgayXacNhan(Timestamp ngayXacNhan) {
        this.ngayXacNhan = ngayXacNhan;
    }

    public NhanVien getNhanVienXuLy() {
        return nhanVienXuLy;
    }

    public void setNhanVienXuLy(NhanVien nhanVienXuLy) {
        this.nhanVienXuLy = nhanVienXuLy;
    }

    public BigDecimal getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public void setPhiVanChuyen(BigDecimal phiVanChuyen) {
        this.phiVanChuyen = phiVanChuyen;
    }

    public PhuongThucThanhToan getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getSoDienThoaiNguoiNhan() {
        return soDienThoaiNguoiNhan;
    }

    public void setSoDienThoaiNguoiNhan(String soDienThoaiNguoiNhan) {
        this.soDienThoaiNguoiNhan = soDienThoaiNguoiNhan;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public BigDecimal getTienGiamGia() {
        return tienGiamGia;
    }

    public void setTienGiamGia(BigDecimal tienGiamGia) {
        this.tienGiamGia = tienGiamGia;
    }

    public BigDecimal getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(BigDecimal tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }

    public BigDecimal getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(BigDecimal tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public TrangThaiDonHang getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(TrangThaiDonHang trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }

    public TrangThaiThanhToan getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(TrangThaiThanhToan trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }
}
