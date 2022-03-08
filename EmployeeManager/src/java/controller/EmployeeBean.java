/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import entity.Employee;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Anthony Kalkhorani
 */
@Named(value = "employeeBean")
@RequestScoped
public class EmployeeBean {

    @Inject
    private EmployeeManager employeeMgr;

    private int id;
    private Employee employee = new Employee();

    private String firstName;
    private String lastName;
    private int salary;

    private List<Employee> getAll;

    public String addController() {
        employee = new Employee(firstName, lastName, salary);
        employeeMgr.createEmployee(employee);
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteController() {
        employeeMgr.deleteEmployeeById(id);
        return "index.xhtml?faces-redirect=true";
    }

    
    public String update() {

        Employee emp = new Employee(id, firstName, lastName, salary);

        employeeMgr.updateEmployee(emp);

        return "index.xhtml?faces-redirect=true";

    }

    @PostConstruct
    public void viewAllController() {
        this.getAll = employeeMgr.showAllEmployee();
    }

    public EmployeeBean() {
    }

    public EmployeeManager getEmployeeMgr() {
        return employeeMgr;
    }

    public void setEmployeeMgr(EmployeeManager employeeMgr) {
        this.employeeMgr = employeeMgr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Employee> getGetAll() {
        return getAll;
    }

    public void setGetAll(List<Employee> getAll) {
        this.getAll = getAll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
