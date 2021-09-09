package com.example.web_ban_hang.service;


import com.example.web_ban_hang.model.ThuongHieu;
import com.example.web_ban_hang.repository.IRePoThuongHieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceThuongHieu implements IServiceThuongHieu{
    @Autowired
    IRePoThuongHieu iRePoThuongHieu;
    @Override
    public List<ThuongHieu> findAll() {
       return (List<ThuongHieu>) iRePoThuongHieu.findAll();

    }

    @Override
    public ThuongHieu findById(long id) {
        return iRePoThuongHieu.findById(id).get();
    }

    @Override
    public ThuongHieu save(ThuongHieu thuongHieu) {
        return iRePoThuongHieu.save(thuongHieu);
    }

    @Override
    public void remove(ThuongHieu thuongHieu) {
        iRePoThuongHieu.delete(thuongHieu);

    }
}
