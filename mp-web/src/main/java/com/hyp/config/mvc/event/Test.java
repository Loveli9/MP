package com.hyp.config.mvc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter4")
public class Test {

    @Autowired
    private Publisher publisher;

    @GetMapping("/get")
    public String locale(){
        publisher.publish("Hello,World!","Mr.Lensen", "I Love U");
        return "OK";
    }

}
