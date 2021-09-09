package com.example.web_ban_hang.service;

import com.example.web_ban_hang.model.HoaDonChiTiet;
import com.example.web_ban_hang.model.HoaDonChiTiet;

import java.util.List;

public interface IServiceHoaDonChiTiet {
    List<HoaDonChiTiet> findAll();

    HoaDonChiTiet findById(long id);

    HoaDonChiTiet save(HoaDonChiTiet hoaDonChiTiet);

    void remove(HoaDonChiTiet hoaDonChiTiet);
}
