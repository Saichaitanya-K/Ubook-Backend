package com.ttu.blackboard.ttudetails.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Assignment {
    @Id
    private Long assignmentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer totalPoints;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "assignment")
    private Collection<AssignmentGrade> grades;

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}

