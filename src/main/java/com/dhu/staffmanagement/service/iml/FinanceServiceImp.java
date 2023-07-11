package com.dhu.staffmanagement.service.iml;

import com.dhu.staffmanagement.dao.FinanceDao;
import com.dhu.staffmanagement.entity.Finance;
import com.dhu.staffmanagement.service.FinanceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FinanceServiceImp implements FinanceService {
    @Autowired
    FinanceDao dao;
    @Override
    public void add(Finance finance) {
        dao.add(finance);
    }

    @Override
    public List<Finance> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Finance get(int id) {
       return dao.findById(id);
    }

    @Override
    public int number() {
        return dao.number();
    }

    @Override
    public List<Finance> findByName(String name) {
        return dao.findByName(name);
    }
}
