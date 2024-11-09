package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.service.StudentService;
import com.ttu.blackboard.ttudetails.views.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ttu.blackboard.ttudetails.Entity.Student;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentView> getAllStudents() {
        return studentService.getAllStudents();
    }

}
