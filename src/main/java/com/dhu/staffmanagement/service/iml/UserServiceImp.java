package com.dhu.staffmanagement.service.iml;

import com.github.pagehelper.PageHelper;
import com.dhu.staffmanagement.dao.UserDao;
import com.dhu.staffmanagement.entity.User;
import com.dhu.staffmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public List<User> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void addUserRole(int id) {
        dao.addUserRole(id);
    }

    @Override
    public void addAdminRole(int id) {
        dao.addAdminRole(id);
    }

    @Override
    public List<User> findByName(String name)
    {
        return dao.findByName("%"+name+"%");
    }
}
