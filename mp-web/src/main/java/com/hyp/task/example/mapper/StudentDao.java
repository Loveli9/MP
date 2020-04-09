package com.hyp.task.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hyp.task.example.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {

}
