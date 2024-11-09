package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.service.TermService;
import com.ttu.blackboard.ttudetails.DTO.TermDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terms")
@CrossOrigin
public class TermController {


    @Autowired
    private TermService termService;

    @GetMapping
    public List<TermDTO> getAllTerms() {
        return termService.getAllTerms();
    }

    @PostMapping()
    public ResponseEntity<?> createTerm(@RequestParam("termCode") String termCode) {
        TermDTO savedTerm = termService.saveTerm(termCode);
        if (savedTerm == null)
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("This term already exists");
        return new ResponseEntity<>(savedTerm, HttpStatus.CREATED);

    }

    @DeleteMapping()
    public ResponseEntity<?> deleteTerm(@RequestParam("termCode") String termCode) {
        TermDTO deletedTerm = termService.deleteTerm(termCode);
        if (deletedTerm == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("This term does not exist");
        return new ResponseEntity<>(deletedTerm, HttpStatus.NO_CONTENT);
    }

}
