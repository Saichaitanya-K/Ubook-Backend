package com.ttu.blackboard.ttudetails.Entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class ClassTime {
    @Id
    private Long classTimeId;
    @Column(nullable = false)
    private String days;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;
    @OneToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    public Long getClassTimeId() {
        return classTimeId;
    }

    public void setClassTimeId(Long classTimeId) {
        this.classTimeId = classTimeId;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
