package com.ttu.blackboard.ttudetails.controller;


import com.ttu.blackboard.ttudetails.model.employeeskills;
import com.ttu.blackboard.ttudetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService empservice;

    // Endpoint to return all users in JSON format
    @GetMapping("/")
    public List<employeeskills> getAllUsers() {
        return empservice.getAllUsers();
    }
}
