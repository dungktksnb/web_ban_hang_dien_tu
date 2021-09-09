package com.example.web_ban_hang.service;


import com.example.web_ban_hang.model.NguoiDung;
import com.example.web_ban_hang.repository.IRepoNguongDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceNguoiDung implements IServiceNguoiDung{
    @Autowired
    IRepoNguongDung iRepoNguongDung;
    @Override
    public List<NguoiDung> findAll() {
        return (List<NguoiDung>) iRepoNguongDung.findAll();
    }

    @Override
    public NguoiDung findById(long id) {
        return iRepoNguongDung.findById(id).get();
    }

    @Override
    public NguoiDung save(NguoiDung nguoiDung) {
        return iRepoNguongDung.save(nguoiDung);
    }

    @Override
    public void remove(NguoiDung nguoiDung) {
        iRepoNguongDung.delete(nguoiDung);

    }
}
