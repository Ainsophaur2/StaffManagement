package com.dhu.staffmanagement.controller;

import com.github.pagehelper.PageInfo;
import com.dhu.staffmanagement.entity.Administration;
import com.dhu.staffmanagement.entity.User;
import com.dhu.staffmanagement.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdministrationController {
    @Autowired
    AdministrationService service;

    @RequestMapping(value = "administration/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25")int size){
        List<Administration> administrations = service.findAll(page,size);
        PageInfo<Administration> pageInfo=new PageInfo(administrations);
        model.addAttribute("pageInfo",pageInfo);
        return "administrationList";
    }

}
