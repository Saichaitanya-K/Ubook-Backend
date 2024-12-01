package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.DTO.CreateGradeDTO;
import com.ttu.blackboard.ttudetails.DTO.SectionAssignmentDTO;
import com.ttu.blackboard.ttudetails.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/items")
    public List<SectionAssignmentDTO> getAssignmentsBySection(Long sectionId) {
        return gradeService.getAllAssignmentsFromSection(sectionId);
    }

    @GetMapping("/itemGrade")
    public ResponseEntity<?> getAssignmentGrade(Long studentId, Long assignmentId) {
        var result = gradeService.getAssignmentGrade(studentId, assignmentId);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A student with the specified ID is not enrolled in " +
                            "a section having the specified assignment ID.");

        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<?> saveAssignment(@RequestBody SectionAssignmentDTO sectionAssignmentDTO) {
        var result = gradeService.saveAssignment(sectionAssignmentDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A section with the specified ID was not found.");
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/gradeItem")
    public ResponseEntity<?> gradeAssignment(@RequestBody CreateGradeDTO createGradeDTO) {
        var result = gradeService.gradeAssignment(createGradeDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The assignment could not be created.");
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }



}
