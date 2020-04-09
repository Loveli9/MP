package com.hyp.task.example.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hyp.Dto.response.PlainResponse;
import com.hyp.task.example.entity.Tool;
import com.hyp.task.example.mapper.ToolDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
//@Transactional(isolation = Isolation.DEFAULT,propagation= Propagation.REQUIRED) 这些都是默认的
@Transactional(isolation = Isolation.DEFAULT,propagation= Propagation.REQUIRED,timeout=30)//默认超时30秒
public class ToolService extends ServiceImpl<ToolDao, Tool> implements IService<Tool> {

    public PlainResponse merge(@RequestBody Tool tool) {

        if(tool.getId() == null) {
            PlainResponse checkResult = checkToolName(tool.getName());
            if (checkResult.getSucceed() == false) {
                return checkResult;
            }
            return PlainResponse.ok(insert(tool));
        } else {
            String newName = tool.getName();
            String oldName = this.selectById(tool.getId()).getName();
            if(!oldName.equalsIgnoreCase(newName)) {//修改了工具名
                PlainResponse checkResult = checkToolName(newName);
                if (checkResult.getSucceed() == false) {
                    return checkResult;
                }
            }
            return PlainResponse.ok(updateById(tool));
        }
    }

    private PlainResponse checkToolName(String name) {
        if(qryCountByName(name) > 0) {
            return PlainResponse.fail("工具名不能重复：" + name);
        }
        return PlainResponse.ok(true);
    }

    private int qryCountByName(String name) {
        Wrapper<Tool> wrapper = new EntityWrapper<>();
        wrapper.like("name",name);
        int out = selectCount(wrapper);
        return out;
    }

}