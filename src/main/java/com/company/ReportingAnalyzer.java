package com.company;

import java.util.Map;


// ReportingAnalyzer Class for Analyzing Reporting Depth
public class ReportingAnalyzer {

    public void analyzeReportingLines(Map<Integer, Employee> employees) {
        employees.values()
                .forEach(employee -> {
                    int depth = getReportingDepth(employee.id(), employees);
                    if (depth > 4) {
                        System.out.printf("%s %s has a reporting line too long by %d levels.%n", employee.firstName(), employee.lastName(), (depth - 4));
                    }
                });
    }

    private int getReportingDepth(int employeeId, Map<Integer, Employee> employees) {
        int depth = 0;
        Employee current = employees.get(employeeId);
        while (current.managerId() != null) {
            depth++;
            current = employees.get(current.managerId());
        }
        return depth;
    }
}
