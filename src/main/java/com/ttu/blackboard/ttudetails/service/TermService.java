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
            termViews.add(termToView(term));
        }
        return termViews;
    }

    public TermView saveTerm(String termCode) {
        Term term = codeToTerm(termCode);
        boolean existsAlready = termRepository.existsBySeasonAndYear(term.getSeason(), term.getYear());
        if (existsAlready) {
            return null;
        }

        return termToView(termRepository.save(codeToTerm(termCode)));
    }

    public TermView deleteTerm(String termCode) {
         Term term = codeToTerm(termCode);
         Term termInDB = termRepository.findBySeasonAndYear(term.getSeason(), term.getYear());
         if (termInDB == null) {
             return null;
         }
         termRepository.delete(termInDB);
         return termToView(termInDB);
    }

    private TermView termToView(Term term) {
        var termView = new TermView();
        termView.setTermCode(term.getYear() + toCode(term.getSeason()));
        termView.setTermDescription(term.getSeason() + " " + term.getYear());
        return termView;
    }

    private Term codeToTerm(String termCode) {
        Term term = new Term();
        term.setYear(Integer.parseInt(termCode.substring(0, 4)));
        term.setSeason(toSeason(termCode.substring(4, 6)));
        return term;
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
