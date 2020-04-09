package com.hyp.task.example.controller;

import com.hyp.task.example.entity.Student;
import com.hyp.task.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 乐观锁更新案例
     * */
    @RequestMapping("/updateByVersion")
    public void query () {
        // 正确的操作流程
        // 1.根据ID获取某条数据
        Student student = studentService.selectById(1);
        System.out.println(student);
        // 2.修改这条数据
        student.setName("心飞扬");
        student.setAge(20);
//		student.setVersion(student.getVersion()); // mybatis plus 会在老版本的version + 1 ，所以不需要再手动+1；
        try {
            System.out.println("开始休眠......");
            // 可以延迟10000s ,手动去修改数据库这条数据的version 为其他数字 ，最后的结果就是无法更新成功
            Thread.sleep(20000);// Thread.sleep(10000);
            studentService.updateById(student); // // 3.根据ID修改这条数据（mybatis plus 的内层帮我们多加了一个where条件，保证乐观锁的实现） /
            System.out.println("休眠结束......");
            System.out.println(student);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
