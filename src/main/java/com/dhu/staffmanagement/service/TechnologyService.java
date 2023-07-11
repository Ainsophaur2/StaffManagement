package com.dhu.staffmanagement.service;

import com.dhu.staffmanagement.entity.Technology;


import java.util.List;

public interface TechnologyService {
    //查看所有接触案例
    public List<Technology> findAll(int page, int size);
    //增加接触者
    public void add(Technology technology);
    //根据姓名查找密切接触者
    public List<Technology> findByName(String name);
    //通过id查找密切接触者
    public Technology findById(int baseId);
    //将此接触者隔离状态完成
    public void det(int baseId);

   //查找现存隔离人员数量
    public Integer number();

}
