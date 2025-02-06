package com.StudentManagment.student.dtos;

import lombok.Data;
import com.StudentManagment.student.models.Student;

import java.util.List;

@Data
public class ResponseDto {
    List<Student> studentList;
}
