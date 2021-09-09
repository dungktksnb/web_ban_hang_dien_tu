package com.example.web_ban_hang.service;



import com.example.web_ban_hang.model.Anh;

import java.util.List;

public interface IServicesAnh {
    List<Anh> findAll();

    Anh findById(long id);

    Anh save(Anh anh);

    void remove(Anh anh);
}
