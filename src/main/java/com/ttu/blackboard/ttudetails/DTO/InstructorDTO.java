package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Instructor;
import jakarta.persistence.*;


public class InstructorDTO {
    private Long instructorId;
    private String firstName;
    private String lastName;
    private String email;
    private String reportsTo;

    public InstructorDTO() {

    }
    public InstructorDTO(Instructor instructor) {
        instructorId = instructor.getInstructorId();
        firstName = instructor.getFirstName();
        lastName = instructor.getLastName();
        email = instructor.getEmail();
        reportsTo = instructor.getReportsTo();
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
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

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }
}
