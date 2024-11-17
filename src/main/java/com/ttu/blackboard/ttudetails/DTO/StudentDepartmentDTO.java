package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Department;

public class StudentDepartmentDTO {
    StudentDepartmentDTO(Department department) {
        departmentId = department.getDeptId();
        deptName = department.getDeptName();
        deptCode = department.getDeptCode();
    }
    private Long departmentId;
    private String deptName;
    private String deptCode;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
