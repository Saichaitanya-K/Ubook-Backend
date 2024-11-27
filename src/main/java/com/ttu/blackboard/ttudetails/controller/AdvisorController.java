package com.ttu.blackboard.ttudetails.controller;


import com.ttu.blackboard.ttudetails.DTO.AdvisorDTO;
import com.ttu.blackboard.ttudetails.DTO.AdvisorWithDepartmentDTO;
import com.ttu.blackboard.ttudetails.DTO.CreateAdvisorDTO;
import com.ttu.blackboard.ttudetails.service.AdvisorService;
import com.ttu.blackboard.ttudetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisors")
public class AdvisorController {
    @Autowired
    private AdvisorService advisorService;

    @GetMapping
    public List<AdvisorWithDepartmentDTO> getAllAdvisors() {
        return advisorService.getAllAdvisors();
    }
    @GetMapping("/find")
    public ResponseEntity<?> getAdvisorById(@RequestParam Long advisorId) {
        AdvisorWithDepartmentDTO advisor = advisorService.findAdvisor(advisorId);
        if (advisor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("An advisor with the specified ID does not exist.");
        }
        return new ResponseEntity<>(advisor, HttpStatus.OK);
    }

    @GetMapping("/of")
    public ResponseEntity<?> getAdvisorByDepartment(@RequestParam Long departmentId) {
        AdvisorWithDepartmentDTO advisor = advisorService.findAdvisorByDepartment(departmentId);
        if (advisor == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("An advisor assigned to a department with that specified ID does not exist");
        }
        return new ResponseEntity<>(advisor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAdvisor(@RequestBody CreateAdvisorDTO advisor) {
        AdvisorWithDepartmentDTO savedAdvisor = advisorService.saveAdvisor(advisor);
        if (savedAdvisor == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("An advisor with the specified ID already exists");
        }
        return new ResponseEntity<>(savedAdvisor, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> updateAdvisor(@RequestBody CreateAdvisorDTO advisor) {
        AdvisorWithDepartmentDTO savedAdvisor = advisorService.updateAdvisor(advisor);
        if (savedAdvisor == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("An advisor with the specified ID does not exist");
        }
        return new ResponseEntity<>(savedAdvisor, HttpStatus.CREATED);
    }

    @PutMapping("/assign")
    public ResponseEntity<?> assignAdvisorToDepartment(@RequestParam Long advisorId, @RequestParam Long departmentId) {
        AdvisorWithDepartmentDTO advisor = advisorService.assignAdvisorToDepartment(advisorId, departmentId);
        if (advisor == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("One of the IDs is invalid");
        }
        return new ResponseEntity<>(advisor, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAdvisor(@RequestParam Long advisorId) {
        AdvisorWithDepartmentDTO deletedAdvisor = advisorService.deleteAdvisor(advisorId);
        if (deletedAdvisor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("An advisor with the specified ID does not exist");
        }
        return new ResponseEntity<>(deletedAdvisor, HttpStatus.OK);
    }


}
