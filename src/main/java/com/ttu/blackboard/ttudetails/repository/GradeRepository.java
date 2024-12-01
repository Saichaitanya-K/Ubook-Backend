package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.AssignmentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<AssignmentGrade, Long> {


}
