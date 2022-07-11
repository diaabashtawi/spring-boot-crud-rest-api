package com.bashtawi.main.controller;


import com.bashtawi.main.dao.StudentsDAO;
import com.bashtawi.main.entity.Students;
import com.bashtawi.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsRestController {

    private StudentService studentService;

    @Autowired
    public StudentsRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Students> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/student/{studentId}")
    public Students getStudent(@PathVariable int studentId){
        Students students = studentService.findById(studentId);

        if (students == null){
            throw new RuntimeException("Student ID NOT FOUND!!!!! - " + studentId);
        }

        return students;
    }

    @PostMapping("/students")
    public Students addStudent(@RequestBody Students student){

        student.setId(0);

        studentService.save(student);

        return student;
    }

    @PutMapping("/students")
    public Students updateStudent(@RequestBody Students student){

        studentService.save(student);

        return student;
    }

    @DeleteMapping("/student/{studentId}")
    public String deleteStudent(@PathVariable int studentId){

        Students students = studentService.findById(studentId);

        if (students == null){
            throw new RuntimeException("Student ID NOT FOUND!!!!! - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Delete Student ID - " + studentId;
    }




}
