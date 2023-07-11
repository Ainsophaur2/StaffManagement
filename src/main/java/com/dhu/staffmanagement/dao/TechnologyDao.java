package com.dhu.staffmanagement.dao;

import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.entity.Technology;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TechnologyDao {
    @Select("select * from technology ")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })
    //查看所有技术部员工
    public List<Technology> findAll();

    @Insert("insert into technology(baseId,salary,position)values(#{baseId},#{salary},#{position})")
    public void add(Technology technology);

    @Select("select * from technology where baseId =#{baseId} ")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })
    //通过id查找技术部员工
    public Technology findById(int baseId);

    @Select("SELECT * " +
            " FROM technology WHERE baseId in(select id from base where name like #{name} or email like #{email})")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })
    //根据姓名查找技术部员工
    public List<Technology> findByName(String name,String email);

    //删除员工
    @Update("delete from technology where baseId=#{baseId}")
    public void det(int baseId);

    @Select("select sum(1) from technology ")
    public Integer number();
}
