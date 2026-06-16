package com.stu.studentmanager.entity;
import lombok.Data;
@Data
public class Student {
    private Integer id;
    private String stuNo;
    private String stuName;
    private String gender;
    private Integer age;
    private String major;
}