package com.example.web_ban_hang.model;

import javax.persistence.*;

@Entity

public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private NguoiDung nguoiDung;
    @ManyToOne
    private HoaDonChiTiet hoaDonChiTiet;
    private int status;

    public HoaDon() {
    }

    public HoaDon(long id, NguoiDung nguoiDung, HoaDonChiTiet hoaDonChiTiet, int status) {
        this.id = id;
        this.nguoiDung = nguoiDung;
        this.hoaDonChiTiet = hoaDonChiTiet;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public HoaDonChiTiet getHoaDonChiTiet() {
        return hoaDonChiTiet;
    }

    public void setHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
