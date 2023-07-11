package com.dhu.staffmanagement.controller;

import com.dhu.staffmanagement.service.*;
import com.dhu.staffmanagement.entity.IndexInfo;
import com.dhu.staffmanagement.entity.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.*;

@Controller
public class IndexController {
    @Autowired
    PersonnelService personnelService;
    @Autowired
    TechnologyService technologyService;
    @Autowired
    AdministrationService administrationService;
    @Autowired
    FinanceService financeService;

    @Autowired
    BaseService baseService;

    @RequestMapping(value = {"/indexpage", "/" },produces="application/json;charset=UTF-8")
    public String index(Model model){
        //查找数量
        int pN = personnelService.number();
        int aN = administrationService.number();
        int fN = financeService.number();
        int tN = technologyService.number();
        List<Base> Bases =baseService.findAll();
        int staffNums=Bases.size();
        int maleNums=0;int femaleNums=staffNums;
        int youth=0;int middle=0;int old=0;
        List ageLevel=new ArrayList();

        for(int i=0;i<Bases.size();i++)
        {
            if(Bases.get(i).getGender()=='男')
            {
                maleNums++;  femaleNums--;
            }
            if(Bases.get(i).getAge()<35) {
                youth++;
            } else {
                if(Bases.get(i).getAge()<50) {
                    middle++;
                }else{
                    old++;
                }
            }
        }

        ageLevel.add(youth);ageLevel.add(middle);ageLevel.add(old);

        //放入indexInfo中
        IndexInfo indexInfo=new IndexInfo().setAdministrationNumber(aN).
                setFinanceNumber(fN).setTechnologyNumber(tN).setPersonnelNumber(pN)
                .setMaleNums(maleNums).setFemaleNums(femaleNums)
                .setAgeLevel(ageLevel);
       model.addAttribute("indexInfo",indexInfo);
        return "index";
    }


}

