package com.StudentManagment.student.studentService;

import com.StudentManagment.student.exception.StudentNotFoundException;
import com.StudentManagment.student.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.StudentManagment.student.studentRepository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
     StudentRepository studentRepository;

    public  StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    @Override
    public List<Student> getAllstudents() {
        List<Student> list=studentRepository.findAll();
        list=list.stream()
                .filter(Student::isActive)
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public Student getStudent(Long id) throws StudentNotFoundException {
       Optional<Student> student=studentRepository.findById(id);
       if(student.isEmpty()){
          throw  new StudentNotFoundException("No student found with given id");
       }
       else return student.get();

    }



    @Override
    public String removeStudent(Long id) {
        Optional<Student> deletedStudent=studentRepository.findById(id);
        deletedStudent.ifPresent(student -> student.setActive(false));
        return "Student deleted succesfully";
    }

    @Override
    public Student updateStudent(Long id,Student student) throws StudentNotFoundException {
       Optional <Student> s1=studentRepository.findById(id);
       if(s1.isEmpty()){
           throw new StudentNotFoundException("update failed for given student");
       }
       else{
         Student  updatedStudent=s1.get();
         updatedStudent.setStudentClass(student.getStudentClass());
         updatedStudent.setAge(student.getAge());
         updatedStudent.setName(student.getName());
         updatedStudent.setPhoneNumber(student.getPhoneNumber());
         return  studentRepository.save(student);
       }
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        List<Student>list=studentRepository.findByNameContainingIgnoreCase(name);
        list=list.stream()
                .filter(Student::isActive)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public Student createStudent(String name,String age,String studentClass,String phoneNumber) {
        Student newStudent=new Student();
        newStudent.setActive(true);
        newStudent.setStudentClass(studentClass);
        newStudent.setPhoneNumber(phoneNumber);
        newStudent.setName(name);
        newStudent.setAge(age);
        return studentRepository.save(newStudent);
    }
}
