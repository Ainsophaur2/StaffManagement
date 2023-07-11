package com.dhu.staffmanagement.dao;

import com.dhu.staffmanagement.entity.Administration;
import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.entity.Personnel;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdministrationDao {
    @Select("select * from administration")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))

    })
    //查看行政部员工
    public List<Administration> findAll( );

    //添加行政部员工
    @Insert("insert into administration(baseId,salary,position)values(#{baseId},#{salary},#{position})")
    public void add(Administration administration);

    //根据id查找行政部员工
    @Select("select * from administration where baseId = #{id}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))
    })

    public Administration findById(int id);


    @Select("select sum(1) from administration")
    public int number();


    @Select("select * WHERE baseId in(select id from base where name like #{name})")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "position", column = "position"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.dhu.staffmanagement.dao.BaseDao.findById"))

    })
    public List<Administration> findByName(String name);

}
