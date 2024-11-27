package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
