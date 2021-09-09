package com.example.web_ban_hang.model;

import javax.persistence.*;

@Entity

public class Anh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tenAnh;
    @ManyToOne
    private SanPham sanPham;

    public Anh() {
    }

    public Anh(long id, String tenAnh, SanPham sanPham) {
        this.id = id;
        this.tenAnh = tenAnh;
        this.sanPham = sanPham;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
