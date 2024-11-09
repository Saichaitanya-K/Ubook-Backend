package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.Entity.Student;
import com.ttu.blackboard.ttudetails.repository.StudentRepository;
import com.ttu.blackboard.ttudetails.views.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentView> getAllStudents() {

        var models =  studentRepository.findAll();
        var views = new ArrayList<StudentView>();
        for (var model : models) {
            views.add(studentToView(model));
        }
        return views;
    }

    public StudentView studentToView(Student student) {
        var studentView = new StudentView();
        studentView.setStudentId(student.getStudentId());
        studentView.setFirstName(student.getFirstName());
        studentView.setLastName(student.getLastName());
        studentView.setAddress(student.getAddress());
        studentView.setMajor(student.getMajor());
        return studentView;
    }
}
