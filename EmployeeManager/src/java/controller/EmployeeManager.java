/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.Employee;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Anthony Kalkhorani
 */
@Stateless
public class EmployeeManager {
    
@PersistenceContext EntityManager em;


public void createEmployee(Employee employee) {
    em.persist(employee);
}

/** creates query then sorts it using the comparator interface then returns it
should sort all employees in an alphabetic order
*/
public List<Employee> showAllEmployee() {
    Query employeeQuery = em.createQuery("SELECT e FROM Employee e");
    List<Employee> employees = employeeQuery.getResultList();
            Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
      return employees;
}

public void deleteEmployeeById(int id) {
    Employee employee = em.find(Employee.class, id);
    employee.setId(id);
    em.remove(employee);
}
/**
 * 
 * finds the attached object that has the matching id if the entity
 * with the id exists in the databae it will update the employee
 * @param employee
 */
public void updateEmployee(Employee employee) {
    em.merge(employee);
}

    public Employee find(int id) {
        return em.find(Employee.class, id);
    }
  }