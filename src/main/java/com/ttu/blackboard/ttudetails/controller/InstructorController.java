package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.DTO.InstructorDTO;
import com.ttu.blackboard.ttudetails.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<InstructorDTO> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/find")
    public ResponseEntity<?> getInstructorById(@RequestParam Long instructorId) {
        InstructorDTO instructor = instructorService.findInstructor(instructorId);
        if (instructor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("An instructor with the specified ID does not exist.");

        }
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createInstructor(@RequestBody InstructorDTO instructor) {
        var savedInstructor = instructorService.saveInstructor(instructor);
        if (savedInstructor == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("An instructor with the specified ID already exists.");
        }
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateInstructor(@RequestBody InstructorDTO instructor) {
        var savedInstructor = instructorService.updateInstructor(instructor);
        if (savedInstructor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("An instructor with the specified ID does not exist.");
        }
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteInstructor(@RequestParam Long instructorId) {
        InstructorDTO deletedInstructor = instructorService.deleteInstructor(instructorId);
        if (deletedInstructor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("An instructor with the specified ID does not exist.");
        }
        return new ResponseEntity<>(deletedInstructor, HttpStatus.OK);
    }


}
