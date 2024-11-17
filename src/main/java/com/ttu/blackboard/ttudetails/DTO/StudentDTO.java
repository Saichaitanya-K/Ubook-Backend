package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.Entity.Student;

public class StudentDTO {

    public StudentDTO(Student student)
    {
        studentId = student.getStudentId();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
        address = student.getAddress();
        department = new StudentDepartmentDTO(student.getDepartment());
        if (student.getDepartment().getAdvisor() != null)
            advisor = new AdvisorDTO(student.getDepartment().getAdvisor());
    }

    private Long studentId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private StudentDepartmentDTO department;
    private AdvisorDTO advisor;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentDepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(StudentDepartmentDTO department) {
        this.department = department;
    }

    public AdvisorDTO getAdvisor() {
        return advisor;
    }

    public void setAdvisor(AdvisorDTO advisor) {
        this.advisor = advisor;
    }
}
