package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.AdvisorDTO;
import com.ttu.blackboard.ttudetails.DTO.AdvisorWithDepartmentDTO;
import com.ttu.blackboard.ttudetails.DTO.CreateAdvisorDTO;
import com.ttu.blackboard.ttudetails.DTO.StudentDTO;
import com.ttu.blackboard.ttudetails.Entity.Advisor;
import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.repository.AdvisorRepository;
import com.ttu.blackboard.ttudetails.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdvisorService {
    @Autowired
    private AdvisorRepository advisorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

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

    public AdvisorWithDepartmentDTO findAdvisorByDepartment(Long departmentId) {
        var advisor = advisorRepository.findAdvisorByDepartmentId(departmentId);
        return advisor.map(AdvisorWithDepartmentDTO::new).orElse(null);
    }

    public AdvisorWithDepartmentDTO saveAdvisor(CreateAdvisorDTO advisor) {
        boolean existsAlready = advisorRepository.existsById(advisor.getAdvisorId());
        if (existsAlready) {
            return null;
        }
        return saveDTO(advisor);
    }

    private AdvisorWithDepartmentDTO saveDTO(CreateAdvisorDTO advisorDTO) {
        var advisor = new Advisor();
        advisor.setAdvisorId(advisorDTO.getAdvisorId());
        advisor.setFirstName(advisorDTO.getFirstName());
        advisor.setLastName(advisorDTO.getLastName());
        advisor.setEmail(advisorDTO.getEmail());
        var savedAdvisor = advisorRepository.save(advisor);
        return new AdvisorWithDepartmentDTO(savedAdvisor);

    }

    public AdvisorWithDepartmentDTO updateAdvisor(CreateAdvisorDTO advisor) {
        boolean existsAlready = advisorRepository.existsById(advisor.getAdvisorId());
        if (!existsAlready) {
            return null;
        }
        return saveDTO(advisor);
    }

    public AdvisorWithDepartmentDTO deleteAdvisor(Long advisorId) {
        Optional<Advisor> advisor = advisorRepository.findById(advisorId);
        if (advisor.isEmpty()) {
            return null;
        }
        advisorRepository.delete(advisor.get());
        return new AdvisorWithDepartmentDTO(advisor.get());
    }


    public AdvisorWithDepartmentDTO assignAdvisorToDepartment(Long advisorId, Long departmentId) {
        Optional<Advisor> optionalAdvisor = advisorRepository.findById(advisorId);
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isEmpty() || optionalAdvisor.isEmpty()) {
            return null;
        }
        Advisor advisor = optionalAdvisor.get();
        Department department = optionalDepartment.get();
        advisor.setDepartment(department);
        department.setAdvisor(advisor);
        departmentRepository.save(department);
        return new AdvisorWithDepartmentDTO(advisorRepository.save(advisor));


    }
}
