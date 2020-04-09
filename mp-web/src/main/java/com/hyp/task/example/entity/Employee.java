package com.hyp.task.example.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@TableName(value="employee")
public class Employee {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    //@TableField(condition = SqlCondition.LIKE)
    //@TableField(exist=false)
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("gender")
    private String gender;

    @TableField("email")
    private String email;

    @TableField("borth_day")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borthDay;

    @TableField("is_at_work")
    private Boolean isAtWork;

}
