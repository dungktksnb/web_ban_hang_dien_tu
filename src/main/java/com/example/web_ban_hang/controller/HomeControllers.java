package com.example.web_ban_hang.controller;

import com.example.web_ban_hang.model.SanPham;
import com.example.web_ban_hang.model.ThuongHieu;
import com.example.web_ban_hang.service.IServiceSanPham;
import com.example.web_ban_hang.service.IServiceThuongHieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeControllers {
    @Value("${uploadPart}")
    String uploadPart;
    @Autowired
    IServiceThuongHieu iServiceThuongHieu;
    @Autowired

    IServiceSanPham iServiceSanPham;
    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listSanPham", iServiceSanPham.findAll());
        return modelAndView;
    }
    @GetMapping("/products")
    public ModelAndView showProduct() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("listSanPham", iServiceSanPham.findAll());
        return modelAndView;
    }

    @ModelAttribute("thuonghieu")
    public List<ThuongHieu> thuongHieuList() {
        return iServiceThuongHieu.findAll();
    }

    @GetMapping("/product")
    public ModelAndView showProducts(){
        ModelAndView modelAndView=new ModelAndView("admin/index");
        return modelAndView;
    }
    @GetMapping("/sanpham")
    public ModelAndView showSanPham(){
        ModelAndView modelAndView=new ModelAndView("admin/simple-tables");
        modelAndView.addObject("listSanPham",iServiceSanPham.findAll());
        return modelAndView;
    }
    @GetMapping("createProduct")
    public  ModelAndView createProduct(){
        ModelAndView modelAndView=new ModelAndView("admin/createProduct");
        modelAndView.addObject("sanpham",new SanPham());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
        public ModelAndView showEdit(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("admin/editProduct");
        modelAndView.addObject("sanpham",iServiceSanPham.findById(id));
       return modelAndView;
    }
    @ModelAttribute("thuonghieu")
    public ArrayList<ThuongHieu> listThuongHieu(){
        return (ArrayList<ThuongHieu>) iServiceThuongHieu.findAll();
    }


    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam MultipartFile file) throws IOException {

        String name = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(), new File(uploadPart + name));

        ModelAndView modelAndView = new ModelAndView("admin/editProduct");
        modelAndView.addObject("anhs", name);

        return modelAndView;
    }
    @PostMapping()
    public ModelAndView createProduct( @RequestParam MultipartFile file,@ModelAttribute SanPham sanpham){
        String name = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(uploadPart + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        iServiceSanPham.save(sanpham);
        ModelAndView modelAndView=new ModelAndView("/admin/simple-tables");
        return modelAndView;

    }



}
