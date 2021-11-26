package com.example.employeesapp.services;

import com.example.employeesapp.dao.DepartmentRepository;
import com.example.employeesapp.entities.Department;
import com.example.employeesapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public Department insert(Department department) {
        return departmentRepository.save(department);
    }
}
