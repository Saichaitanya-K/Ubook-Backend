package com.ttu.blackboard.ttudetails.service;


import com.ttu.blackboard.ttudetails.Entity.AdvisorNew;
import com.ttu.blackboard.ttudetails.Entity.LoginDetails;
import com.ttu.blackboard.ttudetails.repository.AdvisorNewRepository;
import com.ttu.blackboard.ttudetails.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginDetailsService {

    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    @Autowired
    private AdvisorNewRepository advisorNewRepository;

    // Find all users
    public List<LoginDetails> findAllUsers() {
        return loginDetailsRepository.findAll();
    }

    // Find user by ID
    public LoginDetails getUserById(Long id) {
        return loginDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Save a new user
    public LoginDetails saveUser(LoginDetails loginDetails) {
        // Additional validation can be added here
        return loginDetailsRepository.save(loginDetails);
    }

    public LoginDetails updateUser(
            Long id,
            String email,
            String password,
            String firstName,
            String lastName,
            String status,
            String role,
            String phone,
            String reportsTo,
            String address) {

        // Find the user by id
        LoginDetails existingUser = loginDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Only update the fields that are provided in the URL, keep existing values for others
        if (email != null) {
            existingUser.setEmail(email);
        }
        if (password != null) {
            existingUser.setPassword(password);
        }
        if (firstName != null) {
            existingUser.setFirstName(firstName);
        }
        if (lastName != null) {
            existingUser.setLastName(lastName);
        }
        if (status != null) {
            existingUser.setStatus(status);
        }
        if (role != null) {
            existingUser.setRole(role);
        }
        if (phone != null) {
            existingUser.setPhone(phone);
        }
        if (reportsTo != null) {
            existingUser.setReportsTo(reportsTo);
        }
        if (address != null) {
            existingUser.setAddress(address);
        }

        // Save the updated user back to the database
        return loginDetailsRepository.save(existingUser);
    }

    // Delete a user
    public boolean deleteUser(Long id) {
        if (loginDetailsRepository.existsById(id)) {
            loginDetailsRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public LoginDetails validateUser(String email, String password) {
        // Find user by email and password
        Optional<LoginDetails> user = loginDetailsRepository.findByEmailAndPassword(email, password);
        return user.orElse(null);
    }


    public void createAdvisor(LoginDetails loginDetails) {


        AdvisorNew advisorNew = new AdvisorNew();
        advisorNew.setAdvisor(loginDetails); // Set the LoginDetails entity as advisor
        advisorNew.setDepartment(null); // Set the Department entity

        // Save the AdvisorNew entity to the database
        advisorNewRepository.save(advisorNew);
    }


}