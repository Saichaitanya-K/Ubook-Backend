package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Department;

import java.time.LocalDate;

public class DepartmentDTO {
    public DepartmentDTO(Department department) {
        departmentId = department.getDeptId();
        deptName = department.getDeptName();
        deptCode = department.getDeptCode();
        deptStatus = department.getDeptStatus();
        deptCreatedDate = department.getDeptCreatedDate();
    }
    private Long departmentId;
    private String deptName;
    private String deptCode;
    private LocalDate deptCreatedDate;
    private String deptStatus;

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

    public LocalDate getDeptCreatedDate() {
        return deptCreatedDate;
    }

    public void setDeptCreatedDate(LocalDate deptCreatedDate) {
        this.deptCreatedDate = deptCreatedDate;
    }

    public String getDeptStatus() {
        return deptStatus;
    }

    public void setDeptStatus(String deptStatus) {
        this.deptStatus = deptStatus;
    }
}
