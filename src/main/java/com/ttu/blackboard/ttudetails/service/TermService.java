package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.Entity.Term;
import com.ttu.blackboard.ttudetails.repository.TermRepository;
import com.ttu.blackboard.ttudetails.views.TermView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TermService {

    @Autowired
    private TermRepository termRepository;

    public List<TermView> getAllTerms() {
        var terms = termRepository.findAll();
        var termViews = new ArrayList<TermView>();
        for (var term : terms) {
            var termView = new TermView();
            termView.setTermCode(term.getYear() + toCode(term.getSeason()));
            termView.setTermDescription(term.getSeason() + " " + term.getYear());
            termViews.add(termView);
        }
        return termViews;
    }

    public Term saveTerm(TermView termView) {
        Term term = new Term();
        term.setYear(Integer.parseInt(termView.getTermCode().substring(0, 4)));
        term.setSeason(toSeason(termView.getTermCode().substring(4, 6)));
        return termRepository.save(term);
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

    private String toSeason(String season) {
        if (Objects.equals(season, "01"))
            return "Fall";
        if (Objects.equals(season, "02"))
            return "Spring";
        if (Objects.equals(season, "03"))
            return "Summer";
        return "Unknown";
    }
}
