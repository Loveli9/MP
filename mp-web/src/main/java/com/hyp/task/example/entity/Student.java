package com.hyp.task.example.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import lombok.Data;

@Data
@TableName(value="student")
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    //注解实体字段 @Version 必须要!
    //支持的数据类型只有:int,Integer,long,Long,Date,Timestamp,LocalDateTime
    //整数类型下 newVersion = oldVersion + 1
    //newVersion 会回写到 entity 中
    //仅支持 updateById(id) 与 update(entity, wrapper) 方法
    //在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
    @Version
    private Integer version;

}
