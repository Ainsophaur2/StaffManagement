package com.dhu.staffmanagement.service.iml;

import com.dhu.staffmanagement.entity.Technology;
import com.github.pagehelper.PageHelper;
import com.dhu.staffmanagement.dao.TechnologyDao;
import com.dhu.staffmanagement.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImp implements TechnologyService {
    @Autowired
    TechnologyDao dao;

    @Override
    public List<Technology> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void add(Technology technology) {
        dao.add(technology);
    }

    @Override
    public List<Technology> findByName(String name) {
        return dao.findByName("%"+name+"%","%"+name+"%");
    }

    @Override
    public Technology findById(int baseId) {
        return dao.findById(baseId);
    }

    @Override
    public void det(int baseId) {
        dao.det(baseId);
    }

    @Override
    public Integer number() {
        Integer i = dao.number();
        if (i==null){
            return 0;
        }
        return i;
    }


}
