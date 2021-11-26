package com.example.employeesapp.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    private Date birth_date;

    @ManyToOne()
    @JoinColumn(name = "parent_employee")
    private  Employee parent_employee;

    @ManyToOne()
    @JoinColumn(name = "department")
    private  Department department;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String email, String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
    }

    public Employee(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Employee(String first_name, Department department) {
        this.first_name = first_name;
        this.department = department;
    }

    public Employee(long id, String first_name) {
        this.id = id;
        this.first_name = first_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Employee getParent_employee() {
        return parent_employee;
    }

    public void setParent_employee(Employee parent_employee) {
        this.parent_employee = parent_employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

