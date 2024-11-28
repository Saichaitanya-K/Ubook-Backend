package com.ttu.blackboard.ttudetails.service;

import com.ttu.blackboard.ttudetails.DTO.CreateSectionDTO;
import com.ttu.blackboard.ttudetails.DTO.SectionDTO;
import com.ttu.blackboard.ttudetails.Entity.*;
import com.ttu.blackboard.ttudetails.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private TermRepository termRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private ClassTimeRepository classTimeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<SectionDTO> getAllSections() {
        var models = sectionRepository.findAll();
        var DTOs = new ArrayList<SectionDTO>();
        for (var model : models) {
            DTOs.add(new SectionDTO(model));
        }
        return DTOs;
    }
    public SectionDTO findSection(Long sectionId) {
        var section = sectionRepository.findById(sectionId);
        return section.map(SectionDTO::new).orElse(null);
    }
    public List<SectionDTO> findSectionsEnrolledBy(Long studentId) {
        var models = sectionRepository.findSectionsByStudentId(studentId);
        var DTOs = new ArrayList<SectionDTO>();
        for (var model : models) {
            DTOs.add(new SectionDTO(model));
        }
        return DTOs;
    }


    public SectionDTO saveSection(CreateSectionDTO createSectionDTO) {
        boolean existsAlready = sectionRepository.existsById(createSectionDTO.getSectionId());
        if (existsAlready) {
            return null;
        }
        return saveDTO(createSectionDTO);
    }
    public SectionDTO updateSection(CreateSectionDTO createSectionDTO) {
        boolean existsAlready = sectionRepository.existsById(createSectionDTO.getSectionId());
        if (!existsAlready) {
            return null;
        }
        return saveDTO(createSectionDTO);
    }

    public boolean enrollStudent(Long sectionId, Long studentId) {
        Optional<Section> optionalSection = sectionRepository.findById(sectionId);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalSection.isEmpty() || optionalStudent.isEmpty()) {
            return false;
        }
        Section section = optionalSection.get();
        Student student = optionalStudent.get();
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setSection(section);
        enrollmentRepository.save(enrollment);
        return true;
    }

    public boolean disenrollStudent(Long sectionId, Long studentId) {
        boolean exists = enrollmentRepository.existsByStudentStudentIdAndSectionSectionId(studentId, sectionId);
        if (!exists) {
            return false;
        }
        enrollmentRepository.deleteByStudentIdAndSectionId(studentId, sectionId);
        return true;
    }




    public SectionDTO deleteSection(Long sectionId) {
        Optional<Section> section = sectionRepository.findById(sectionId);
        if (section.isEmpty()) {
            return null;
        }
        sectionRepository.delete(section.get());
        return new SectionDTO(section.get());
    }


    private SectionDTO saveDTO(CreateSectionDTO createSectionDTO) {
        Optional<Term> optionalTerm = termRepository.findById(createSectionDTO.getTermId());
        Optional<Course> optionalCourse = courseRepository.findById(createSectionDTO.getCourseNumber());
        Optional<Instructor> optionalInstructor = instructorRepository.findById(createSectionDTO.getInstructorId());
        if (optionalTerm.isEmpty() || optionalCourse.isEmpty() || optionalInstructor.isEmpty()) {
            return null;
        }
        Term term = optionalTerm.get();
        Course course = optionalCourse.get();
        Instructor instructor = optionalInstructor.get();

        var section = new Section();
        section.setLocation(createSectionDTO.getLocation());
        section.setFormat(createSectionDTO.getFormat());

        ClassTime classTime;
        Optional<ClassTime> optionalClassTime
                = classTimeRepository.findClassTimeBySectionSectionId(section.getSectionId());
        if (optionalClassTime.isPresent()) {
            classTime = optionalClassTime.get();
        }
        else {
            classTime = new ClassTime();
            classTime.setSection(section);
            classTime.setClassTimeId(createSectionDTO.getSectionId());
        }
        classTime.setEndTime(createSectionDTO.getEndTime());
        classTime.setStartTime(createSectionDTO.getStartTime());
        classTime.setDays(createSectionDTO.getDays());

        section.setSectionId(createSectionDTO.getSectionId());
        section.setClassTime(classTime);
        section.setTerm(term);
        section.setCourse(course);
        section.setInstructor(instructor);
        return new SectionDTO(sectionRepository.save(section));
    }


}
