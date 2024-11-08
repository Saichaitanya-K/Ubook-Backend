package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.Entity.Term;
import com.ttu.blackboard.ttudetails.service.TermService;
import com.ttu.blackboard.ttudetails.views.TermView;
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
    public List<TermView> getAllTerms() {
        return termService.getAllTerms();
    }

    @PostMapping()
    public Term createTerm(@RequestParam("Season") String termCode, @RequestParam("Year") String termDescription) {

        TermView termView = new TermView();
        termView.setTermCode(termCode);
        termView.setTermDescription(termDescription);
        return termService.saveTerm(termView);
    }

}
