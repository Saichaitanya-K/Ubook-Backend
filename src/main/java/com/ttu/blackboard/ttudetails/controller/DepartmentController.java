package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.DTO.StudentDTO;
import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

    @GetMapping("/find")
    public ResponseEntity<?> getDepartmentById(@RequestParam Long departmentId) {
        var department = departmentService.findDepartment(departmentId);
        if (department == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A department with the specified ID does not exist");
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // Create a new department using request parameters
    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @RequestParam String deptCode,
            @RequestParam String deptName,
            @RequestParam String deptStatus,
            @RequestParam String deptCreatedDate) {

        // Convert String to LocalDate
        // Validate the date format
        LocalDate createdDate = null;
        try {
            createdDate = LocalDate.parse(deptCreatedDate);
        } catch (DateTimeParseException e) {
            // Return bad request if the date format is invalid
            return ResponseEntity.badRequest().body(null);
        }


        // Create a new Department instance
        Department department = new Department();
        department.setDeptCode(deptCode);
        department.setDeptName(deptName);
        department.setDeptStatus(deptStatus);
        department.setDeptCreatedDate(createdDate);

        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.status(201).body(savedDepartment);
    }

    // Update a department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Long id,
            @RequestParam(required = false) String deptCode,
            @RequestParam(required = false) String deptName,
            @RequestParam(required = false) String deptStatus,
            @RequestParam(required = false) String deptCreatedDate) {

        // Convert deptCreatedDate to LocalDate if provided
        // Initialize deptCreatedDate as null
        LocalDate createdDate = null;

        // Only parse deptCreatedDate if it is provided
        if (deptCreatedDate != null && !deptCreatedDate.isEmpty()) {
            try {
                createdDate = LocalDate.parse(deptCreatedDate); // Parse the provided date
            } catch (DateTimeParseException e) {
                // Return bad request if the date is invalid
                return ResponseEntity.badRequest().body(null);
            }
        }


        // Create a new Department instance and update only provided fields
        Department department = new Department();
        department.setDeptCode(deptCode);
        department.setDeptName(deptName);
        department.setDeptStatus(deptStatus);
        department.setDeptCreatedDate(createdDate);

        // Call the service method to update the department
        Department updatedDepartment = departmentService.updateDepartment(id, department);

        // Return the updated department in the response
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

}