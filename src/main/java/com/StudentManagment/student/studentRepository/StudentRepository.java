package com.StudentManagment.student.studentRepository;

import com.StudentManagment.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{
    List<Student> findByNameContainingIgnoreCase(String name);
}
