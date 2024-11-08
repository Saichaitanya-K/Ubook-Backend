package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  TermRepository extends JpaRepository<Term, Long> {
    public Term findBySeasonAndYear(String season, int year);
    public boolean existsBySeasonAndYear(String season, int year);
}
