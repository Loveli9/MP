package com.hyp.spring_study.spring_aop.service;

import com.hyp.spring_study.spring_aop.entity.User;
import org.springframework.stereotype.Service;

@Service("userSvcImpl")
public class UserSvcImpl {//implements UserSvc {

//    @Override
    public User login() {
        User user = new User();
        user.setId(1);
        user.setName("胡亚鹏");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
