package com.dhu.staffmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoAccessController {
    @RequestMapping(value = "/noAccess")
    public String toNoAccess() {
        return "noAccess";
    }
}
