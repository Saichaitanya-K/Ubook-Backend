package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.Entity.Student;
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

    public List<StudentDTO> getAllStudents() {

        var models =  studentRepository.findAll();
        var DTOs = new ArrayList<StudentDTO>();
        for (var model : models) {
            DTOs.add(studentToDTO(model));
        }
        return DTOs;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        var student = DTOtoStudent(studentDTO);
        return studentToDTO(studentRepository.save(student));
    }


    private StudentDTO studentToDTO(Student student) {
        var studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setMajor(student.getMajor());
        return studentDTO;
    }

    private Student DTOtoStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAddress(studentDTO.getAddress());
        student.setMajor(studentDTO.getMajor());
        return student;
    }



}
