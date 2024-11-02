package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.Entity.Term;
import com.ttu.blackboard.ttudetails.repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TermService {

    @Autowired
    private TermRepository termRepository;

    public List<Term> getAllTerms() {
        return termRepository.findAll();
    }

    public Term saveTerm(Term term) {
        return termRepository.save(term);
    }

    // Additional methods for updating, deleting, etc.
}
