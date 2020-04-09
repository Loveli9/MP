package com.hyp.task.example.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hyp.Dto.response.ListResponse;
import com.hyp.Dto.response.PageResponse;
import com.hyp.Dto.response.PlainResponse;
import com.hyp.task.example.entity.Tool;
import com.hyp.task.example.service.ToolService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("toolchains/tool")
public class ToolController {

    @Autowired
    private ToolService service;

    @ResponseBody
    @RequestMapping(value = "/save", consumes = "application/json")
    public PlainResponse merge(@RequestBody Tool tool) {
        return service.merge(tool);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public PlainResponse<Boolean> deleteById(Integer id) {
        boolean out = service.deleteById(id);
        return PlainResponse.ok(out);
    }

    @ResponseBody
    @RequestMapping("/get_by_name")
    public ListResponse<Tool> getByMetricsTableConfigId(Page page, String name) {
        Wrapper<Tool> wrapper = new EntityWrapper<>();
        if (StringUtils.isNotEmpty(name)) {
            wrapper.like("name", name);
        }
        Page result = service.selectPage(page, wrapper);
        ListResponse response = PageResponse.ok(result.getRecords()).totalCount(result.getTotal()).pageNumber(result.getCurrent()).pageSize(result.getSize());
        return response;
    }

    @ResponseBody
    @RequestMapping("/get_by_id")
    public PlainResponse getById(Integer id) {
        return PlainResponse.ok(service.selectById(id));
    }

}
