package com.example.web_ban_hang.controller;

import com.example.web_ban_hang.model.Anh;
import com.example.web_ban_hang.model.NguoiDung;
import com.example.web_ban_hang.model.ThuongHieu;
import com.example.web_ban_hang.service.IServiceNguoiDung;
import com.example.web_ban_hang.service.IServiceSanPham;
import com.example.web_ban_hang.service.IServiceThuongHieu;
import com.example.web_ban_hang.service.IServicesAnh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class Controllers {
    @Autowired
    IServiceThuongHieu iServiceThuongHieu;
    @Autowired
    IServicesAnh iServicesAnh;
    @Autowired

    IServiceSanPham iServiceSanPham;
    @Autowired
    IServiceNguoiDung iServiceNguoiDung;


    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listSanPham", iServiceSanPham.findAll());
        return modelAndView;
    }

    @GetMapping("/dung")
    public ModelAndView newss() {
        ModelAndView modelAndView = new ModelAndView("cart");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView showProduct() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("listSanPham", iServiceSanPham.findAll());
        return modelAndView;
    }

    @ModelAttribute("/thuonghieu")
    public List<ThuongHieu> thuongHieuList() {
        return iServiceThuongHieu.findAll();
    }

    @ModelAttribute("/anh")
    public List<Anh> anhList() {
        return iServicesAnh.findAll();
    }

    @GetMapping("/product")
    public ModelAndView showProducts() {
        ModelAndView modelAndView = new ModelAndView("admin/index");
modelAndView.addObject("nguoidung",iServiceNguoiDung.findAll());
        return modelAndView;
    }

    @GetMapping("/sanpham")
    public ModelAndView showSanPham() {
        ModelAndView modelAndView = new ModelAndView("admin/simple-tables");
        modelAndView.addObject("listSanPham", iServiceSanPham.findAll());
        return modelAndView;
    }



}
