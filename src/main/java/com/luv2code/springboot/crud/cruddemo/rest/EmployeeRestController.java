package com.luv2code.springboot.crud.cruddemo.rest;

import com.luv2code.springboot.crud.cruddemo.dao.EmployeeDao;
import com.luv2code.springboot.crud.cruddemo.entity.Employee;
import com.luv2code.springboot.crud.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //adding mapping to find all employees
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //adding mapping to find employee by id
    @GetMapping("/employee/{theId}")
    public Employee findById(@PathVariable int theId){
        return employeeService.findById(theId);
    }

    //adding mapping to add employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.saveEmployee(employee);
        return employee;
    }

    //adding mapping to update employee
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);
        return employee;
    }

    //adding mapping to delete a employee
    @DeleteMapping("/employee/{theId}")
    public String deleteEmployee(@PathVariable int theId){
        employeeService.deleteById(theId);
        return "Employee Deleted successfully. Id= "+theId;
    }
}
