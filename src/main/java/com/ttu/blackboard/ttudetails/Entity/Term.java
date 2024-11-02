package com.ttu.blackboard.ttudetails.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @Column(nullable = false)
    private String season;

    @Column(nullable = false)
    private Integer year;

    // Constructors, getters, and setters
    public Term() {}

    public Long getTermId() { return termId; }
    public void setTermId(Long termId) { this.termId = termId; }

    public String getSeason() { return season; }
    public void setSeason(String termCode) { this.season = termCode; }

    public Integer getYear() { return year; }
    public void setYear(Integer termName) { this.year = termName; }
}
