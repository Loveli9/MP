package com.hyp.spring_study.spring_aop.controller;

import com.hyp.spring_study.spring_aop.entity.User;
import com.hyp.spring_study.spring_aop.service.UserSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserLoginController {

    @Autowired
    private UserSvcImpl userSvc;

    @RequestMapping("/login")
    public User login() {
        return userSvc.login();
    }

}
