package com.ttu.blackboard.ttudetails.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @Column(nullable = false, unique = true)
    private String termCode;

    @Column(nullable = false)
    private String termName;

    // Constructors, getters, and setters
    public Term() {}

    public Long getTermId() { return termId; }
    public void setTermId(Long termId) { this.termId = termId; }

    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }

    public String getTermName() { return termName; }
    public void setTermName(String termName) { this.termName = termName; }
}
