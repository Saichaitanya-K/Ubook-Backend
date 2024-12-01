package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findAllBySectionSectionId(Long sectionId);

}
