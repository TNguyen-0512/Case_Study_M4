package com.example.case_study.service;

import com.example.case_study.model.CartItem;
import com.example.case_study.model.Laptop;

import java.math.BigDecimal;
import java.util.*;

public class CartService {
    private final Map<Long, CartItem> cart = new LinkedHashMap<>();

    public void add(Laptop laptop, int soLuong) {
        // Chuyển Integer -> Long để dùng làm key
        Long id = laptop.getIdLaptop().longValue();

        CartItem item = cart.get(id);
        if (item == null) {
            cart.put(id, new CartItem(
                    id,
                    laptop.getTenLaptop(),
                    laptop.getHinhAnhChinh(),
                    laptop.getGiaBan(),
                    soLuong
            ));
        } else {
            item.setSoLuong(item.getSoLuong() + soLuong);
        }
    }

    public void remove(Long id) {
        cart.remove(id);
    }

    public void update(Long id, int soLuong) {
        if (cart.containsKey(id)) {
            cart.get(id).setSoLuong(soLuong);
        }
    }

    public List<CartItem> getAll() {
        return new ArrayList<>(cart.values());
    }

    public BigDecimal getTongTien() {
        return cart.values().stream()
                .map(CartItem::getTongTien)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getSoLuongTong() {
        return cart.values().stream()
                .mapToInt(CartItem::getSoLuong)
                .sum();
    }



}
