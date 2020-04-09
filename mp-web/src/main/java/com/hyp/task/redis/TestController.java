package com.hyp.task.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzh
 * createconsum 2019-09-18-22:36
 */
@RestController
public class TestController {

    @Autowired
    private UserRedisService userRedisService;

    @RequestMapping("/queryAll")
    public List<User> queryAll(){
        List<User> lists = userRedisService.queryAll();
        return lists;
    }

    @RequestMapping("/findUserById")
    public Map<String, Object> findUserById(@RequestParam int id){
        User user = userRedisService.findUserById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("uid", user.getId());
        result.put("uname", user.getName());
        result.put("age", user.getAge());
        result.put("email", user.getEmail());
        return result;
    }

    @RequestMapping("/updateUser")
    public String updateUser(){
        User user = new User();
        user.setId(100);
        user.setName("xiaohu");
        user.setAge(1);
        user.setEmail("xiaohu@foxmail.com");
        int result = userRedisService.updateUser(user);
        if(result != 0){
            return "update user success";
        }
        return "fail";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam int id){
        int result = userRedisService.deleteUserById(id);
        if(result != 0){
            return "delete success";
        }
        return "delete fail";
    }

}
