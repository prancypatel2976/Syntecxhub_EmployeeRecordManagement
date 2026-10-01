package com.employee.management;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int choice;
        System.out.println("======================================");
        System.out.println("     EMPLOYEE RECORD MANAGEMENT");
        System.out.println("======================================");
        do {
            System.out.println();
            System.out.println("----------- MENU -----------");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("----------------------------");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addEmployee(scanner, manager);
                    break;
                case 2:
                    viewEmployees(manager);
                    break;
                case 3:
                    searchEmployee(scanner, manager);
                    break;
                case 4:
                    updateEmployee(scanner, manager);
                    break;
                case 5:
                    deleteEmployee(scanner, manager);
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
        while (choice != 6);
        scanner.close();
    }

    // Add Employee
    private static void addEmployee(Scanner scanner, EmployeeManager manager) {

        System.out.println("\n--- Add Employee ---");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Employee employee = new Employee(id, name, department, salary);
        if (manager.addEmployee(employee)) {
            System.out.println("Employee added successfully.");
        } 
        else {
            System.out.println("Employee ID already exists.");
        }
    }

    // View Employees
    private static void viewEmployees(EmployeeManager manager) {

        System.out.println("\n--- Employee Records ---");
        if (manager.getAllEmployees().isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }
        for (Employee employee : manager.getAllEmployees()) {
            System.out.println(employee);
        }
    }

    // Search Employee
    private static void searchEmployee(Scanner scanner, EmployeeManager manager) {

        System.out.println("\n--- Search Employee ---");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee employee = manager.findEmployee(id);
        if (employee != null) {
            System.out.println("Employee found:");
            System.out.println(employee);
        }
        else {
            System.out.println("Employee not found.");
        }
    }

    // Update Employee
    private static void updateEmployee(Scanner scanner, EmployeeManager manager) {

        System.out.println("\n--- Update Employee ---");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee employee = manager.findEmployee(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter New Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        boolean updated = manager.updateEmployee(id, name, department, salary);
        if (updated) {
            System.out.println("Employee updated successfully.");
        } 
        else {
            System.out.println("Employee update failed.");
        }
    }

    // Delete Employee
    private static void deleteEmployee(Scanner scanner, EmployeeManager manager) {

        System.out.println("\n--- Delete Employee ---");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean deleted = manager.deleteEmployee(id);
        if (deleted) {
            System.out.println("Employee deleted successfully.");
        } 
        else {
            System.out.println("Employee not found.");
        }
    }
}