package com.example.case_study.controller;

import com.example.case_study.model.ChiTietNhapKho;
import com.example.case_study.model.PhieuNhapKho;
import com.example.case_study.service.INhanVienService;
import com.example.case_study.service.IPhieuNhapKhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/nhap-kho")
public class PhieuNhapKhoViewController {

    @Autowired
    private IPhieuNhapKhoService phieuNhapKhoService;

    @Autowired
    private INhanVienService nhanVienService;

    @GetMapping("/view")
    public String list(Model model) {
        model.addAttribute("phieuNhapKhos", phieuNhapKhoService.findAll());
        return "admin/nhap-kho/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        PhieuNhapKho phieuNhap = new PhieuNhapKho();
        // Chỉ tạo sẵn 1 chi tiết
        phieuNhap.getChiTietNhapKhoList().add(new ChiTietNhapKho());

        model.addAttribute("phieuNhap", phieuNhap);
        model.addAttribute("nhanViens", nhanVienService.findAll());
        return "admin/nhap-kho/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PhieuNhapKho phieuNhap) {
        if (phieuNhap.getChiTietNhapKhoList() != null) {
            phieuNhap.getChiTietNhapKhoList().forEach(ct -> {
                ct.setPhieuNhapKho(phieuNhap);
                if (ct.getGiaNhap() != null && ct.getSoLuongNhap() != null) {
                    ct.setThanhTien(ct.getGiaNhap().multiply(
                            java.math.BigDecimal.valueOf(ct.getSoLuongNhap())));
                } else {
                    ct.setThanhTien(java.math.BigDecimal.ZERO);
                }
            });
        }
        phieuNhapKhoService.save(phieuNhap);
        return "redirect:/admin/nhap-kho/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        phieuNhapKhoService.deleteById(id);
        return "redirect:/admin/nhap-kho/view";
    }

    @GetMapping("/chi-tiet/{id}")
    public String chiTiet(@PathVariable Integer id, Model model) {
        PhieuNhapKho phieuNhap = phieuNhapKhoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu nhập kho"));
        model.addAttribute("phieuNhap", phieuNhap);
        return "admin/nhap-kho/chi-tiet";
    }
}
