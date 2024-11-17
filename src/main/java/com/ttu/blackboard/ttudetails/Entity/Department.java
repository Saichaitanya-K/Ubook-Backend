package com.ttu.blackboard.ttudetails.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    @Column(nullable = false, unique = true)
    private String deptCode;

    @Column(nullable = false)
    private String deptName;

    @Column(nullable = false)
    private String deptStatus;

    @Column(nullable = false)
    private LocalDate deptCreatedDate;

    @OneToOne(mappedBy = "department", optional = true)
    private Advisor advisor;

    // Constructors, getters, and setters
    public Department() {}

    public Long getDeptId() { return deptId; }
    public void setDeptId(Long deptId) { this.deptId = deptId; }

    public String getDeptCode() { return deptCode; }
    public void setDeptCode(String deptCode) { this.deptCode = deptCode; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public String getDeptStatus() { return deptStatus; }
    public void setDeptStatus(String deptStatus) { this.deptStatus = deptStatus; }

    public LocalDate getDeptCreatedDate() { return deptCreatedDate; }
    public void setDeptCreatedDate(LocalDate deptCreatedDate) { this.deptCreatedDate = deptCreatedDate; }

    @OneToMany(mappedBy = "department")
    private Collection<Student> students;

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }
}
