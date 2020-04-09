package com.hyp.task.email;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Promise
 * @createTime 2019年4月1日 下午9:30:38
 * @description  邮件发送
 */
@RequestMapping("/mail")
@RestController
public class EmailController {

    @Autowired
    private IMailService mailService;

    @GetMapping("/simple")
    public Map<String, Object> sendSimpleMail() {
        Map<String, Object> map =new HashMap<>();
        try {
            //参数就是接收邮件的邮箱，根据自己实际填写
//            mailService.simpleMil("huppert_hyp@foxmail.com");
            mailService.simpleMil("1402477783@qq.com");
            map.put("res", "success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("res", "error");
        }
        return map;
    }

    @GetMapping("/htmlMail")
    public Map<String, Object> htmlMail(){
        Map<String, Object> map =new HashMap<>();
        try {
            mailService.htmlMail("*****@qq.com");
            map.put("res", "success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("res", "error");
        }
        return map;
    }

    @GetMapping("/attachmentsMail")
    public Map<String, Object> attachmentsMail(){
        Map<String, Object> map =new HashMap<>();
        try {
            mailService.attachmentMail("*****@qq.com");
            map.put("res", "success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("res", "error");
        }
        return map;
    }

    @GetMapping("/imgMail")
    public Map<String, Object> imgMail(){
        Map<String, Object> map =new HashMap<>();
        try {
            mailService.imgMail("*****@qq.com");
            map.put("res", "success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("res", "error");
        }
        return map;
    }

    @GetMapping("/templateMail")
    public Map<String, Object> templateMail(){
        Map<String, Object> map =new HashMap<>();
        try {
            mailService.TemplateMail("*****@qq.com");
            map.put("res", "success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("res", "error");
        }
        return map;
    }
}