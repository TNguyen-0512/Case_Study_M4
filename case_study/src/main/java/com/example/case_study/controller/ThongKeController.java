package com.example.case_study.controller;

import com.example.case_study.service.IDonHangService;
import com.example.case_study.service.IChiTietNhapKhoService;
import com.example.case_study.service.IChiTietDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/admin/thong-ke")
public class ThongKeController {

    @Autowired
    private IDonHangService donHangService;

    @Autowired
    private IChiTietNhapKhoService chiTietNhapKhoService;

    @Autowired
    private IChiTietDonHangService chiTietDonHangService;

    @GetMapping("/doanh-thu-tong")
    public BigDecimal tongDoanhThu() {
        return donHangService.tongDoanhThu();
    }

    @GetMapping("/doanh-thu-theo-thang")
    public List<Object[]> doanhThuTheoThang() {
        return donHangService.doanhThuTheoThang();
    }

    @GetMapping("/nhap-kho-theo-laptop")
    public List<Object[]> soLuongNhapTheoLaptop() {
        return chiTietNhapKhoService.soLuongNhapTheoLaptop();
    }

    @GetMapping("/nhap-kho-theo-thang")
    public List<Object[]> soLuongNhapTheoThang() {
        return chiTietNhapKhoService.soLuongNhapTheoThang();
    }

    @GetMapping("/xuat-kho-theo-laptop")
    public List<Object[]> soLuongXuatTheoLaptop() {
        return chiTietDonHangService.soLuongXuatTheoLaptop();
    }

    @GetMapping("/xuat-kho-theo-thang")
    public List<Object[]> soLuongXuatTheoThang() {
        return chiTietDonHangService.soLuongXuatTheoThang();
    }
}
