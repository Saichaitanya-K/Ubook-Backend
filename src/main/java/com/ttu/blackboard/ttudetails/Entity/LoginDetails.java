package com.ttu.blackboard.ttudetails.Entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "login_details")
public class LoginDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  userId; // Primary Key

    @Column(nullable = false, unique = true)
    private String email; // Email must be unique

    @Column(nullable = false)
    private String password; // Password

    @Column(nullable = false)
    private String firstName; // First Name

    @Column(nullable = false)
    private String lastName; // Last Name

    @Column(nullable = false)
    private String status; // Status (e.g., Active, Inactive)

    @Column(nullable = false)
    private String role; // Role (e.g., Admin, User)

    @Column(nullable = false, unique = true)
    private String phone; // Phone number (unique to avoid duplicates)

    private String reportsTo; // Supervisor or manager

    @Column(length = 500)
    private String address; // Address (up to 500 characters)

    // Getters and Setters
    public Long  getUserId() {
        return userId;
    }

    public void setUserId(Long  userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
