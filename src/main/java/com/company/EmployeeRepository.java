package com.company;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// EmployeeRepository Class to Handle Data Reading
public class EmployeeRepository {

    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, List<Employee>> managerToEmployees = new HashMap<>();


    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public Map<Integer, List<Employee>> getManagerToEmployees() {
        return managerToEmployees;
    }

    public void loadEmployees(String filePath) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path path = Paths.get(Objects.requireNonNull(classLoader.getResource(filePath)).toURI());
        List<String> lines = Files.readAllLines(path);

        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String firstName = parts[1];
            String lastName = parts[2];
            double salary = Double.parseDouble(parts[3]);
            Integer managerId = parts.length > 4 && !parts[4].isEmpty() ?
                    Integer.parseInt(parts[4]) :
                    null;

            Employee employee = new Employee(id, firstName, lastName, salary, managerId);
            employees.put(id, employee);
            managerToEmployees.computeIfAbsent(managerId, k -> new ArrayList<>()).add(employee);
        }
    }


}
