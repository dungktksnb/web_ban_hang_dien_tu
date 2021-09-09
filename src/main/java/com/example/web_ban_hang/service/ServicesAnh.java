package com.example.web_ban_hang.service;

import com.example.web_ban_hang.model.Anh;
import com.example.web_ban_hang.repository.IRePoAnh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesAnh implements IServicesAnh {
    @Autowired IRePoAnh iRePoAnh;

    @Override
    public List<Anh> findAll() {
        return (List<Anh>) iRePoAnh.findAll();
    }

    @Override
    public Anh findById(long id) {
        return iRePoAnh.findById(id).get();
    }

    @Override
    public Anh save(Anh anh) {
        return iRePoAnh.save(anh);
    }

    @Override
    public void remove(Anh anh) {
        iRePoAnh.delete(anh);

    }
}
