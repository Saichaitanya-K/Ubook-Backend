package com.ttu.blackboard.ttudetails.Entity;


import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "course")
public class Course {
    @Id
    private Long courseNumber;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private boolean isGraduate;

    @ManyToOne()
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "course")
    private Collection<Section> sections;

    public Long getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Long courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public void setGraduate(boolean graduate) {
        isGraduate = graduate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
