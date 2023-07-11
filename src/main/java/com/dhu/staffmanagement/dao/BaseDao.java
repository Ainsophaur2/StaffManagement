package com.dhu.staffmanagement.dao;

import com.dhu.staffmanagement.entity.Base;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface BaseDao {

    @Select("select id,idCard,name,age,gender,address,phone,email from base where id =#{id}")
    public Base findById(int id);

    @Delete("delete from base where id=#{id}")
    public void  delete(int id);

    @Insert("insert into base(idCard,name,age,gender,address,phone,email ) values(#{idCard},#{name},#{age},#{gender},#{address},#{phone},#{email})")
    public void add(Base base);
    @Select("select id,idCard,name,age,gender,address,phone,email from base where idCard = #{idCard}")
    public Base findByIdCard(String idCard);

    @Update("update base set address=#{address},phone=#{phone} where id=#{id}")
    public void update(Base base);

    @Select("select * from base")
    public List<Base> findAll();

}
