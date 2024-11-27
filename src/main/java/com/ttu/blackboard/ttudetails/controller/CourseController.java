package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.DTO.CourseDTO;
import com.ttu.blackboard.ttudetails.DTO.CourseWithDeptIdDTO;
import com.ttu.blackboard.ttudetails.service.AdvisorService;
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
    @Autowired
    private AdvisorService advisorService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/find")
    public ResponseEntity<?> getCourseById(@RequestParam("courseNumber") Long courseNumber) {
        CourseDTO course = courseService.findCourse(courseNumber);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A course with the specified ID does not exist.");
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody CourseWithDeptIdDTO course) {
        CourseDTO savedCourse = courseService.saveCourse(course);
        if (savedCourse == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The course could not be created. A course with the specified ID already exists, or a department" +
                            "with the specified department ID does not exist.");
        }
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCourse(@RequestBody CourseWithDeptIdDTO course) {
        CourseDTO updatedCourse = courseService.updateCourse(course);
        if (updatedCourse == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The course could not be updated. A course with the specified course number does not exist, or a department" +
                            " with the specified department ID does not exist.");
        }
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCourse(@RequestParam Long courseNumber) {
        CourseDTO deletedCourse = courseService.deleteCourse(courseNumber);
        if (deletedCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A course with the specified course number does not exist.");
        }
        return new ResponseEntity<>(deletedCourse, HttpStatus.OK);
    }






}
