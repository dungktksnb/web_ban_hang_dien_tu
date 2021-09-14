package com.example.web_ban_hang.controller;

import com.example.web_ban_hang.model.SanPham;
import com.example.web_ban_hang.service.IServiceSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class AddToCartController {
    @Autowired
    IServiceSanPham iServiceSanPham;

    @GetMapping("/cart")
    public ModelAndView showCart(HttpServletRequest req){
        ModelAndView modelAndView=new ModelAndView("cart");
        List<SanPham>danhsachgiohang= (List<SanPham>) req.getSession().getAttribute("danhsachgiohang");
        modelAndView.addObject("danhsachsanpham",danhsachgiohang);
        return modelAndView;
    }
}
