package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Doe"));
        employees.add(new Employee(3, "Jim", "Beam"));
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(4, "Jack", "Daniels"));
        employees.add(new Employee(2, "Jane", "Doe"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Uniques: " + uniques.values());

        List<Employee> noDuplicates = removeDuplicates(employees);
        System.out.println("No Duplicates: " + noDuplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Integer> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : list) {
            if (employee == null) continue;
            if (!seen.add(employee.getId())) {
                duplicates.add(employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee employee : list) {
            if (employee == null) continue;
            int id = employee.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
        }

        for (Employee employee : list) {
            if (employee == null) continue;
            int id = employee.getId();
            if (countMap.get(id) == 1) {
                uniqueMap.put(id, employee);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Employee employee : list) {
            if (employee == null) continue;
            countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Employee employee : list) {
            if (employee == null) continue;
            if (countMap.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }
}
