package com.luv2code.springboot.crud.cruddemo.dao;

import com.luv2code.springboot.crud.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void saveEmployee(Employee employee);
    public void deleteById(int theId);
}
