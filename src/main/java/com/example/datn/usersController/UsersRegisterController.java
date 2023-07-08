package com.example.datn.usersController;

import com.example.datn.entity.KhachHang;
import com.example.datn.service.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("viewsUsers/authencation")
public class UsersRegisterController {

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private KhachHangService khachHangService;


    @GetMapping("/usersRegister")
    private String getUsersRegisterForm(){
        return "/viewsUsers/authencation/usersRegister";
    }

    @PostMapping("/usersRegister")
    private String registerUsers(Model model){

        String fullName = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPass = req.getParameter("confirmPass");

        boolean hasErr = false;

        if (fullName == null || "".equals(fullName)) {
            model.addAttribute("messageFullNameErr", "Please enter your FullName");
            hasErr = true;
        }
        if (password == null || "".equals(password)) {
            model.addAttribute("messagePassErr", "Please enter your Password");
            hasErr = true;
        }
        if (email == null || "".equals(email)) {
            model.addAttribute("messageEmailErr", "Not Blank");
            hasErr = true;
        }
        if (confirmPass == null || "".equals(confirmPass)) {
            model.addAttribute("messageCofirmPassErr", "Please enter your Confirm Password");
            hasErr = true;
        }
        if (hasErr){
            model.addAttribute("email", email);
            model.addAttribute("fullName", fullName);
            return "/viewsUsers/authencation/usersRegister";
        }

        KhachHang KHCheck = khachHangService.checkEmail(email);

        if (KHCheck != null){
            model.addAttribute("messageEmailErr", "Had Email");
            return "/viewsUsers/authencation/usersRegister";
        }else{
            KhachHang khachHangNew = new KhachHang();
            khachHangNew.setEmail(email);
            khachHangNew.setHoTen(fullName);
            khachHangNew.setPass(password);

            khachHangService.addNewKhachHang(khachHangNew);


            return "/viewsUsers/authencation/usersLogin";
        }

    }
}
