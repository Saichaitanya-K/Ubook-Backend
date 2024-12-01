package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.SectionAssignmentDTO;
import com.ttu.blackboard.ttudetails.Entity.Assignment;
import com.ttu.blackboard.ttudetails.repository.AssignmentRepository;
import com.ttu.blackboard.ttudetails.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class GradeService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private SectionRepository sectionRepository;


    public List<SectionAssignmentDTO> getAllAssignmentsFromSection(Long sectionId) {
        var models = assignmentRepository.findAllBySectionSectionId(sectionId);
        var DTOs = new ArrayList<SectionAssignmentDTO>();
        for (var model : models) {
            DTOs.add(new SectionAssignmentDTO(model));
        }
        return DTOs;
    }

    public SectionAssignmentDTO saveAssignment(SectionAssignmentDTO dto) {
        return saveDTO(dto);
    }

    private SectionAssignmentDTO saveDTO(SectionAssignmentDTO dto) {

        var section = sectionRepository.findById(dto.getSectionId());
        if (section.isEmpty()) {
            return null;
        }
        var assignment = new Assignment();
        assignment.setAssignmentId(dto.getAssignmentId());
        assignment.setName(dto.getName());
        assignment.setTotalPoints(dto.getTotalPoints());
        assignment.setSection(section.get());
        return new SectionAssignmentDTO(assignmentRepository.save(assignment));
    }


}
