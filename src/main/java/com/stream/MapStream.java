package com.stream;

import com.core.dto.Department;
import com.core.dto.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStream {

    public List<Employee> empList;
    public Employee emp;
    public Employee emp1;
    public Employee emp2;

    Map<String, Integer> mapEmp;

    @Before
    public void setup() {
        empList = new ArrayList<>();
        String[] city = {"Nagpur", "Pune", "Bangalore", "Indore"};
        emp = new Employee("Sunil", 35, Arrays.asList(city), 4000, new Department(2, "Employee", "Mumbai"));
        empList.add(emp);

        Stream<String> st = Stream.of("Noida", "Pune", "Mumbai");
        emp1 = new Employee("Raj Kumar Ji", 30,
                st.collect(Collectors.toList()), 5000, new Department(3, "Manager", "Bangalore"));
        empList.add(emp1);

        Stream<String> st1 = Stream.of("Pune", "New York", "Mumbai");
        emp2 = new Employee("Manish", 37,
                st1.collect(Collectors.toList()), 6000, new Department(1, "Manager", "Pune"));
        empList.add(emp2);
        //key name and Salary value
        mapEmp = empList.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
    }

    @Test
    public void AscSortKey() {
        //Sort Map by key and Value
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        mapEmp.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> linkedMap.put(e.getKey(), e.getValue()));
        System.out.println("Asc Sorted key " + linkedMap);
    }

    @Test
    public void DescSortKey(){
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        mapEmp.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByKey().reversed()).forEach(e -> linkedMap.put(e.getKey(), e.getValue()));
        System.out.println("Desc Sorted key " + linkedMap);
    }

    @Test
    public void AscSortValue() {
        //Sort Map by key and Value
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        mapEmp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).limit(1).forEach(e -> linkedMap.put(e.getKey(), e.getValue()));
        System.out.println("Asc Sorted Value " + linkedMap);
    }
}
