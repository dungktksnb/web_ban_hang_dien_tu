package com.example.web_ban_hang.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity

public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tenSanPham;
    private double gia;
    private String moTaSanPham;
    @ManyToOne
    private ThuongHieu thuongHieu;

    private String anhs;

    public SanPham() {
    }

    public SanPham(long id, String tenSanPham, double gia, String moTaSanPham, ThuongHieu thuongHieu, String anhs) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.moTaSanPham = moTaSanPham;
        this.thuongHieu = thuongHieu;
        this.anhs = anhs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public ThuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getAnhs() {
        return anhs;
    }

    public void setAnhs(String anhs) {
        this.anhs = anhs;
    }
}