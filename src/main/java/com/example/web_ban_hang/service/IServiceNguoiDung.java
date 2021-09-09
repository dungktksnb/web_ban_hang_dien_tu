package com.example.web_ban_hang.service;


import com.example.web_ban_hang.model.NguoiDung;

import java.util.List;

public interface IServiceNguoiDung {
    List<NguoiDung> findAll();

    NguoiDung findById(long id);

    NguoiDung save(NguoiDung nguoiDung);

    void remove(NguoiDung nguoiDung);
}
