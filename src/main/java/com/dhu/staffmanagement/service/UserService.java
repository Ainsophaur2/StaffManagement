package com.dhu.staffmanagement.service;

import com.dhu.staffmanagement.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //根据账号查找用户
    public User findByUsername(String username);
    //添加用户
    public void addUser(User user);
    //删除用户
    public void deleteUser(int id);
    //查找所有用户
    public List<User> findAll(int page,int size);
    //添加普通用户
    public void addUserRole(int id);

    //为账号添加超级管理者权限
    public void addAdminRole(int id);

    public List<User> findByName(String name);

}
