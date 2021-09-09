package com.example.web_ban_hang.service;


import com.example.web_ban_hang.model.HoaDon;

public interface IServiceHoaDon {
    Iterable<HoaDon> findAll();

    HoaDon findById(long id);

    HoaDon save(HoaDon hoaDon);

    void remove(HoaDon hoaDon);


}
