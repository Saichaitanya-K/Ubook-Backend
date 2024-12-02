package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.Entity.AdvisorNew;
import com.ttu.blackboard.ttudetails.repository.AdvisorNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisorNewService {

    @Autowired
    private AdvisorNewRepository advisorNewRepository;

    public List<AdvisorNew> getAllAdvisors() {
        return advisorNewRepository.findAll();
    }

    public AdvisorNew saveAdvisorNew(AdvisorNew advisorNew) {
        return advisorNewRepository.save(advisorNew);
    }
}