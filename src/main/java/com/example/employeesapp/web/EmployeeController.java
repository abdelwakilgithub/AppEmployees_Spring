package com.example.employeesapp.web;

import com.example.employeesapp.entities.Employee;
import com.example.employeesapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces={"application/json","application/xml"})
    public ResponseEntity<Iterable<Employee>> getAll() {
    	return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @GetMapping(value="/{id}", produces={"application/json","application/xml"})
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Optional<Employee> d = employeeService.getEmployeeById(id);
		if (d.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(d.get());
		}
	}


	@PutMapping({"/{id}"})
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>(employeeService.getEmployeeById(id).get(), HttpStatus.OK);
	}

	@PostMapping(
//			value="/addEmployee",
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
		employeeService.insert(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
    	employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
