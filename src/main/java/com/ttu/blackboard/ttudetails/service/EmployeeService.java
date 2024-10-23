package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.model.employeeskills;
import com.ttu.blackboard.ttudetails.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;



    public List<employeeskills> getAllUsers() {
        return userRepository.findAll();
    }
}
