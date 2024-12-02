package com.ttu.blackboard.ttudetails.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "advisornew")
public class AdvisorNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for this table

    @ManyToOne
    @JoinColumn(name = "advisor_id", referencedColumnName = "userId", nullable = false)
    private LoginDetails advisor; // Foreign key to LoginDetails table

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "deptId", nullable = true)
    private Department department; // Foreign key to Department table

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoginDetails getAdvisor() {
        return advisor;
    }

    public void setAdvisor(LoginDetails advisor) {
        this.advisor = advisor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
