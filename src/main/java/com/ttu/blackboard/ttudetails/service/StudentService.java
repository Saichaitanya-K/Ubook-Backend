package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.CreateStudentDTO;
import com.ttu.blackboard.ttudetails.Entity.Student;
import com.ttu.blackboard.ttudetails.repository.DepartmentRepository;
import com.ttu.blackboard.ttudetails.repository.StudentRepository;
import com.ttu.blackboard.ttudetails.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<StudentDTO> getAllStudents() {

        var models = studentRepository.findAllWithDetails();
        var DTOs = new ArrayList<StudentDTO>();
        for (var model : models) {
            DTOs.add(new StudentDTO(model));
        }
        return DTOs;
    }

    public StudentDTO saveStudent(CreateStudentDTO studentDTO) {
        boolean existsAlready = studentRepository.existsById(studentDTO.getStudentId());
        if (existsAlready) {
            return null;
        }
        var student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setAddress(studentDTO.getAddress());
        var department = departmentRepository.findById(studentDTO.getDepartmentId());
        department.ifPresent(student::setDepartment);
        var savedStudent = studentRepository.save(student);
        return new StudentDTO(savedStudent);
    }

/*    public StudentDTO updateStudent(StudentDTO studentDTO) {
        *//*boolean existsAlready = studentRepository.existsById(studentDTO.getStudentId());
        if (!existsAlready) {
            return null;
        }
        var DTOstudent = DTOtoStudent(studentDTO);
        return studentToDTO(studentRepository.save(DTOstudent));*//*

    }*/
    /*public StudentDTO deleteStudent(Long studentId) {
        *//*Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            return null;
        }
        studentRepository.delete(student.get());
        return studentToDTO(student.get());*//*
    }*/

    /*private StudentDTO studentToDTO(Student student) {
        var studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    private Student DTOtoStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        return student;
    }*/



}