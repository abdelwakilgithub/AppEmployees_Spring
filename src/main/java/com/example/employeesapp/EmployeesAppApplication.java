package com.example.employeesapp;

import com.example.employeesapp.dao.DepartmentRepository;
import com.example.employeesapp.dao.EmployeeRepository;
import com.example.employeesapp.entities.Department;
import com.example.employeesapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeesAppApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {SpringApplication.run(EmployeesAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.save(new Employee("yasin","malyani","yasin.ml@gmail.com"));
//		employeeRepository.save(new Employee(10,"abdelwakil"));
		departmentRepository.save(new Department("Generale"));
		departmentRepository.save(new Department("RH",new Department("Generale")));
		departmentRepository.save(new Department("development", new Department("Generale")));
		departmentRepository.save(new Department("web", new Department("development")));
		departmentRepository.save(new Department("mobile", new Department("development")));
		employeeRepository.save(new Employee("abdelwakil", new Department("Generale")));


	}
}
