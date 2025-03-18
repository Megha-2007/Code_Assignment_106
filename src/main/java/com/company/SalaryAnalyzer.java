package com.company;

import java.util.List;
import java.util.Map;

/// / SalaryAnalyzer Class for Analyzing Salary Violations
public class SalaryAnalyzer {

    public void analyzeSalaries(Map<Integer, Employee> employees, Map<Integer, List<Employee>> managerToEmployees) {
        managerToEmployees.forEach((managerId, subordinates) -> {
            if (managerId == null) return; // Skip CEO

            Employee manager = employees.get(managerId);

            double avgSubSalary = subordinates.stream()
                    .mapToDouble(Employee::salary)
                    .average()
                    .orElse(0);

            double minSalary = avgSubSalary * 1.2;

            double maxSalary = avgSubSalary * 1.5;

            if (manager.salary() < minSalary) {
                System.out.printf("%s %s earns too little: %.2f%n", manager.firstName(), manager.lastName(), (minSalary - manager.salary()));
            } else if (manager.salary() > maxSalary) {
                System.out.printf("%s %s earns too much: %.2f%n", manager.firstName(), manager.lastName(), (manager.salary() - maxSalary));
            }
        });
    }
}
