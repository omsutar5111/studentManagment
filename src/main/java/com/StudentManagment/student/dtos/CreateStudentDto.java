package com.StudentManagment.student.dtos;

import lombok.Data;


public class CreateStudentDto {
 public String name;
 public  String age;
 public  String mobileNumber;
 public  String studentClass;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getAge() {
  return age;
 }

 public void setAge(String age) {
  this.age = age;
 }

 public String getMobileNumber() {
  return mobileNumber;
 }

 public void setMobileNumber(String mobileNumber) {
  this.mobileNumber = mobileNumber;
 }

 public String getStudentClass() {
  return studentClass;
 }

 public void setStudentClass(String studentClass) {
  this.studentClass = studentClass;
 }
}
