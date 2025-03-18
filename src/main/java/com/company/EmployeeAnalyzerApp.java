package com.company;

import java.io.IOException;
import java.net.URISyntaxException;

// Main Application Class
public class EmployeeAnalyzerApp {
    public static void main(String[] args) throws IOException, URISyntaxException {
        EmployeeRepository repository = new EmployeeRepository();
        repository.loadEmployees("employees.csv");

        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer();
        salaryAnalyzer.analyzeSalaries(repository.getEmployees(), repository.getManagerToEmployees());

        ReportingAnalyzer reportingAnalyzer = new ReportingAnalyzer();
        reportingAnalyzer.analyzeReportingLines(repository.getEmployees());
    }
}
