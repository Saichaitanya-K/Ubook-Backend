package com.ttu.blackboard.ttudetails.controller;


import com.ttu.blackboard.ttudetails.DTO.AdvisorDTO;
import com.ttu.blackboard.ttudetails.DTO.AdvisorWithDepartmentDTO;
import com.ttu.blackboard.ttudetails.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("An advisor with the specified ID does not exist");
        }
        return new ResponseEntity<>(advisor, HttpStatus.OK);
    }

}
