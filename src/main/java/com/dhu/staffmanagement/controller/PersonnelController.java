package com.dhu.staffmanagement.controller;

import com.dhu.staffmanagement.entity.*;
import com.dhu.staffmanagement.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Controller
public class PersonnelController {
    @Autowired
    PersonnelService service;
    @Autowired
    BaseService baseService;

    @RequestMapping(value = "/personnel/list", method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "25") int size) {
        List<Personnel> personnels = service.findAll(page, size);
        PageInfo<Personnel> pageInfo = new PageInfo(personnels);
        model.addAttribute("pageInfo", pageInfo);
        return "personnelList";
    }


}
