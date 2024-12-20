package com.ttu.blackboard.ttudetails.DTO;

import com.ttu.blackboard.ttudetails.Entity.Course;

public class CourseWithDeptIdDTO {
    private Long departmentId;
    private Long courseNumber;
    private String courseName;
    private boolean isGraduate;

    public CourseWithDeptIdDTO() {

    }
    public CourseWithDeptIdDTO(Course course) {
        departmentId = course.getDepartment().getDeptId();
        courseNumber = course.getCourseNumber();
        courseName = course.getCourseName();
        isGraduate = course.isGraduate();
    }



    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
