package com.dhu.staffmanagement;

import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.service.BaseService;
import com.dhu.staffmanagement.service.iml.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
public class Test {

    @Autowired
    BaseService baseService;


    @org.junit.Test
    public void baseTest() {
        Base base = new Base();
        base.setIdCard("513042198810241233");
        base.setName("安没");
        base.setAge(22);
        base.setGender('男');
        base.setAddress("美国");
        base.setPhone(new BigInteger("123456789"));
//        baseService.add(base);
        BaseServiceImp baseServiceImp = new BaseServiceImp();
        baseServiceImp.add(base);
    }
}
