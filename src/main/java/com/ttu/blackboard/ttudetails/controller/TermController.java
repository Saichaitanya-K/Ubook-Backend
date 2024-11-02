package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.Entity.Term;
import com.ttu.blackboard.ttudetails.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terms")
@CrossOrigin
public class TermController {


    @Autowired
    private TermService termService;

    @GetMapping
    public List<Term> getAllTerms() {
        return termService.getAllTerms();
    }

    @PostMapping()
    public Term createTerm(@RequestParam("Season") String season, @RequestParam("Year") Integer year) {

        Term term = new Term();
        term.setSeason(season);
        term.setYear(year);
        return termService.saveTerm(term);
    }

    // Additional endpoints for updating, deleting, etc.
}
