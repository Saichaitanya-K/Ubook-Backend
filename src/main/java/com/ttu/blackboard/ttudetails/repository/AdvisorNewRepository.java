package com.ttu.blackboard.ttudetails.repository;
import com.ttu.blackboard.ttudetails.Entity.AdvisorNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvisorNewRepository extends JpaRepository<AdvisorNew, Long> {

    List<AdvisorNew> findByDepartmentIsNull();
}