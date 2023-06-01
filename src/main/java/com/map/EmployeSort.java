package com.map;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// Problem is we have List 10K employee (name, sal, department)
// I/O : List of Employee
// O/P : Print spend money on top 2 department
public class EmployeSort {

    public static void main(String[] args) {

        Employee e = new Employee(1,"Sunil", 20, "IT", 20000);
        Employee e1 = new Employee(2,"Vinav", 30, "CS", 30000);
        Employee e2 = new Employee(3,"Manish", 35, "ECS", 50000);

        Employee e3 = new Employee(1,"Sunil", 20, "IT", 20000);
        Employee e4 = new Employee(2,"Vinav", 30, "CS", 30000);
        Employee e5 = new Employee(3,"Manish", 35, "ECS", 50000);

        List<Employee> empList = List.of(e,e1,e2,e3,e4,e5);

        Set<String> listDept =
                empList.stream()
                .flatMap(employee -> employee.getDept().lines().parallel())
                        .collect(Collectors.toSet());

        listDept.forEach(System.out::println);

        // Map key is department and Value is List of Employee
        Map<String, List<Employee>> deptList = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept));

        deptList.entrySet().stream().forEach(System.out::println);

        // Create Map where key is Department and Key is Sum of Employee Salary
        Map<String, Integer> sumOfSal = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept, Collectors.summingInt(Employee::getSalary)));

        sumOfSal.entrySet().stream().forEach(System.out::println);
        System.out.println("\n\n");

        // Sort the sumMap and create new map
        List<Entry<String, Integer>> mapLinkedLs = sumOfSal.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder())).limit(2)
                .collect(Collectors.toCollection(ArrayList::new));

        mapLinkedLs.stream().forEach(System.out::println);
    }

}
