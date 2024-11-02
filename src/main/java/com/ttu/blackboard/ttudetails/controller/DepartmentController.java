package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    // Create a new department using request parameters
    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @RequestParam String deptCode,
            @RequestParam String deptName,
            @RequestParam String deptStatus,
            @RequestParam String deptCreatedDate) {

        // Convert String to LocalDate
        LocalDate createdDate = LocalDate.parse(deptCreatedDate);

        // Create a new Department instance
        Department department = new Department();
        department.setDeptCode(deptCode);
        department.setDeptName(deptName);
        department.setDeptStatus(deptStatus);
        department.setDeptCreatedDate(createdDate);

        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // Edit an existing department using request parameters
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Long id,
            @RequestParam String deptCode,
            @RequestParam String deptName,
            @RequestParam String deptStatus,
            @RequestParam String deptCreatedDate) {

        // Convert String to LocalDate
        LocalDate createdDate = LocalDate.parse(deptCreatedDate);

        // Create a new Department instance
        Department department = new Department();
        department.setDeptId(id); // Ensure the ID remains the same
        department.setDeptCode(deptCode);
        department.setDeptName(deptName);
        department.setDeptStatus(deptStatus);
        department.setDeptCreatedDate(createdDate);

        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    // Delete a department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        if (departmentService.deleteDepartment(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }

}