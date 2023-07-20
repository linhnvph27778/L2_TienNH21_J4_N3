package com.example.datn.usersController;

import com.example.datn.entity.KhachHang;
import com.example.datn.service.KhachHangService;
import com.example.datn.service.SendMailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("viewsUsers/authencation")
public class UsersFoggotPass {

    private Random random = new Random();

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/usersFoggotPass")
    private  String getUserFoggotPassForm(Model model){
        model.addAttribute("emailFoggot", true);
        model.addAttribute("otpVerificationForgotPassword", false);
        model.addAttribute("changePassword", false);
        return "/viewsUsers/authencation/usersFoggotPass";
    }

    @PostMapping("/usersFoggotPass")
    private String getEmailFoggot(Model model){

        String email = req.getParameter("email");

        KhachHang khachHang = khachHangService.checkEmail(email);

        if (khachHang != null){

            model.addAttribute("emailFoggot", false);
            model.addAttribute("otpVerificationForgotPassword", true);
            model.addAttribute("changePassword", false);

            String otpFoggot = generateRandomNumbers();
            String fullName= khachHang.getHoTen();

            session.setAttribute("UserResetPass", khachHang);

            String subject="Dear" + " " + fullName + " " + "This is OTP to register a your account : ";

            sendMailService.sendSimpleEmail(email, "Verify your email address", subject + " " + otpFoggot);

            session.setAttribute("OTPResetPass", otpFoggot);
            return "/viewsUsers/authencation/usersFoggotPass";
        }else{
            model.addAttribute("emailFoggot", true);
            model.addAttribute("changePassword", false);
            model.addAttribute("otpVerificationForgotPassword", false);
            model.addAttribute("messageEmailErr", "Not have Email");
            return "/viewsUsers/authencation/usersFoggotPass";
        }

    }

    @PostMapping("/verify-pass-otp")
    private String checkOTPFoggotPass(Model model){
        String OTP = req.getParameter("OTPChangePass");
        String OTPResetPass = (String) session.getAttribute("OTPResetPass");
        if (OTP.equals(OTPResetPass)){
            model.addAttribute("emailFoggot", false);
            model.addAttribute("changePassword", true);
            model.addAttribute("otpVerificationForgotPassword", false);
            return "/viewsUsers/authencation/usersFoggotPass";
        }else{
            model.addAttribute("emailFoggot", false);
            model.addAttribute("changePassword", false);
            model.addAttribute("otpVerificationForgotPassword", true);
            model.addAttribute("messageOTPChangePass","OTP Incorrect");
            return "/viewsUsers/authencation/usersFoggotPass";
        }
    }

    @PostMapping("/changePassword")
    private String changePass(Model model){
        String passNew = req.getParameter("password");

        KhachHang khachHang = (KhachHang) session.getAttribute("UserResetPass");

        if (passNew == null || "".equals(passNew)){
            model.addAttribute("emailFoggot", false);
            model.addAttribute("changePassword", false);
            model.addAttribute("otpVerificationForgotPassword", true);
            model.addAttribute("messagePassword", "Not Blank");
            return "/viewsUsers/authencation/usersFoggotPass";
        }else{
            khachHang.setPass(passNew);
            khachHangService.add(khachHang);
            session.invalidate();
            return "/viewsUsers/authencation/usersLogin";
        }
    }


    private String generateRandomNumbers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(10); // Tạo số ngẫu nhiên từ 0 đến 9
            sb.append(randomNumber);
        }
        return sb.toString();
    }


}
