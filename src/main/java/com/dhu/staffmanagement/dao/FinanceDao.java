package com.dhu.staffmanagement.dao;

import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.entity.Finance;
import com.dhu.staffmanagement.entity.Personnel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FinanceDao {

    @Select("select * from finance ")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
})
    public List<Finance> findAll();


    @Insert("insert into finance(baseId,salary,position)values(#{baseId},#{salary},#{position})")
    public void add(Finance finance);


    @Select("select * from finance where baseId = #{baseId}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })
    public Finance findById(int baseId);

    @Select("select sum(1) from finance ")
    public int number();


    @Select("SELECT * " +
            " FROM finance WHERE baseId in(select id from base where name like #{name})")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "personnel", column = "baseId", javaType = Personnel.class,many = @Many(select = "com.dhu.staffmanagement.dao.PersonnelDao.findById")),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })
    public List<Finance> findByName(String name);
}
