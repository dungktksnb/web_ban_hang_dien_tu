package com.example.web_ban_hang.service;

import com.example.web_ban_hang.model.HoaDon;
import com.example.web_ban_hang.repository.IRePoHoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceHoaDon implements IServiceHoaDon{
    @Autowired
    IRePoHoaDon iRePoHoaDon;

    @Override
    public List<HoaDon> findAll() {
        return (List<HoaDon>) iRePoHoaDon.findAll();
    }

    @Override
    public HoaDon findById(long id) {
        return iRePoHoaDon.findById(id).get();
    }

    @Override
    public HoaDon save(HoaDon hoaDon) {
        return iRePoHoaDon.save(hoaDon);
    }

    @Override
    public void remove(HoaDon hoaDon) {
        iRePoHoaDon.delete(hoaDon);

    }
}
