package com.ttu.blackboard.ttudetails.DTO;


import com.ttu.blackboard.ttudetails.Entity.Assignment;

public class SectionAssignmentDTO {
    private Long assignmentId;
    private String name;
    private Integer totalPoints;
    private Long sectionId;

    public SectionAssignmentDTO() {

    }

    public SectionAssignmentDTO(Assignment assignment) {
        assignmentId = assignment.getAssignmentId();
        name = assignment.getName();
        totalPoints = assignment.getTotalPoints();
        sectionId = assignment.getSection().getSectionId();
    }
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

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}
