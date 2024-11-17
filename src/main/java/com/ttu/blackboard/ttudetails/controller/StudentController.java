package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.DTO.CreateStudentDTO;
import com.ttu.blackboard.ttudetails.service.StudentService;
import com.ttu.blackboard.ttudetails.DTO.StudentDTO;
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
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentDTO student){
        StudentDTO savedStudent = studentService.saveStudent(student);
        if (savedStudent == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A student with the specified ID already exists");
        }
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody CreateStudentDTO studentDTO){
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
                    .body("A student with the specified ID does not exist");
        }
        return new ResponseEntity<>(deletedStudent, HttpStatus.CREATED);
    }

}
