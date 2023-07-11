package com.dhu.staffmanagement.controller;

import com.dhu.staffmanagement.entity.Finance;
import com.github.pagehelper.PageInfo;
import com.dhu.staffmanagement.entity.User;
import com.dhu.staffmanagement.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FinanceController {
    @Autowired
    FinanceService service;

    @RequestMapping(value = "finance/list",method = RequestMethod.GET)
    public String list(Model model,@RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Finance> finances = service.findAll( page, size);
        PageInfo<User> pageInfo=new PageInfo(finances);
        model.addAttribute("pageInfo",pageInfo);
        return "financeList";
    }


}
