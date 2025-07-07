package com.example.case_study.controller;

import com.example.case_study.repository.DonHangRepository;
import com.example.case_study.repository.KhachHangRepository;
import com.example.case_study.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin/he-thong")
public class HeThongController {

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("/hieu-suat")
    public String hieuSuat(Model model) {
        model.addAttribute("serverTime", LocalDateTime.now());
        model.addAttribute("tongDonHang", donHangRepository.count());
        model.addAttribute("tongKhachHang", khachHangRepository.count());
        model.addAttribute("tongNhanVien", nhanVienRepository.count());
        model.addAttribute("uptime", "3 ngày 5 giờ 20 phút"); // Giả sử bạn muốn hiển thị tạm
        return "admin/he-thong/hieu-suat";
    }
}
