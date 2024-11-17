package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s FROM Student s " +
    "LEFT JOIN FETCH s.department d " +
    "LEFT JOIN FETCH d.advisor a")
    List<Student> findAllWithDetails();
}
