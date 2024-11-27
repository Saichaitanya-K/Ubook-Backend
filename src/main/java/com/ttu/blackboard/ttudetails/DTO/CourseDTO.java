package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Course;

public class CourseDTO {
    private String departmentCode;
    private Long courseNumber;
    private String courseName;
    private boolean isGraduate;

    public CourseDTO(Course course) {
        departmentCode = course.getDepartment().getDeptCode();
        courseNumber = course.getCourseNumber();
        courseName = course.getCourseName();
        isGraduate = course.isGraduate();
    }



    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Long getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Long courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public void setGraduate(boolean graduate) {
        isGraduate = graduate;
    }
}
