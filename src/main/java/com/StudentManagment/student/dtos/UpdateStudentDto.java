package com.StudentManagment.student.dtos;

import lombok.Data;

@Data
public class UpdateStudentDto {
    private Long id;
    private String name;


    private String age;


    private String studentClass;


    private String phoneNumber;

}
