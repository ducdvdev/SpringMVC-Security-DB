package com.codegym.controller;

import com.codegym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("a",accountService.findAccountByUsername("user"));
        return modelAndView;
    }
}
