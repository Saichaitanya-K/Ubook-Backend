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
import java.util.Optional;

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
        return saveDTO(studentDTO);
    }

    public StudentDTO updateStudent(CreateStudentDTO studentDTO) {
        boolean existsAlready = studentRepository.existsById(studentDTO.getStudentId());
        if (!existsAlready) {
            return null;
        }
        return saveDTO(studentDTO);

    }

    private StudentDTO saveDTO(CreateStudentDTO studentDTO) {
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
    public StudentDTO deleteStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            return null;
        }
        studentRepository.delete(student.get());
        return new StudentDTO(student.get());
    }

}