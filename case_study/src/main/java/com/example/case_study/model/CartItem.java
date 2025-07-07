package com.example.case_study.model;

import java.math.BigDecimal;

public class CartItem {
    private Long id;
    private String tenLaptop;
    private String hinhAnh;
    private BigDecimal gia;
    private int soLuong;

    public CartItem(Long id, String tenLaptop, String hinhAnh, BigDecimal gia, int soLuong) {
        this.id = id;
        this.tenLaptop = tenLaptop;
        this.hinhAnh = hinhAnh;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public BigDecimal getTongTien() {
        return gia.multiply(BigDecimal.valueOf(soLuong));
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenLaptop() {
        return tenLaptop;
    }

    public void setTenLaptop(String tenLaptop) {
        this.tenLaptop = tenLaptop;
    }
    public CartItem() {
    }
    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", tenLaptop='" + tenLaptop + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                '}';
    }

}
