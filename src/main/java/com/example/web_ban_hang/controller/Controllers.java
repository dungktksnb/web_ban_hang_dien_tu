package com.example.web_ban_hang.controller;

import com.example.web_ban_hang.service.IServiceSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class Controllers {
    @Autowired
    IServiceSanPham iServiceSanPham;
    @GetMapping("/show")
    public ModelAndView show(){
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("listSanPham",iServiceSanPham.findAll());
        return modelAndView;
    }




}
