package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.exception.ResourceNotFoundException;
import com.ttu.blackboard.ttudetails.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department updateDepartment(Long id, Department department) {
        // Check if the department with the given ID exists
        Optional<Department> existingDepartmentOptional = departmentRepository.findById(id);

        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();

            // Only update fields that are not null (optional fields)
            if (department.getDeptCode() != null) {
                existingDepartment.setDeptCode(department.getDeptCode());
            }
            if (department.getDeptName() != null) {
                existingDepartment.setDeptName(department.getDeptName());
            }
            if (department.getDeptStatus() != null) {
                existingDepartment.setDeptStatus(department.getDeptStatus());
            }
            if (department.getDeptCreatedDate() != null) {
                existingDepartment.setDeptCreatedDate(department.getDeptCreatedDate());
            }

            // Save and return the updated department
            return departmentRepository.save(existingDepartment);
        } else {
            // Handle the case where the department doesn't exist
            throw new ResourceNotFoundException("Department with id " + id + " not found");
        }
    }

    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}