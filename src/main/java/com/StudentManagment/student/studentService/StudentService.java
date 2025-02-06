package com.StudentManagment.student.studentService;

import com.StudentManagment.student.exception.StudentNotFoundException;
import com.StudentManagment.student.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllstudents();
    Student getStudent(Long id) throws StudentNotFoundException;
    String removeStudent(Long id);
    Student updateStudent(Long id,Student student)throws StudentNotFoundException;
   List< Student>searchStudentByName(String name);
    Student createStudent(String name,String age,String studentClass,String phoneNumber);
}
