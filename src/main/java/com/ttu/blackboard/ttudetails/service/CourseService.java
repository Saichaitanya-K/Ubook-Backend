package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.CourseDTO;
import com.ttu.blackboard.ttudetails.DTO.CourseWithDeptIdDTO;
import com.ttu.blackboard.ttudetails.Entity.Advisor;
import com.ttu.blackboard.ttudetails.Entity.Course;
import com.ttu.blackboard.ttudetails.Entity.Department;
import com.ttu.blackboard.ttudetails.repository.AdvisorRepository;
import com.ttu.blackboard.ttudetails.repository.CourseRepository;
import com.ttu.blackboard.ttudetails.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private AdvisorRepository advisorRepository;

    public List<CourseDTO> getAllCourses() {
        var models = courseRepository.findAll();
        var DTOs = new ArrayList<CourseDTO>();
        for (var model : models) {
            DTOs.add(new CourseDTO(model));
        }
        return DTOs;
    }

    public CourseDTO saveCourse(CourseWithDeptIdDTO course) {
        boolean existsAlready = advisorRepository.existsById(course.getCourseNumber());
        if (existsAlready) {
            return null;
        }
        return saveDTO(course);
    }

    private CourseDTO saveDTO(CourseWithDeptIdDTO courseDTO) {
        Optional<Department> optionalDepartment = departmentRepository.findById(courseDTO.getDepartmentId());
        if (optionalDepartment.isEmpty()) {
            return null;
        }
        Department department = optionalDepartment.get();
        var course = new Course();
        course.setCourseNumber(courseDTO.getCourseNumber());
        course.setCourseName(courseDTO.getCourseName());
        course.setDepartment(department);
        return new CourseDTO(courseRepository.save(course));
    }


}
