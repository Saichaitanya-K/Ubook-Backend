package com.ttu.blackboard.ttudetails.repository;


import com.ttu.blackboard.ttudetails.Entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long> {
    // Custom queries can be added here if needed
    Optional<LoginDetails> findByEmailAndPassword(String email, String password);
}