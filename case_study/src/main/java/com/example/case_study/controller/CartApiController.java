package com.example.case_study.controller;

import com.example.case_study.model.Laptop;
import com.example.case_study.service.CartService;
import com.example.case_study.service.ILaptopService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartApiController {

    @Autowired
    private ILaptopService laptopService;

    private CartService getCart(HttpSession session) {
        CartService cart = (CartService) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartService();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Integer> themVaoGio(@PathVariable Long id,
                                              @RequestParam(defaultValue = "1") int soLuong,
                                              HttpSession session) {
        Laptop laptop = laptopService.findById(id);
        if (laptop != null) {
            getCart(session).add(laptop, soLuong);
        }
        return ResponseEntity.ok(getCart(session).getSoLuongTong());
    }
}
