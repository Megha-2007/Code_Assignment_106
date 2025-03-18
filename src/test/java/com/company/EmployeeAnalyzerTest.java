package com.company;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class EmployeeAnalyzerTest {
    private Map<Integer, Employee> employees;
    private Map<Integer, List<Employee>> managerToEmployees;

    @BeforeEach
    void setUp() {
        employees = new HashMap<>();
        managerToEmployees = new HashMap<>();

        Employee ceo = new Employee(123, "Joe", "Doe", 60000, null);
        Employee manager1 = new Employee(124, "Martin", "Chekov", 45000, 123);
        Employee manager2 = new Employee(200, "Sarah", "Connor", 42000, 124);
        Employee employee1 = new Employee(300, "Alice", "Hasacat", 50000, 200);
        Employee employee2 = new Employee(305, "Brett", "Hardleaf", 34000, 300);
        Employee employee3 = new Employee(310, "Michael", "Smith", 32000, 305);

        employees.put(123, ceo);
        employees.put(124, manager1);
        employees.put(200, manager2);
        employees.put(300, employee1);
        employees.put(305, employee2);
        employees.put(310, employee3);

        managerToEmployees.put(123, List.of(manager1));
        managerToEmployees.put(124, List.of(manager2));
        managerToEmployees.put(200, List.of(employee1));
        managerToEmployees.put(300, List.of(employee2));
        managerToEmployees.put(305, List.of(employee3));
    }


    @Test
    void testSalaryAnalysis() {
        SalaryAnalyzer analyzer = new SalaryAnalyzer();
        analyzer.analyzeSalaries(employees, managerToEmployees);
    }

    @Test
    void testReportingAnalysis() {
        ReportingAnalyzer analyzer = new ReportingAnalyzer();
        analyzer.analyzeReportingLines(employees);
    }
}
