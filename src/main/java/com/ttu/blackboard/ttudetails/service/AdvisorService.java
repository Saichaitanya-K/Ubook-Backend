package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.AdvisorDTO;
import com.ttu.blackboard.ttudetails.DTO.AdvisorWithDepartmentDTO;
import com.ttu.blackboard.ttudetails.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvisorService {
    @Autowired
    private AdvisorRepository advisorRepository;

    public List<AdvisorWithDepartmentDTO> getAllAdvisors() {
        var models = advisorRepository.findAllAdvisorsWithDepartments();
        var DTOs = new ArrayList<AdvisorWithDepartmentDTO>();
        for (var model : models) {
            DTOs.add(new AdvisorWithDepartmentDTO(model));
        }
        return DTOs;
    }

    public AdvisorWithDepartmentDTO findAdvisor(Long advisorId) {
        var advisor = advisorRepository.findById(advisorId);
        return advisor.map(AdvisorWithDepartmentDTO::new).orElse(null);
    }
}
