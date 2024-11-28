package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Section;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {
    @Query("SELECT e.section FROM Enrollment e " +
            "WHERE e.student.studentId = :studentId")
    List<Section> findSectionsByStudentId(@Param("studentId") Long studentId);


}
