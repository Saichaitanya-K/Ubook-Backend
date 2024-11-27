package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.DTO.CourseDTO;
import com.ttu.blackboard.ttudetails.DTO.CourseWithDeptIdDTO;
import com.ttu.blackboard.ttudetails.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }
    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody CourseWithDeptIdDTO course) {
        CourseDTO savedCourse = courseService.saveCourse(course);
        if (savedCourse == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The course could not be created. A course with the specified ID already exists or a department" +
                            "with the specified department ID does not exist.");
        }
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }



}
