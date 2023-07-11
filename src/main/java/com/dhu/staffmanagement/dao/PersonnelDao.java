package com.dhu.staffmanagement.dao;

import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.entity.Personnel;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface PersonnelDao {
    @Select("SELECT * FROM personnel")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })

    public List<Personnel> findAll();


    @Insert("insert into personnel(baseId,salary,position)values(#{baseId},#{salary},#{position})")
    public void add(Personnel personnel);


    @Select("select * from personnel where baseId=#{baseId}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })
    public Personnel findById(int baseId);

    @Select("select sum(1) from personnel")
    public int number();



}
