package com.ttu.blackboard.ttudetails.repository;


import com.ttu.blackboard.ttudetails.model.employeeskills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaRepository<employeeskills, Integer> {

}
