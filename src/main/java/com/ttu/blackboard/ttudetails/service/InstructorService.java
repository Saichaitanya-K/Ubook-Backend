package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.InstructorDTO;
import com.ttu.blackboard.ttudetails.Entity.Instructor;
import com.ttu.blackboard.ttudetails.repository.AdvisorRepository;
import com.ttu.blackboard.ttudetails.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<InstructorDTO> getAllInstructors() {
        var models = instructorRepository.findAll();
        var DTOs = new ArrayList<InstructorDTO>();
        for (var model : models) {
            DTOs.add(new InstructorDTO(model));
        }
        return DTOs;
    }

    public InstructorDTO findInstructor(Long instructorId) {
        var instructor = instructorRepository.findById(instructorId);
        return instructor.map(InstructorDTO::new).orElse(null);
    }

    public InstructorDTO saveInstructor(InstructorDTO instructor) {
        boolean existsAlready = instructorRepository.existsById(instructor.getInstructorId());
        if (existsAlready) {
            return null;
        }
        return saveDTO(instructor);
    }

    public InstructorDTO updateInstructor(InstructorDTO instructor) {
        boolean existsAlready = instructorRepository.existsById(instructor.getInstructorId());
        if (!existsAlready) {
            return null;
        }
        return saveDTO(instructor);
    }

    private InstructorDTO saveDTO(InstructorDTO instructorDTO) {
        var instructor = new Instructor();
        instructor.setInstructorId(instructorDTO.getInstructorId());
        instructor.setFirstName(instructorDTO.getFirstName());
        instructor.setLastName(instructorDTO.getLastName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setReportsTo(instructorDTO.getReportsTo());
        var savedInstructor = instructorRepository.save(instructor);
        return new InstructorDTO(savedInstructor);
    }


    public InstructorDTO deleteInstructor(Long instructorId) {
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        if (instructor.isEmpty()) {
            return null;
        }
        instructorRepository.delete(instructor.get());
        return new InstructorDTO(instructor.get());
    }
}
