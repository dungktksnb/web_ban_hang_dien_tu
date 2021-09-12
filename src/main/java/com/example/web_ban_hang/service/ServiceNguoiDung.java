package com.example.web_ban_hang.service;


import com.example.web_ban_hang.model.NguoiDung;
import com.example.web_ban_hang.repository.IRepoNguongDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ServiceNguoiDung implements IServiceNguoiDung, UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung user = iRepoNguongDung.findByTaiKhoan(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) user.getRole());

        UserDetails userDetails = new User(
                user.getTaiKhoan(),
                user.getMatKhau(),
                authorities
        );

        return userDetails ;
    }
}
