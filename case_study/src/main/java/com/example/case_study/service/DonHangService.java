package com.example.case_study.service;

import com.example.case_study.model.DonHang;
import com.example.case_study.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public
class DonHangService implements IDonHangService {

    @Autowired
    private DonHangRepository donHangRepository;

    @Override
    public BigDecimal tongDoanhThu() {
        return donHangRepository.tongDoanhThu();
    }

    @Override
    public List<Object[]> doanhThuTheoThang() {
        return donHangRepository.doanhThuTheoThang();
    }
    @Override
    public List<DonHang> findByKhachHangId(Integer idKhachHang) {
        return donHangRepository.findByKhachHang_IdKhachHang(idKhachHang);
    }
    @Override
    public DonHang save(DonHang donHang) {
        return donHangRepository.save(donHang);
    }
    public String getBadgeColor(DonHang.TrangThaiDonHang trangThai) {
        return switch (trangThai) {
            case Cho_xac_nhan -> "warning";
            case Dang_giao -> "primary";
            case Da_giao -> "success";
            default -> "secondary";
        };
    }
    public String getStatusDisplayName(DonHang.TrangThaiDonHang trangThai) {
        return switch (trangThai) {
            case Cho_xac_nhan -> "Chờ xác nhận";
            case Dang_giao -> "Đang giao";
            case Da_giao -> "Đã giao";
            case Huy -> "Đã hủy";
        };
    }

    public String getPaymentStatusDisplayName(DonHang.TrangThaiThanhToan trangThai) {
        return switch (trangThai) {
            case Chua_thanh_toan -> "Chưa thanh toán";
            case Da_thanh_toan -> "Đã thanh toán";
        };
    }
}
