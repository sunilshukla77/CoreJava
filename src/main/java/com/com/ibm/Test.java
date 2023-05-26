package com.com.ibm;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {

        Employee e = new Employee(1,"Sunil", 20, "IT", 20000);
        Employee e1 = new Employee(2,"Vinav", 30, "CS", 30000);
        Employee e2 = new Employee(3,"Manish", 35, "ECS", 50000);

        List<Employee> empList = List.of(e,e1,e2);

        System.out.println("Show map where age > 21, increment salary increment salary 5000, " +
                "sort employeeId in desc order " +
                "collect output as Map key employeeId value is employee obj");

        Map<Integer, Employee> map1= empList.stream()
                .filter(employee -> employee.getAge()>21)
                .map(employee -> {
                    int incrementedSalary = employee.getSalary()+5000;
                    employee.setSalary(incrementedSalary);
                    return employee;
                })
                .collect(Collectors.toMap(Employee::getId, i->i))
                .entrySet()
                .stream()
                .sorted((employeeEntry1,employeeEntry2) -> employeeEntry2.getKey().compareTo(employeeEntry1.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(employee1,employee2)-> employee1, LinkedHashMap::new));

        map1.entrySet().forEach(System.out::println);

        Map<String, Integer> retVal = empList.stream()
                .collect(Collectors.toMap(Employee::getDept, Employee::getId,
                        BinaryOperator.maxBy(Comparator.comparing(empList::get))));
        System.out.println("\n\t\t");
        retVal.entrySet().forEach(System.out::println);

        System.out.println("Employee id is key and value Employee");
        empList.stream().collect(Collectors.toMap(Employee::getId, i->i))
                .entrySet().forEach(System.out::println);

        System.out.println("Collect department vise salary in the map where (key is deplt) and (value is salary)");

        Map<String, Integer> emplList= empList.stream().collect(Collectors.toMap(i->i.getDept(), i->i.salary));
        emplList.entrySet().stream().forEach(System.out::println);

    }

    //static sum()

    // Li age >21, increment salary increment salary 5000,  sort employees, based on employeeId in desc
    // collect output as Map key employeeId value is employee obj

    //2. Collect deptment vise salary in the map where (key is deplt) and (value is salary)

// 3. 2D [2][2] 1+2+3+4 = 10;

    /*
    int[] val = {1,2,3,4};

        int[][] val1 = {{1,2},{3,4}};
        //
        int sum= 0;
        for (int i = 0; i < val.length; i++) {

            for (int j = 0; j < val[i]; j++) {
            //sum+= val[i][j];
            }
            //sum+= val[i];

        }
        System.out.println(sum);
     */
}
