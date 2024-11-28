package com.ttu.blackboard.ttudetails.controller;

import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.Entity.LoginDetails;
import com.ttu.blackboard.ttudetails.service.LoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginDetailsController {

    @Autowired
    private LoginDetailsService loginDetailsService;


    @GetMapping
    public List<LoginDetails> getAllUserts() {
        return loginDetailsService.findAllUsers();
    }

    @PostMapping("/Create")
    public ResponseEntity<LoginDetails> createLoginDetails(

            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String status,
            @RequestParam String role,
            @RequestParam String phone,
            @RequestParam String reportsTo,
            @RequestParam String address) {

        LoginDetails loginDetails = new LoginDetails();

        loginDetails.setEmail(email);
        loginDetails.setPassword(password);
        loginDetails.setFirstName(firstName);
        loginDetails.setLastName(lastName);
        loginDetails.setStatus(status);
        loginDetails.setRole(role);
        loginDetails.setPhone(phone);
        loginDetails.setReportsTo(reportsTo);
        loginDetails.setAddress(address);

        LoginDetails savedDetails = loginDetailsService.saveUser(loginDetails);

        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginDetails> getUserById(@PathVariable Long id) {
        // Call the service to get user details by ID
        LoginDetails user = loginDetailsService.getUserById(id);

        // Return the user details in the response
        return ResponseEntity.ok(user);
    }



    @PutMapping("/{id}")
    public ResponseEntity<LoginDetails> updateUser(
            @PathVariable Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String reportsTo,
            @RequestParam(required = false) String address) {

        // Call the service method with individual parameters
        LoginDetails updatedUser = loginDetailsService.updateUser(
                id, email, password, firstName, lastName, status, role, phone, reportsTo, address);

        // Return the updated user in the response
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        loginDetailsService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}