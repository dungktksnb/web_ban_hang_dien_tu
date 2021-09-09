package com.example.web_ban_hang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long id_hoaDon;
    private long id_sanPham;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(long id, long id_hoaDon, long id_sanPham) {
        this.id = id;
        this.id_hoaDon = id_hoaDon;
        this.id_sanPham = id_sanPham;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_hoaDon() {
        return id_hoaDon;
    }

    public void setId_hoaDon(long id_hoaDon) {
        this.id_hoaDon = id_hoaDon;
    }

    public long getId_sanPham() {
        return id_sanPham;
    }

    public void setId_sanPham(long id_sanPham) {
        this.id_sanPham = id_sanPham;
    }
}
