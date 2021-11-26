package com.example.employeesapp.services;

import com.example.employeesapp.dao.EmployeeRepository;
import com.example.employeesapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }


    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void updateEmployee(Long id, Employee employee) {
        Employee employeeFromDb = employeeRepository.findById(id).get();
        System.out.println(employeeFromDb.toString());
        employeeFromDb.setFirst_name(employee.getFirst_name());
        employeeFromDb.setLast_name(employee.getLast_name());
        employeeFromDb.setEmail(employee.getEmail());
        employeeFromDb.setPhone(employee.getPhone());
        employeeFromDb.setBirth_date(employee.getBirth_date());
        employeeFromDb.setDepartment(employee.getDepartment());
        employeeFromDb.setParent_employee(employee.getParent_employee());
        employeeRepository.save(employeeFromDb);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
