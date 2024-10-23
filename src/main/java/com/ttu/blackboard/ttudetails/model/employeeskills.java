package com.ttu.blackboard.ttudetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

;


@Entity
public class employeeskills {
    public Integer getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Integer id) {
        this.EmployeeID = id;
    }

    public String getSkills() {
        return Skill;
    }

    public void setSkill(String skill) {
        Skill = skill;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EmployeeID;
    private String Skill;

    @Override
    public String toString() {
        return "User{" +
                "id=" + EmployeeID +
                ", Skill='" + Skill + '\'' +

                '}';
    }

}
