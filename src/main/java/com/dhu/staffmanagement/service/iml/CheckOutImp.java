package com.dhu.staffmanagement.service.iml;

import com.dhu.staffmanagement.dao.CheckOutDao;
import com.dhu.staffmanagement.entity.CheckOut;
import com.dhu.staffmanagement.service.CheckOutService;
import com.github.pagehelper.PageHelper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutImp implements CheckOutService {

    @Autowired
    CheckOutDao dao;

    @Override
    public void add(CheckOut checkOut) {
        dao.add(checkOut);
    }

    @Override
    public List<CheckOut> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public List<CheckOut> findByName(String name) {
        return dao.findByName(name);
    }
}
