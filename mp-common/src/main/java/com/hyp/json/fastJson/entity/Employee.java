package com.hyp.json.fastJson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private String id;
    private String name;
    private Integer age;
    private Date birthDay;

}
