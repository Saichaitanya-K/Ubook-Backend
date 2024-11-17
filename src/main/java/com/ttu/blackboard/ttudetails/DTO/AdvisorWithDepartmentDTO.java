package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Advisor;

public class AdvisorWithDepartmentDTO {
    public AdvisorWithDepartmentDTO(Advisor advisor) {
        advisorId = advisor.getAdvisorId();
        firstName = advisor.getFirstName();
        lastName = advisor.getLastName();
        email = advisor.getEmail();
        if (advisor.getDepartment() != null) {
            department = new SimpleDepartmentDTO(advisor.getDepartment());
        }
    }
    private Long advisorId;
    private String firstName;
    private String lastName;
    private String email;
    private SimpleDepartmentDTO department;

    public Long getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(Long advisorId) {
        this.advisorId = advisorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SimpleDepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(SimpleDepartmentDTO department) {
        this.department = department;
    }
}
