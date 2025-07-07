package com.example.case_study.controller;

import com.example.case_study.dto.RegisterForm;
import com.example.case_study.model.KhachHang;
import com.example.case_study.model.TaiKhoanDangNhap;
import com.example.case_study.model.VaiTro;
import com.example.case_study.service.KhachHangService;
import com.example.case_study.service.TaiKhoanDangNhapService;
import com.example.case_study.service.VaiTroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private TaiKhoanDangNhapService taiKhoanService;

    @Autowired
    private VaiTroService vaiTroService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerProcess(
            @ModelAttribute("registerForm") @Valid RegisterForm form,
            BindingResult bindingResult,
            Model model) {

        // Kiểm tra xác nhận mật khẩu
        if (!form.getMatKhau().equals(form.getXacNhanMatKhau())) {
            bindingResult.rejectValue("xacNhanMatKhau", null, "Mật khẩu xác nhận không khớp");
        }

        // Kiểm tra tên đăng nhập
        if (taiKhoanService.existsByTenDangNhap(form.getTenDangNhap())) {
            bindingResult.rejectValue("tenDangNhap", null, "Tên đăng nhập đã tồn tại");
        }

        // Kiểm tra email đã dùng
        if (khachHangService.existsByEmail(form.getEmail())) {
            bindingResult.rejectValue("email", null, "Email đã được sử dụng");
        }

        // Nếu có lỗi, quay lại form
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        // Tạo tài khoản và khách hàng
        try {
            VaiTro vaiTroKhachHang = vaiTroService.findByTenVaiTro("KHÁCH HÀNG");

            TaiKhoanDangNhap taiKhoan = new TaiKhoanDangNhap();
            taiKhoan.setTenDangNhap(form.getTenDangNhap());
            taiKhoan.setMatKhau(passwordEncoder.encode(form.getMatKhau()));
            taiKhoan.setVaiTro(vaiTroKhachHang);

            TaiKhoanDangNhap savedTaiKhoan = taiKhoanService.save(taiKhoan);

            KhachHang khachHang = new KhachHang();
            khachHang.setHoTen(form.getHoTen());
            khachHang.setEmail(form.getEmail());
            khachHang.setSoDienThoai(form.getSoDienThoai());
            khachHang.setDiaChi(form.getDiaChi());
            khachHang.setTaiKhoan(savedTaiKhoan);

            khachHangService.save(khachHang);

            model.addAttribute("success", "Đăng ký thành công! Vui lòng đăng nhập.");
            return "auth/login";

        } catch (Exception e) {
            bindingResult.reject(null, "Đã xảy ra lỗi: " + e.getMessage());
            return "auth/register";
        }
    }
}
