package com.example.web_ban_hang.controller;

import com.example.web_ban_hang.model.Anh;
import com.example.web_ban_hang.model.NguoiDung;
import com.example.web_ban_hang.model.Role;
import com.example.web_ban_hang.model.ThuongHieu;
import com.example.web_ban_hang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    IServieRole iServiceRole;

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
        return modelAndView;
    }

    @GetMapping("/sanpham")
    public ModelAndView showSanPham() {
        ModelAndView modelAndView = new ModelAndView("admin/simple-tables");
//        modelAndView.addObject("listSanPham", iServiceSanPham.findAll());
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView showUser() {
        ModelAndView modelAndView = new ModelAndView("admin/datatables");
        modelAndView.addObject("listUser", iServiceNguoiDung.findAll());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("createUser/delete");
        modelAndView.addObject("user", iServiceNguoiDung.findById(id));
        return modelAndView;
    }
    @ModelAttribute("/role")
    public List<Role> roleList() {
        return iServiceRole.findAll();
    }

    @GetMapping("/CreateUser")
    public String createUserShow() {
        return "createUser/index";
    }

    @GetMapping("/editUser/{id}")
    public ModelAndView editUserShow(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("createUser/editUser");
        modelAndView.addObject("user", iServiceNguoiDung.findById(id));
        return modelAndView;
    }

    @PostMapping("/CreateUser")
    public ModelAndView createUser(@ModelAttribute NguoiDung nguoiDung) {
        iServiceNguoiDung.save(nguoiDung);
        ModelAndView modelAndView = new ModelAndView("redirect:/home/index");
        return modelAndView;
    }

    @PostMapping("/editUser/{id}")
    public ModelAndView editUser(@ModelAttribute NguoiDung nguoiDung) {
        iServiceNguoiDung.save(nguoiDung);
        ModelAndView modelAndView = new ModelAndView("redirect:/home/user");
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute NguoiDung nguoiDung,@PathVariable long id) {
        iServiceNguoiDung.remove(iServiceNguoiDung.findById(id));
        return new ModelAndView("redirect:/home/user");
    }
}
