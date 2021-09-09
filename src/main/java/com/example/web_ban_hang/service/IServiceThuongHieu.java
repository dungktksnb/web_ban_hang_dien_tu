package com.example.web_ban_hang.service;


import com.example.web_ban_hang.model.ThuongHieu;

import java.util.List;

public interface IServiceThuongHieu {
    List<ThuongHieu> findAll();

    ThuongHieu findById(long id);

    ThuongHieu save(ThuongHieu thuongHieu);

    void remove(ThuongHieu thuongHieu);
}
