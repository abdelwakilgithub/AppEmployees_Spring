package com.example.employeesapp.web;

import com.example.employeesapp.entities.Department;
import com.example.employeesapp.entities.Employee;
import com.example.employeesapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(produces={"application/json","application/xml"})
    public ResponseEntity<Iterable<Department>> getAll() {
        return ResponseEntity.ok().body(departmentService.getDepartments());
    }

    @PostMapping(
//			value="/addEmployee",
            consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<Department> insertDepartment(@RequestBody Department department) {
        departmentService.insert(department);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
