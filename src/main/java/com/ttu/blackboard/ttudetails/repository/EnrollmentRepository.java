package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Enrollment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Enrollment e WHERE e.student.studentId = :studentId AND e.section.sectionId = :sectionId")
    void deleteByStudentIdAndSectionId(@Param("studentId") Long studentId, @Param("sectionId") Long sectionId);

    boolean existsByStudentStudentIdAndSectionSectionId(Long studentId, Long sectionId);
}
