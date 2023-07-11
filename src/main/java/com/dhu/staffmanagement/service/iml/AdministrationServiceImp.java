package com.dhu.staffmanagement.service.iml;

import com.dhu.staffmanagement.entity.Administration;
import com.github.pagehelper.PageHelper;
import com.dhu.staffmanagement.dao.AdministrationDao;
import com.dhu.staffmanagement.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class AdministrationServiceImp implements AdministrationService {
    @Autowired
    AdministrationDao dao;
    @Override
    public void add(Administration administration) {
        dao.add(administration);
    }

    @Override
    public List<Administration> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Administration get(int id) {


        Administration administration = dao.findById(id);
        return administration;
    }

    @Override
    public int number() {
        return dao.number();
    }


    @Override
    public List<Administration> findByName(String name) {
        return dao.findByName(name);
    }

}
