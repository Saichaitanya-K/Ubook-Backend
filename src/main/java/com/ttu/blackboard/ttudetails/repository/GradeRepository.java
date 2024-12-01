package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.AssignmentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<AssignmentGrade, Long> {
    Optional<AssignmentGrade> findByAssignmentAssignmentIdAndEnrollmentEnrollmentId(long assignmentId, long enrollmentId);

}
