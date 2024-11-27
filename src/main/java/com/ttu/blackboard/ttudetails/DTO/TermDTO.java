package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Term;

import java.util.Objects;

public class TermDTO {
    private String termCode;
    private String termDescription;

    public TermDTO() {

    }
    public TermDTO(Term term) {
        termCode = term.getYear() + toCode(term.getSeason());
        termDescription = term.getSeason() + " " + term.getYear();
    }
    private String toCode(String season) {
        if (Objects.equals(season, "Fall"))
            return "01";
        if (Objects.equals(season, "Spring"))
            return "02";
        if (Objects.equals(season, "Summer"))
            return "03";
        return "-1";
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermDescription() {
        return termDescription;
    }

    public void setTermDescription(String termDescription) {
        this.termDescription = termDescription;
    }
}
