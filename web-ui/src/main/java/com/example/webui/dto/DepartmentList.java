package com.example.webui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
public class DepartmentList {
    private int id;
    private String code;
    private String name;
    private String country;
    private List<DepartmentRecord> departments;

    public DepartmentList(){

    }
    public DepartmentList(Spliterator<DepartmentRecord> spliterator){
        departments = StreamSupport.stream(spliterator, false)
                .collect(Collectors.toList());
    }

}
