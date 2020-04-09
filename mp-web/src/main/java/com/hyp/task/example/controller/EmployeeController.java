package com.hyp.task.example.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hyp.Dto.response.ListResponse;
import com.hyp.Dto.response.PageResponse;
import com.hyp.task.example.entity.Employee;
import com.hyp.task.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/save")
    public String saveEmp(@RequestBody Employee employee) {
        employeeService.saveEmp(employee);
        int id = employee.getId();//获取自增ID
        System.out.println("id=" + id);
        return "OK";
    }

    @RequestMapping("/updateById")
    public String updateById(Integer id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("还不知道取什么名字");
        //updateById方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性所对应的字段才会出现在SQL语句中。
        boolean result = employeeService.updateById(employee);
        //updateAllColumnById方法在插入时，不管属性是否为空，属性所对应的字段都会出现在
        System.out.println("*******************"+result);
        return "OK";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee) {
        employeeService.update(employee,new EntityWrapper<Employee>()
                .eq("gender","女")
                .like("name", "胡")
        );
        return "OK";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(String gender,String name) {
        employeeService.delete(new EntityWrapper<Employee>()
                .eq("gender",gender)
                .like("name", name)
        );
        return "OK";
    }

    /**
     * 分页查询
     * */
    @RequestMapping("/queryByPage")
    public ListResponse<Employee> queryByPage(Page page) {
        Page<Employee> result = employeeService.selectPage(page);
        ListResponse response = PageResponse.ok(result.getRecords()).totalCount(result.getTotal()).pageNumber(result.getCurrent()).pageSize(result.getSize());
        return response;
    }

    @RequestMapping("/queryByCondition")
    public List<Employee> queryByCondition(String name) {
        return employeeService.queryByCondition(name);
    }

    @RequestMapping("/updateByCondition")
    public String updateByCondition(@RequestBody Employee employee) {
        employeeService.updateByCondition(employee);
        return "OK";
    }

    @RequestMapping("/queryByConfition")
    public List<Employee> queryByConfition(String name) {
        return employeeService.queryByConfition(name);
    }

    @RequestMapping("/selectListByCondition")
    public List<Employee> selectListByCondition(String name) {
        return employeeService.selectListByCondition(name);
    }

    @RequestMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.selectList(Condition.create()
                .orderAsc(Arrays.asList(new String[]{"borth_day"})));
    }

}
