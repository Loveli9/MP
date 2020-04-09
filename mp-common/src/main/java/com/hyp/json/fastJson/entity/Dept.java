package com.hyp.json.fastJson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dept {

    private String id;
    private String name;
    private List<Employee> emps;

}
