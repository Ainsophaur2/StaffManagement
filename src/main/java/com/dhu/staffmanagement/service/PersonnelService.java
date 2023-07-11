package com.dhu.staffmanagement.service;
import com.dhu.staffmanagement.entity.Personnel;

import java.sql.Date;
import java.util.List;

public interface PersonnelService {
    //查找所有病患
    public List<Personnel> findAll(int size, int page);
    //添加病患
    public void add(Personnel personnel);

    //根据id查找病患
    public Personnel findById(int  id);
    //查找病患总人数
    public int number();


}
