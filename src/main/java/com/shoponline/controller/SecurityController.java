package com.shoponline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {


    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message", "Vui lòng đăng nhập");
        return "security/login";
    }
 
    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Đăng nhập thành công!");
        return "security/login";
    }
    
    @RequestMapping("/security/login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "security/login";
    }
    
    
    @RequestMapping("/security/logoff/success")
    public String loginOffSuccess(Model model){
        model.addAttribute("message", "Đăng xuất thành công!");
        return "security/login";
    }
    
    
    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message", "Bạn không có quyền truy suất!");
        return "security/login";
    }

}
