package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Section;
import org.springframework.data.jpa.repository.*;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
