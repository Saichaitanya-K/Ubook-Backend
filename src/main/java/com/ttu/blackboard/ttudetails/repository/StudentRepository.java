package com.ttu.blackboard.ttudetails.repository;

import com.ttu.blackboard.ttudetails.DTO.StudentDTO;
import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s FROM Student s " +
    "LEFT JOIN FETCH s.department d " +
    "LEFT JOIN FETCH d.advisor a")
    List<Student> findAllWithDetails();

    @Query("SELECT s FROM Student s " +
            "JOIN FETCH s.department d " +
            "JOIN FETCH d.advisor " +
            "WHERE d.deptId = :departmentId")
    List<Student> findByDepartment(@Param("departmentId") Long departmentId);

    @Query("SELECT e.student FROM Enrollment e " +
            "WHERE e.section.sectionId = :sectionId")
    List<Student> findStudentsBySectionId(@Param("sectionId") Long sectionId);


}
