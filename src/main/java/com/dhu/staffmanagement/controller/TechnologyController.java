package com.dhu.staffmanagement.controller;

import com.dhu.staffmanagement.entity.Base;
import com.dhu.staffmanagement.entity.Technology;
import com.dhu.staffmanagement.service.BaseService;
import com.github.pagehelper.PageInfo;
import com.dhu.staffmanagement.entity.User;
import com.dhu.staffmanagement.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Controller
public class TechnologyController {
    @Autowired
    TechnologyService service;
    @Autowired
    BaseService baseService;

    //删除员工
    @RequestMapping(value = "/technology/det/{baseId}", method = RequestMethod.GET)
    public String delete(@PathVariable("baseId") int baseId) {
        service.det(baseId);
        baseService.delete(baseId);
        return "redirect:/technology/list";
    }

    //查看技术部员工
    @RequestMapping(value = "/technology/list", method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "25") int size) {
        List<Technology> technologies = service.findAll(page, size);
        PageInfo<Technology> pageInfo = new PageInfo(technologies);
        model.addAttribute("pageInfo", pageInfo);
        return "technologyList";
    }

    @RequestMapping(value = "/technology/listByTechnologyName")
    public String listByTechnologyName(Model model, @RequestParam(name = "name", required = true) String name) {
        List<Technology> technologies = service.findByName(name);
        PageInfo<Technology> pageInfo = new PageInfo(technologies);
        model.addAttribute("pageInfo", pageInfo);
        return "technologyList";
    }

    //跳转技术部员工详情页面
    @RequestMapping(value = "/technology/info/{id}", method = RequestMethod.GET)
    public String info(Model model, @PathVariable("id") int id) {
        Technology technology = service.findById(id);
        System.out.println(technology);
        model.addAttribute("technology", technology);
        return "technologyInfo";
    }

    //添加员工
    @RequestMapping(value = "/technology/add", method = RequestMethod.POST)
    public String addTechnology(@RequestParam("baseId") int baseId, @RequestParam("salary") int salary,
                             @RequestParam("position") String position) {
        Technology technology = new Technology().setBaseId(baseId).setSalary(salary).setPosition(position);
        service.add(technology);
        return "redirect:/technology/list";
    }

    @RequestMapping(value = "/technology/addBase", method = RequestMethod.POST)
    public String addBase(@RequestParam("name") String name, @RequestParam("idCard") String idCard,
                          @RequestParam("gender") char gender, @RequestParam("address") String address,
                          @RequestParam("age") int age, @RequestParam("phone") String phone,
                          @RequestParam("email") String email,
                          @RequestParam("msg") String msg,
                          Model model) {
        Base base = new Base();
        base.setName(name).setAddress(address).setAge(age).setGender(gender).setIdCard(idCard).setPhone(new BigInteger(phone)).setEmail(email);
        baseService.add(base);
        Base b2 = baseService.findByIdCard(idCard);
        int id = b2.getId();
        model.addAttribute("baseId", id);
        System.out.println(msg);
        return "technologyAdd2";
    }

    //跳转添加页面
    @RequestMapping(value = "/technology/toAdd")
    public String toAdd() {
        return "technologyAdd";
    }
}
