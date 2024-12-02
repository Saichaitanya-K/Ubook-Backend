package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.Entity.AdvisorNew;
import com.ttu.blackboard.ttudetails.service.AdvisorNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisornew")
public class AdvisorNewController {

    @Autowired
    private AdvisorNewService advisorNewService;

    @GetMapping
    public ResponseEntity<List<AdvisorNew>> getAllAdvisors() {
        return ResponseEntity.ok(advisorNewService.getAllAdvisors());
    }

    @PostMapping
    public ResponseEntity<AdvisorNew> createAdvisorNew(@RequestBody AdvisorNew advisorNew) {
        return ResponseEntity.ok(advisorNewService.saveAdvisorNew(advisorNew));
    }
}