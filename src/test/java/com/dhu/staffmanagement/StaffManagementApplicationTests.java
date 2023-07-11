package com.dhu.staffmanagement;

import com.dhu.staffmanagement.entity.CheckOut;
import com.dhu.staffmanagement.dao.BaseDao;
import com.dhu.staffmanagement.dao.PersonnelDao;
import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.service.BaseService;
import com.dhu.staffmanagement.service.CheckOutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
class StaffManagementApplicationTests {

    @Autowired
    BaseDao dao;

    PersonnelDao da;

    @Autowired
    BaseService baseService;

    @Autowired
    CheckOutService checkOutService;

    @Test
    void baseInsert() {
        Base base = new Base();
        base.setIdCard("513042198810241233");
        base.setName("安没");
        base.setAge(22);
        base.setGender('男');
        base.setAddress("美国");
        base.setPhone(new BigInteger("123456789"));
        baseService.add(base);
    }

    @Test
    void baseFind() {
        Base base = baseService.findById(78);
        System.out.println(base);
    }

    @Test
    void checkOutInsert() {
        CheckOut checkOut = new CheckOut();
        checkOut.setBaseId(101).
                setCurrentPosition("xx").
                setBodyTemperature(37.0).
                setHealthState("健康").
                setIsToHighArea("yes").
                setIsTouch("true").
                setName("Halo").
                setRemarks("xxx");
        checkOutService.add(checkOut);
    }

    @Test
    void findAll() {
        System.out.println(checkOutService.findAll(1, 25));
    }

}
