package com.hyp.task.example.controller;

import com.hyp.task.example.entity.MetricsRow;
import com.hyp.task.example.service.MetricsRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics_row")
public class MetricsRowController {

    @Autowired
    private MetricsRowService service;

    @ResponseBody
    @RequestMapping("/save")
    public String save(@RequestBody MetricsRow metricsRow) {
        service.merge(metricsRow);
        return "OK";
    }

}
