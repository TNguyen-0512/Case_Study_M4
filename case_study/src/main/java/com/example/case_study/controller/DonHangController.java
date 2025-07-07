// DonHangController.java
package com.example.case_study.controller;

import com.example.case_study.model.DonHang;
import com.example.case_study.model.KhachHang;
import com.example.case_study.service.IDonHangService;
import com.example.case_study.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class DonHangController {

    @Autowired
    private IDonHangService donHangService;

    @Autowired
    private IKhachHangService khachHangService;


    @GetMapping("/don-hang")
    public String xemDonHang(Model model, Principal principal) {
        String username = principal.getName();
        KhachHang khachHang = khachHangService.findByUsername(username);
        List<DonHang> donHangList = donHangService.findByKhachHangId(khachHang.getIdKhachHang());

        model.addAttribute("donHangs", donHangList);
        model.addAttribute("donHangService", donHangService); // Thêm service vào model
        return "don-hang";
    }

}
