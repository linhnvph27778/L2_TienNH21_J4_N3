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
public class UsersRegisterController {

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private HttpSession session;

    private Random random = new Random();



    @GetMapping("/usersRegister")
    private String getUsersRegisterForm(Model model){

        model.addAttribute("register", true);
        model.addAttribute("otpVerificationRequired", false);

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

            model.addAttribute("register", true);
            model.addAttribute("otpVerificationRequired", false);
            return "/viewsUsers/authencation/usersRegister";
        }

        KhachHang KHCheck = khachHangService.checkEmail(email);

        String otpRegister = generateRandomNumbers();

        if (KHCheck != null){
            model.addAttribute("messageEmailErr", "Had Email");
            model.addAttribute("register", true);
            model.addAttribute("otpVerificationRequired", false);
            return "/viewsUsers/authencation/usersRegister";
        }else{
            KhachHang khachHangNew = new KhachHang();
            khachHangNew.setEmail(email);
            khachHangNew.setHoTen(fullName);
            khachHangNew.setPass(password);

            khachHangService.addNewKhachHang(khachHangNew);

            String subject="Dear" + " " + fullName + " " + "This is OTP to register a your account : ";

            sendMailService.sendSimpleEmail(email, "Verify your email address", subject + " " + otpRegister);

            session.setAttribute("usersRegister", khachHangNew);
            session.setAttribute("otpRegister", otpRegister);

            model.addAttribute("register", false);
            model.addAttribute("otpVerificationRequired", true);

            return "/viewsUsers/authencation/usersRegister";
        }

    }


    @PostMapping("verify-otp")
    private String verifyOTPRegister(Model model){
        String otp = req.getParameter("OTPRegister");

        KhachHang khachHang = (KhachHang) session.getAttribute("usersRegister");
        String otpRegister = (String) session.getAttribute("otpRegister");

        if (otp.equals(otpRegister)) {
            khachHang.setTrangThai(1);
            khachHangService.add(khachHang);
            session.invalidate();
            return "/viewsUsers/authencation/usersLogin";
        }else{
            model.addAttribute("register", false);
            model.addAttribute("otpVerificationRequired", true);
            model.addAttribute("messageOTP", "Invalid OTP. Please try again.");
            return "/viewsUsers/authencation/usersRegister";
        }

    }

    @GetMapping("resened-otp")
    private  String resendOTPRegister(Model model){
        model.addAttribute("register", false);
        model.addAttribute("otpVerificationRequired", true);

        KhachHang khachHang = (KhachHang) session.getAttribute("usersRegister");

        String fullName= khachHang.getHoTen();
        String email = khachHang.getEmail();

        String otpNew = generateRandomNumbers();
        session.removeAttribute("otpVerificationRequired");
        session.setAttribute("otpVerificationRequired", otpNew);

        String subject="Dear" + " " + fullName + " " + "This is OTP to register a your account : ";

        sendMailService.sendSimpleEmail(email, "Verify your email address", subject + " " + otpNew);


        return "/viewsUsers/authencation/usersRegister";
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
