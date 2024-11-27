package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Section;

import java.time.LocalTime;

public class SectionDTO {
    private Long sectionId;
    private String format;
    private String location;
    private String days;
    private LocalTime startTime;
    private LocalTime endTime;
    private InstructorDTO instructor;
    private CourseDTO course;
    private TermDTO term;

    public SectionDTO(Section section) {
        sectionId = section.getSectionId();
        format = section.getFormat();
        location = section.getLocation();
        days = section.getClassTime().getDays();
        startTime = section.getClassTime().getStartTime();
        endTime = section.getClassTime().getEndTime();
        instructor = new InstructorDTO(section.getInstructor());
        course = new CourseDTO(section.getCourse());
        term = new TermDTO(section.getTerm());
    }


    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public InstructorDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorDTO instructor) {
        this.instructor = instructor;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public TermDTO getTerm() {
        return term;
    }

    public void setTerm(TermDTO term) {
        this.term = term;
    }
}
