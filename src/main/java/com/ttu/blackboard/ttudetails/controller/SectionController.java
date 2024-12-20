package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.DTO.CreateSectionDTO;
import com.ttu.blackboard.ttudetails.DTO.SectionDTO;
import com.ttu.blackboard.ttudetails.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping
    public List<SectionDTO> getAllSections() {
        return sectionService.getAllSections();
    }
    @GetMapping("/find")
    public ResponseEntity<?> getSectionById(Long sectionId) {
        SectionDTO section = sectionService.findSection((sectionId));
        if (section == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A section with the specified ID was not found.");
        }
        return new ResponseEntity<>(section, HttpStatus.OK);
    }
    @GetMapping("/takenBy")
    public List<SectionDTO> getSectionsByStudent(Long studentId) {
        return sectionService.findSectionsEnrolledBy(studentId);
    }

    @PostMapping("/enroll")
    public ResponseEntity<?> enrollStudent(@RequestParam Long sectionId, @RequestParam Long studentId) {
        var wasSuccessful = sectionService.enrollStudent(sectionId, studentId);
        if (!wasSuccessful) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The specified student or section was not found.");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/disenroll")
    public ResponseEntity<?> disenrollStudent(@RequestParam Long sectionId, @RequestParam Long studentId) {
        var wasSuccessful = sectionService.disenrollStudent(sectionId, studentId);
        if (!wasSuccessful) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The specified student is not enrolled in the specified section.");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createSection(@RequestBody CreateSectionDTO createSectionDTO) {
        SectionDTO savedSection = sectionService.saveSection(createSectionDTO);
        if (savedSection == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("The section could not be created.");
        }
        return new ResponseEntity<>(savedSection, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateSection(@RequestBody CreateSectionDTO section) {
        SectionDTO updatedSection = sectionService.updateSection(section);
        if (updatedSection == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("The section could not be updated.");
        }
        return new ResponseEntity<>(updatedSection, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteSection(@RequestParam Long sectionId) {
        SectionDTO deletedSection = sectionService.deleteSection(sectionId);
        if (deletedSection == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The section with the specified ID was not found.");
        }
        return new ResponseEntity<>(deletedSection, HttpStatus.OK);
    }

}
