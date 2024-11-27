package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.ClassTime;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

public interface ClassTimeRepository extends JpaRepository<ClassTime, Long> {
    Optional<ClassTime> findClassTimeBySectionSectionId(Long sectionId);

}
