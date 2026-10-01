package com.employee.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeManager {

    // List to store employee objects
    private List<Employee> employeeList = new ArrayList<>();

    // Map for fast employee lookup using employee ID
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    // Set to ensure employee IDs are unique
    private Set<Integer> employeeIds = new HashSet<>();

    // Add employee
    public boolean addEmployee(Employee employee) {

        if (employeeIds.contains(employee.getId())) {
            return false;
        }

        employeeList.add(employee);
        employeeMap.put(employee.getId(), employee);
        employeeIds.add(employee.getId());

        return true;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Search employee by ID
    public Employee findEmployee(int id) {
        return employeeMap.get(id);
    }

    // Update employee
    public boolean updateEmployee(int id, String name,
                                  String department, double salary) {

        Employee employee = employeeMap.get(id);

        if (employee == null) {
            return false;
        }

        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);

        return true;
    }

    // Delete employee
    public boolean deleteEmployee(int id) {

        Employee employee = employeeMap.get(id);

        if (employee == null) {
            return false;
        }

        employeeList.remove(employee);
        employeeMap.remove(id);
        employeeIds.remove(id);

        return true;
    }
}