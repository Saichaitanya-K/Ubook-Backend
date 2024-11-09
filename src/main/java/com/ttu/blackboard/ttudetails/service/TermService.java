package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.Entity.Term;
import com.ttu.blackboard.ttudetails.repository.TermRepository;
import com.ttu.blackboard.ttudetails.DTO.TermDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TermService {

    @Autowired
    private TermRepository termRepository;

    public List<TermDTO> getAllTerms() {
        var terms = termRepository.findAll();
        var termDTOs = new ArrayList<TermDTO>();
        for (var term : terms) {
            termDTOs.add(termToDTO(term));
        }
        return termDTOs;
    }

    public TermDTO saveTerm(String termCode) {
        Term term = codeToTerm(termCode);
        boolean existsAlready = termRepository.existsBySeasonAndYear(term.getSeason(), term.getYear());
        if (existsAlready) {
            return null;
        }

        return termToDTO(termRepository.save(codeToTerm(termCode)));
    }

    public TermDTO deleteTerm(String termCode) {
         Term term = codeToTerm(termCode);
         Term termInDB = termRepository.findBySeasonAndYear(term.getSeason(), term.getYear());
         if (termInDB == null) {
             return null;
         }
         termRepository.delete(termInDB);
         return termToDTO(termInDB);
    }

    private TermDTO termToDTO(Term term) {
        var termDTO = new TermDTO();
        termDTO.setTermCode(term.getYear() + toCode(term.getSeason()));
        termDTO.setTermDescription(term.getSeason() + " " + term.getYear());
        return termDTO;
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
