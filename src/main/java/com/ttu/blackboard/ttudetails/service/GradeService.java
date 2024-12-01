package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.CreateGradeDTO;
import com.ttu.blackboard.ttudetails.DTO.SectionAssignmentDTO;
import com.ttu.blackboard.ttudetails.DTO.StudentAssignmentDTO;
import com.ttu.blackboard.ttudetails.Entity.Assignment;
import com.ttu.blackboard.ttudetails.Entity.AssignmentGrade;
import com.ttu.blackboard.ttudetails.repository.AssignmentRepository;
import com.ttu.blackboard.ttudetails.repository.EnrollmentRepository;
import com.ttu.blackboard.ttudetails.repository.GradeRepository;
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
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private GradeRepository gradeRepository;


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

    private StudentAssignmentDTO gradeAssignment(CreateGradeDTO dto) {
        var assignment = assignmentRepository.findById(dto.getAssignmentId());
        if (assignment.isEmpty()) {
            return null;
        }
        var sectionId = assignment.get().getSection().getSectionId();
        var enrollment = enrollmentRepository.findByStudentStudentIdAndSectionSectionId(dto.getStudentId(), sectionId);
        if (enrollment.isEmpty()) {
            return null;
        }
        AssignmentGrade assignmentGrade;

        var optionalAssignmentGrade = gradeRepository.findByAssignmentAssignmentIdAndEnrollmentEnrollmentId
                (dto.getAssignmentId(), enrollment.get().getEnrollmentId());
        if (optionalAssignmentGrade.isPresent()) {
            assignmentGrade = optionalAssignmentGrade.get();
        }
        else {
            assignmentGrade = new AssignmentGrade();
            assignmentGrade.setAssignment(assignment.get());
            assignmentGrade.setEnrollment(enrollment.get());
        }
        assignmentGrade.setGraded(true);
        assignmentGrade.setEarnedPoints(dto.getEarnedPoints());

        return new StudentAssignmentDTO(gradeRepository.save(assignmentGrade));
    }


    public StudentAssignmentDTO getAssignmentGrade(Long studentId, Long assignmentId) {
        var assignment = assignmentRepository.findById(assignmentId);
        if (assignment.isEmpty()) {
            return null;
        }
        var sectionId = assignment.get().getSection().getSectionId();
        var enrollment = enrollmentRepository.findByStudentStudentIdAndSectionSectionId(studentId, sectionId);
        if (enrollment.isEmpty()) {
            return null;
        }
        AssignmentGrade assignmentGrade;
        var optionalAssignmentGrade = gradeRepository.findByAssignmentAssignmentIdAndEnrollmentEnrollmentId
                (assignmentId, enrollment.get().getEnrollmentId());
        if (optionalAssignmentGrade.isPresent()) {
            assignmentGrade = optionalAssignmentGrade.get();
        }
        else {
            assignmentGrade = new AssignmentGrade();
            assignmentGrade.setAssignment(assignment.get());
            assignmentGrade.setEnrollment(enrollment.get());
            assignmentGrade.setEarnedPoints(0);
        }

        return new StudentAssignmentDTO(gradeRepository.save(assignmentGrade));
    }




}
