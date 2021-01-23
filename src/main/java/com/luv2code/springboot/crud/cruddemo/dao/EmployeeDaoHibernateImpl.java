package com.luv2code.springboot.crud.cruddemo.dao;

import com.luv2code.springboot.crud.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //adding method for finding all employee
    @Override
    public List<Employee> findAll() {

        //get current session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query of the session
        Query theQuery = currentSession.createQuery("from Employee", Employee.class);

        //get the query result
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    //adding method for finding an employee by id
    @Override
    public Employee findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, theId);
        return employee;
    }

    //adding method for save or update
    @Override
    public void saveEmployee(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    //adding method for deleteing an employee by id
    @Override
    public void deleteById(int theId) {

        //get current session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query of the session
        Query theQuery = currentSession.createQuery("delete from Employee where id=: employeeID");

        theQuery.setParameter("employeeID", theId);

        //get the query result
        theQuery.executeUpdate();
    }
}
