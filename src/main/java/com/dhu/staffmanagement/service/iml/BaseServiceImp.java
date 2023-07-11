package com.dhu.staffmanagement.service.iml;

import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.service.BaseService;
import com.dhu.staffmanagement.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseServiceImp implements BaseService {

    @Autowired
    BaseDao dao;

    @Override
    public List<Base> findAll() {
        return dao.findAll();
    }

    @Override
    public Base findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void add(Base base) {
        dao.add(base);
    }

    @Override
    public Base findByIdCard(String idCard) {
        return dao.findByIdCard(idCard);
    }

    @Override
    public void update(Base base) {
        dao.update(base);
    }
}
