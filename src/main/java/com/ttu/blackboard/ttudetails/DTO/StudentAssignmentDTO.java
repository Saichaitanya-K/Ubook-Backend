package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.AssignmentGrade;

public class StudentAssignmentDTO {
    private Long assignmentId;
    private Long gradeId;
    private Long studentId;
    private Long sectionId;
    private String name;
    private boolean isGraded;
    private Integer earnedPoints;
    private Integer totalPoints;

    public StudentAssignmentDTO() {

    }

    public StudentAssignmentDTO(AssignmentGrade assignmentGrade){
        assignmentId = assignmentGrade.getAssignment().getAssignmentId();
        gradeId = assignmentGrade.getGradeId();
        studentId = assignmentGrade.getEnrollment().getStudent().getStudentId();
        sectionId = assignmentGrade.getEnrollment().getSection().getSectionId();
        name = assignmentGrade.getAssignment().getName();
        isGraded = assignmentGrade.isGraded();
        earnedPoints = assignmentGrade.getEarnedPoints();
        totalPoints = assignmentGrade.getAssignment().getTotalPoints();

    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }

    public Integer getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(Integer earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
}
