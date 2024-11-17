package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

    @Query("SELECT a FROM Advisor a LEFT JOIN FETCH a.department")
    List<Advisor> findAllAdvisorsWithDepartments();

    @Query("SELECT a FROM Advisor a WHERE a.department.deptId = :departmentId")
    Optional<Advisor> findAdvisorByDepartmentId(Long departmentId);
}
