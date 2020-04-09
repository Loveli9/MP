package com.hyp.config.mvc.listener;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locale")
public class LocaleController {

    @GetMapping("/date")
    public String locale(String message){
        System.out.println("Controller is running !");
        return "Hello" + message;
    }
}
