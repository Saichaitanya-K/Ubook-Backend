package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

    @Query("SELECT a FROM Advisor a LEFT JOIN FETCH a.department")
    List<Advisor> findAllAdvisorsWithDepartments();
}
