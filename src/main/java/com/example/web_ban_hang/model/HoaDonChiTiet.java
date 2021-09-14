package com.example.web_ban_hang.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class HoaDonChiTiet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private SanPham sanPham;
    private int soLuong;
    private long gia;
    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(SanPham sanPham, int soLuong, long gia) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }
}