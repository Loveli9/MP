package com.hyp.task.example.service;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hyp.task.example.entity.Student;
import com.hyp.task.example.mapper.StudentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService extends ServiceImpl<StudentDao, Student> implements IService<Student> {

}
