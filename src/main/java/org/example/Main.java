package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employee  = new LinkedList<>();


        employee.add(new Employee(1, "John", "Doe"));
        employee.add(new Employee(2, "Jane", "Doe"));
        employee.add(new Employee(3, "John", "Smith"));
        employee.add(new Employee(4, "Jane", "Smith"));
        employee.add(new Employee(5, "John", "Doe"));
        employee.add(new Employee(6, "Jane", "Doe"));

    }

    public static List<Employee> findDuplicates(List<Employee> list){
        Set<Integer> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : list) {
            if (!seen.add(employee.getId())) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }



    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Employee employee : list) {
            int id = employee.getId();
            if (!seen.add(id)) {
                duplicates.add(id);
            } else {
                uniqueMap.put(id, employee);
            }
        }

        for (int duplicateId : duplicates) {
            uniqueMap.remove(duplicateId);
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Employee employee : list) {
            countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Employee employee : list) {
            if (countMap.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }


}