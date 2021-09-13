package com.example.web_ban_hang.service;

import com.example.web_ban_hang.model.SanPham;
import com.example.web_ban_hang.repository.IRepoSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceSanPham implements IServiceSanPham{
    @Autowired
    IRepoSanPham iRepoSanPham;
    @Override
    public List<SanPham> findAll() {
        return (List<SanPham>) iRepoSanPham.findAll();
    }

    @Override
    public SanPham findById(long id) {
        return iRepoSanPham.findById(id).get();
    }

    @Override
    public SanPham save(SanPham sanPham) {
        return iRepoSanPham.save(sanPham);
    }

    @Override
    public void remove(SanPham sanPham) {
        iRepoSanPham.delete(sanPham);
    }
}
