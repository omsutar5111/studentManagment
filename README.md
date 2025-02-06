# 🏫 Student Management API

## Run the Application
- git clone https://github.com/your-repository/student-management.git
- cd student-management
- mvn spring-boot:run

## 📖 Overview
This is a **Spring Boot REST API** for managing student records. It supports creating, updating, searching, and deleting student records.

## 🚀 Features
- Add new students
- Retrieve student details by ID
- Fetch all students
- Update student records
- Search students by name
- Delete a student record

## 🛠️ Technologies Used
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (or any relational database)
- **Lombok** (for reducing boilerplate code)
- **Postman** (for testing API requests)

---

## 🔗 **API Endpoints**

 ### 1️⃣ **Get Student by ID**
- **Endpoint:** `GET /students/{id}`
- **Description:** Fetches a student by their ID.
- **Request Example:**
  GET http://localhost:8080/api/students/1

  ### 2️⃣ **Get all Students**
- **Endpoint:** `GET /students`
- **Description:** Fetches a student by their ID.
- **Request Example:**
  GET http://localhost:8080/students

   ### 3️⃣ Create Student ****
- **Endpoint:** `Post /students`
- **Description:**Adds a new student to the database..
- **Request Example:**
  GET http://localhost:8080/students

   ### 4️⃣ Update Student ****
- **Endpoint:** `post /students/{id}`
- **Description:**Updates the details of an existing student
- **Request Example:**
  put http://localhost:8080/students

   ### 5️⃣ Search Student by Name ****
- **Endpoint:** `post /students/search`
- **Description:**Finds students whose name contains the search string (case-insensitive).
- **Request Example:**
 POST http://localhost:8080/students/search?name=Alice

  ### 6️⃣ Delete Student ****
- **Endpoint:** `DELETE /students/{id}`
- **Description:**Deletes a student record by ID..
- **Request Example:**
DELETE http://localhost:8080/students/3





  
