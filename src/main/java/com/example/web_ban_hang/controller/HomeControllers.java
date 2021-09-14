package com.example.web_ban_hang.controller;

import com.example.web_ban_hang.model.NguoiDung;
import com.example.web_ban_hang.model.Role;
import com.example.web_ban_hang.model.SanPham;
import com.example.web_ban_hang.model.ThuongHieu;
import com.example.web_ban_hang.service.IServiceNguoiDung;
import com.example.web_ban_hang.service.IServiceSanPham;
import com.example.web_ban_hang.service.IServiceThuongHieu;
import com.example.web_ban_hang.service.IServieRole;
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
  @Autowired IServiceNguoiDung iServiceNguoiDung;
    @Autowired
    IServieRole iServieRole;


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
    public ModelAndView showProducts() {
        ModelAndView modelAndView = new ModelAndView("admin/index");
        return modelAndView;
    }
    @GetMapping("/sanpham")
    public ModelAndView showSanPham() {
        ModelAndView modelAndView = new ModelAndView("admin/simple-tables");
        modelAndView.addObject("listSanPham", iServiceSanPham.findAll());
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

    @GetMapping("/createProduct")
    public ModelAndView createProductShow() {
        ModelAndView modelAndView=new ModelAndView("product/createProduct");
        modelAndView.addObject("product",new SanPham());
        modelAndView.addObject("listthuonghieu",iServiceThuongHieu.findAll());
        return modelAndView;
    }

    @GetMapping("/editProduct/{id}")
    public ModelAndView editProductShow(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("product/editproduct");
        modelAndView.addObject("sanpham", iServiceSanPham.findById(id));
//        modelAndView.addObject("listtThuongHieu", iServiceThuongHieu.findAll());
        return modelAndView;
    }

    @GetMapping("/deleteProduct/{id}")
    public ModelAndView DeleteProduct(@PathVariable long id) {
        iServiceNguoiDung.remove(iServiceNguoiDung.findById(id));
//        ModelAndView modelAndView = new ModelAndView("createUser/delete");
//        modelAndView.addObject("product", iServiceSanPham.findById(id));
        return new ModelAndView("redirect:/home/sanpham");
    }
//    @PostMapping("/upload")
//    public ModelAndView upload(@RequestParam MultipartFile file) throws IOException {
//        String name = file.getOriginalFilename();
//        FileCopyUtils.copy(file.getBytes(), new File(uploadPart + name));
//
//        ModelAndView modelAndView = new ModelAndView("admin/editProduct");
//        modelAndView.addObject("anhs", name);
//        return modelAndView;
//    }

    @PostMapping("/createProduct")
    public ModelAndView createProduct(@RequestParam MultipartFile anhs, @ModelAttribute SanPham sanPham) {
        String nameFile = anhs.getOriginalFilename();
        try {
            FileCopyUtils.copy(anhs.getBytes(), new File(uploadPart + nameFile));
            sanPham.setAnhs("/img/" + nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        iServiceSanPham.save(sanPham);
        ModelAndView modelAndView = new ModelAndView("/home/sanpham");
        return modelAndView;
    }

    @PostMapping("/editProduct/{id}")
    public ModelAndView editProduct(@RequestParam MultipartFile uppImg, @ModelAttribute SanPham sanPham) {
        String nameFile = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File(uploadPart + nameFile));
            sanPham.setAnhs("/img/" + nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        iServiceSanPham.save(sanPham);
        ModelAndView modelAndView = new ModelAndView("redirect:/home/sanpham");
        return modelAndView;
    }

//    @PostMapping("/deleteProduct/{id}")
//    public ModelAndView deleteProduct(@ModelAttribute NguoiDung nguoiDung, @PathVariable long id) {
//        iServiceNguoiDung.remove(iServiceNguoiDung.findById(id));
//        return new ModelAndView("redirect:/home/sanpham");
//    }

    @GetMapping("/user")
    public ModelAndView showUser() {
        ModelAndView modelAndView = new ModelAndView("admin/datatables");
        modelAndView.addObject("listUser", iServiceNguoiDung.findAll());
        return modelAndView;
    }

    @ModelAttribute("/role")
    public List<Role> roleList() {
        return iServieRole.findAll();
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

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("createUser/delete");
        modelAndView.addObject("user", iServiceNguoiDung.findById(id));
        return modelAndView;
    }

    @PostMapping("/CreateUser")
    public ModelAndView createUser(@ModelAttribute NguoiDung nguoiDung) {
        iServiceNguoiDung.save(nguoiDung);
        ModelAndView modelAndView = new ModelAndView("redirect:/home/user");
        return modelAndView;

    }

    @PostMapping("/editUser/{id}")
    public ModelAndView editUser(@ModelAttribute NguoiDung nguoiDung) {
        iServiceNguoiDung.save(nguoiDung);
        ModelAndView modelAndView = new ModelAndView("redirect:home/user");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute NguoiDung nguoiDung, @PathVariable long id) {
        iServiceNguoiDung.remove(iServiceNguoiDung.findById(id));
        return new ModelAndView("redirect:home/user");
    }
}
