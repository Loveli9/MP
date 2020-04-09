package com.hyp.task.example.service;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hyp.task.example.entity.Employee;
import com.hyp.task.example.mapper.EmployeeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeService extends ServiceImpl<EmployeeDao, Employee> implements IService<Employee> {

    @Transactional(rollbackFor = Exception.class)
    public boolean saveEmp(Employee employee) {
        //insert方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性所对应的字段才会出现在SQL语句中。
        //insertAllColumn方法在插入时，不管属性是否为空，属性所对应的字段都会出现在
        return insert(employee);
    }

    public List<Employee> queryByCondition(String name) {
        Wrapper<Employee> wrapper = new EntityWrapper<>();
        wrapper.like("name",name);
        List<Employee> out = selectList(wrapper);
        return out;
    }

    public boolean updateByCondition(Employee employee) {
        Wrapper<Employee> wrapper = new EntityWrapper<>();
        wrapper.eq("",employee.getId()).like("name",employee.getName());
        return update(employee,wrapper);
    }

    public List<Employee> queryByConfition(String name) {
        List<Employee> out = new ArrayList<>();
        out = this.selectList(Condition.create()
                .isNotNull("id")
                .like("name", name)
                .in("id", new Integer[]{1, 2,5,6,7})
                .orderAsc(Arrays.asList(new String[]{"borth_day"})));
        return out;
    }

    public List<Employee> selectListByCondition(String name) {
        //查询数据库，性别为男(1)，并且名字中带有霸的记录或者email中带有123的记录。
        List<Employee> employeeList= selectList(
                new EntityWrapper<Employee>().
                        eq("gender","男").
                        like("name", name));
        return employeeList;
    }

}
