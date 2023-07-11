package com.dhu.staffmanagement.service.iml;

import com.dhu.staffmanagement.entity.Personnel;
import com.dhu.staffmanagement.service.PersonnelService;
import com.github.pagehelper.PageHelper;
import com.dhu.staffmanagement.dao.PersonnelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PersonnelServiceImp implements PersonnelService {
    @Autowired
    PersonnelDao dao;
    @Override
    public List<Personnel> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void add(Personnel personnel) {
        dao.add(personnel);
    }


    @Override
    public Personnel findById(int id) {
        return dao.findById(id);
    }

    @Override
    public int number() {
        return dao.number();
    }


}
