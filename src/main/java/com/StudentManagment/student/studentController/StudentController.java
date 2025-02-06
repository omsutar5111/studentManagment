package com.StudentManagment.student.studentController;

import com.StudentManagment.student.dtos.CreateStudentDto;
import com.StudentManagment.student.exception.StudentNotFoundException;
import com.StudentManagment.student.models.Student;
import com.StudentManagment.student.studentService.StudentService;
import com.StudentManagment.student.studentService.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentServiceImpl studentService;

    public  StudentController(StudentServiceImpl studentService){
        this.studentService=studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>>getAllStudents(){

            List<Student>list=(studentService.getAllstudents());
            return  new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable Long id) throws StudentNotFoundException {
       try{
        Student student=(studentService.getStudent(id));
           return  new ResponseEntity<>(student, HttpStatus.OK);
       }
       catch (Exception e){
           throw new StudentNotFoundException(e.getMessage());
       }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student>updateStudent(@PathVariable Long id, @RequestBody Student updateStudentDto){
       try {
           Student student=studentService.updateStudent( id,updateStudentDto  );
           return new ResponseEntity<>(student,HttpStatus.OK);
       }
       catch (Exception e){
           return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentDto createStudent){
        Student newStudent=studentService.createStudent(createStudent.getName(),createStudent.getAge(),createStudent.getStudentClass(),createStudent.getMobileNumber());
        return new ResponseEntity<>(newStudent,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@RequestBody Long id  ){
       return studentService.removeStudent(id);
    }

    @PostMapping("/search")
    public ResponseEntity <List<Student>> searchStudentByName(@RequestParam String name) throws StudentNotFoundException{
        List<Student> student=studentService.searchStudentByName(name);
       if(student.isEmpty()){
           throw new StudentNotFoundException("no student available with given name");
       }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }


}
