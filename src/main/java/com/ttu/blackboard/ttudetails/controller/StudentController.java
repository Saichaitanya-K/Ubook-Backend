package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.Entity.Student;
import com.ttu.blackboard.ttudetails.service.StudentService;
import com.ttu.blackboard.ttudetails.DTO.StudentDTO;
import com.ttu.blackboard.ttudetails.service.TermService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO savedStudent = studentService.saveStudent(studentDTO);
        if (savedStudent == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A student with the specified ID already exists");
        }
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO updatedStudent = studentService.updateStudent(studentDTO);
        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A student with the specified ID does not exists");
        }
        return new ResponseEntity<>(updatedStudent, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestParam Long studentId){
        StudentDTO deletedStudent = studentService.deleteStudent(studentId);
        if (deletedStudent == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A student with the specified ID does not exists");
        }
        return new ResponseEntity<>(deletedStudent, HttpStatus.CREATED);
    }

}
