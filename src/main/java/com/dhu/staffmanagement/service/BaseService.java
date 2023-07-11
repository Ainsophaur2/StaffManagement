package com.dhu.staffmanagement.service;

import com.dhu.staffmanagement.entity.Base;

import java.util.List;

public interface BaseService {
    //查找所有基本信息
    public List<Base> findAll();

    public Base findById(int id);

    public void  delete(int id);

    public void add(Base base);

    public Base findByIdCard(String idCard);

    public void update(Base base);

}
