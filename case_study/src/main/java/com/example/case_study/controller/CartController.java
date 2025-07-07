package com.example.case_study.controller;

import com.example.case_study.model.*;
import com.example.case_study.service.CartService;
import com.example.case_study.service.IDonHangService;
import com.example.case_study.service.ILaptopService;
import com.example.case_study.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ILaptopService laptopService;

    @Autowired
    private KhachHangService khachHangService;

    private CartService getCart(HttpSession session) {
        CartService cart = (CartService) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartService();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @GetMapping
    public String hienThiGioHang(HttpSession session, Model model) {
        CartService cart = getCart(session);
        model.addAttribute("cartItems", cart.getAll());
        model.addAttribute("tongTien", cart.getTongTien());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String themVaoGio(@PathVariable Long id,
                             @RequestParam(defaultValue = "1") int soLuong,
                             HttpSession session) {
        Laptop laptop = laptopService.findById(id);
        if (laptop != null) {
            getCart(session).add(laptop, soLuong);
        }
        return "redirect:/cart";
    }

    @GetMapping("/api/add/{id}")
    @ResponseBody
    public ResponseEntity<Integer> themVaoGioAjax(@PathVariable Long id,
                                                  @RequestParam(defaultValue = "1") int soLuong,
                                                  HttpSession session) {
        Laptop laptop = laptopService.findById(id);
        if (laptop != null) {
            getCart(session).add(laptop, soLuong);
        }
        return ResponseEntity.ok(getCart(session).getSoLuongTong());
    }

    @PostMapping("/update/{id}")
    public String capNhatSoLuong(@PathVariable Long id,
                                 @RequestParam("soLuong") int soLuong,
                                 HttpSession session) {
        getCart(session).update(id, soLuong);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{id}")
    public String xoaKhoiGio(@PathVariable Long id, HttpSession session) {
        getCart(session).remove(id);
        return "redirect:/cart";
    }

    // Bước 1: Xác nhận thanh toán
    @PostMapping("/checkout")
    public String xacNhanThanhToan(@RequestParam(value = "selectedIds", required = false) Long[] selectedIds,
                                   HttpSession session,
                                   Model model,
                                   Principal principal) {
        CartService cart = getCart(session);

        if (selectedIds == null || selectedIds.length == 0) {
            model.addAttribute("message", "Bạn chưa chọn sản phẩm nào để thanh toán.");
            model.addAttribute("cartItems", cart.getAll());
            model.addAttribute("tongTien", cart.getTongTien());
            return "cart";
        }

        List<CartItem> selectedItems = cart.getAll().stream()
                .filter(item -> Arrays.asList(selectedIds).contains(item.getId()))
                .collect(Collectors.toList());

        BigDecimal tongTien = selectedItems.stream()
                .map(CartItem::getTongTien)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (principal != null) {
            String username = principal.getName();
            KhachHang khachHang = khachHangService.findByUsername(username);
            model.addAttribute("khachHang", khachHang);
        }

        model.addAttribute("selectedItems", selectedItems);
        model.addAttribute("tongTien", tongTien);

        return "checkout-confirmation"; // Trang xác nhận trước khi mua thật
    }
    @Autowired
    private IDonHangService donHangService;


    @PostMapping("/confirm")
    public String hoanTatThanhToan(@RequestParam("ids") Long[] ids,
                                   @RequestParam("phuongThucThanhToan") String phuongThucThanhToanStr,
                                   HttpSession session,
                                   Model model,
                                   Principal principal) {
        CartService cart = getCart(session);
        List<CartItem> daMua = cart.getAll().stream()
                .filter(item -> Arrays.asList(ids).contains(item.getId()))
                .collect(Collectors.toList());

        if (principal == null) {
            model.addAttribute("message", "Vui lòng đăng nhập để mua hàng.");
            return "redirect:/login";
        }

        String username = principal.getName();
        KhachHang khachHang = khachHangService.findByUsername(username);

        // Parse phương thức thanh toán từ chuỗi sang Enum
        DonHang.PhuongThucThanhToan phuongThuc;
        try {
            phuongThuc = DonHang.PhuongThucThanhToan.valueOf(phuongThucThanhToanStr);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Phương thức thanh toán không hợp lệ.");
            return "checkout-confirmation";
        }

        // Tạo đơn hàng
        DonHang donHang = new DonHang();
        donHang.setMaDonHang("DH" + System.currentTimeMillis());
        donHang.setKhachHang(khachHang);
        donHang.setTenNguoiNhan(khachHang.getHoTen());
        donHang.setEmailNguoiNhan(khachHang.getEmail());
        donHang.setSoDienThoaiNguoiNhan(khachHang.getSoDienThoai());
        donHang.setDiaChiGiaoHang(khachHang.getDiaChi());
        donHang.setNgayDatHang(new java.sql.Timestamp(System.currentTimeMillis()));
        donHang.setTrangThaiDonHang(DonHang.TrangThaiDonHang.Cho_xac_nhan);
        donHang.setTrangThaiThanhToan(DonHang.TrangThaiThanhToan.Chua_thanh_toan);
        donHang.setPhuongThucThanhToan(phuongThuc); // <-- set theo người chọn

        BigDecimal tongTien = daMua.stream()
                .map(CartItem::getTongTien)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        donHang.setTongTienHang(tongTien);
        donHang.setPhiVanChuyen(BigDecimal.valueOf(30000));
        donHang.setTienGiamGia(BigDecimal.ZERO);
        donHang.setTongThanhToan(tongTien.add(donHang.getPhiVanChuyen()));

        List<ChiTietDonHang> chiTietList = daMua.stream().map(item -> {
            ChiTietDonHang ct = new ChiTietDonHang();
            ct.setDonHang(donHang);
            ct.setLaptop(laptopService.findById(item.getId()));
            ct.setSoLuong(item.getSoLuong());
            ct.setGia(item.getGia());
            return ct;
        }).collect(Collectors.toList());

        donHang.setChiTietDonHangList(chiTietList);

        donHangService.save(donHang);

        daMua.forEach(item -> cart.remove(item.getId()));

        model.addAttribute("message", "🎉 Đặt hàng thành công! Đơn hàng đang chờ xác nhận.");
        return "checkout-success";
    }


}
