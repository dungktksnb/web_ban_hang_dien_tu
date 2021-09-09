package com.example.web_ban_hang.service;
import com.example.web_ban_hang.model.Role;
import com.example.web_ban_hang.repository.IRePoRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceRole implements IServieRole{
    @Autowired
    IRePoRole iRePoRole;
    @Override
    public List<Role> findAll() {
        return (List<Role>) iRePoRole.findAll();
    }

    @Override
    public Role findById(long id) {
        return iRePoRole.findById(id).get();
    }

    @Override
    public Role save(Role role) {
        return iRePoRole.save(role);
    }

    @Override
    public void remove(Role role) {
        iRePoRole.delete(role);

    }
}
