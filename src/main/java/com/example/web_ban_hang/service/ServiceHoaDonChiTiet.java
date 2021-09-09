package com.example.web_ban_hang.service;

import com.example.web_ban_hang.model.HoaDonChiTiet;
import com.example.web_ban_hang.repository.IRepoHoaDonChiTiet;
import com.example.web_ban_hang.model.HoaDonChiTiet;
import com.example.web_ban_hang.repository.IRepoHoaDonChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceHoaDonChiTiet implements IServiceHoaDonChiTiet {
    @Autowired
    IRepoHoaDonChiTiet iRepoHoaDonChiTiet;

    @Override
    public List<HoaDonChiTiet> findAll() {
        return (List<HoaDonChiTiet>) iRepoHoaDonChiTiet.findAll();
    }

    @Override
    public HoaDonChiTiet findById(long id) {
        return iRepoHoaDonChiTiet.findById(id).get();
    }


    @Override
    public HoaDonChiTiet save(HoaDonChiTiet hoaDonChiTiet) {
        return iRepoHoaDonChiTiet.save(hoaDonChiTiet);
    }

    @Override
    public void remove(HoaDonChiTiet hoaDonChiTiet) {
        iRepoHoaDonChiTiet.delete(hoaDonChiTiet);

    }
}
