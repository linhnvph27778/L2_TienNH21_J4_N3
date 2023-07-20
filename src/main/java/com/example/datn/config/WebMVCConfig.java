package com.example.datn.config;


import com.example.datn.interceptor.UsersLoginInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private UsersLoginInteceptor usersLoginInteceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(usersLoginInteceptor)
                .addPathPatterns("/viewsUsers/shopping-cart/**", "/viewsUsers/checkout/**", "/viewsUsers/settingAccount/**")
                .excludePathPatterns("/authencation/usersLogin", "/authencation/usersRegister");

    }

}
