package com.stream;

import com.core.dto.Department;
import com.core.dto.Employee;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamMapGroupTest {

    public List<Employee> empList;
    public Employee emp;
    public Employee emp1;
    public Employee emp2;

    @Before
    public void setup() {
        empList = new ArrayList<>();
        String[] city = {"Nagpur", "Pune", "Bangalore", "Indore"};
        emp = new Employee("Sunil", 35, Arrays.asList(city), 4000, new Department(2, "Employee", "Mumbai"));
        empList.add(emp);

        Stream<String> st = Stream.of("Noida", "Pune", "Mumbai");
        emp1 = new Employee("Raj Kumar Ji", 30, st.collect(Collectors.toList()), 5000,
                new Department(3, "Manager", "Bangalore"));
        empList.add(emp1);

        Stream<String> st1 = Stream.of("Pune", "New York", "Mumbai");
        emp2 = new Employee("Manish", 37, st1.collect(Collectors.toList()), 6000,
                new Department(1, "Manager", "Pune"));
        empList.add(emp2);

    }

    @Test
    public void StreamTest() {
        // top 2 Highest salaryStream
        System.out.println("Top 2 Highest salaryStream");
        Stream<Integer> salaryStream = Stream.of(2000, 4000, 3000, 1000);
        salaryStream.sorted(Comparator.reverseOrder()).limit(2).forEach(System.out::println);

        //Sort By age and name
        List<Employee> employeesSortedList = empList.stream().sorted((o1, o2) -> {
                    if (o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if (o1.getAge() > o2.getAge())
                        return 1;
                    else return -1;
                })
                .collect(Collectors.toList());
        System.out.println("Sort by age and name" + employeesSortedList);

        String str = "Japan";
        str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " " + v));
        // Sort by Salary
        List<Employee> employeesSortedList1 = empList.stream()
                .sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).collect(Collectors.toList());
        System.out.println(employeesSortedList1);

        //Ascending order salary
        List<Employee> employeesSortedList2 = empList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed()).collect(Collectors.toList()); //ascending order
        System.out.println(employeesSortedList2);

        // Sum of salaryStream mapToInt means parse into integer
        int totalSalary = empList.stream().mapToInt(Employee::getSalary).sum();
        System.out.println("TotalSalary " + totalSalary);
        //Update Salary using stream
        List<Employee> newList = empList.stream()
                .map(e -> {
                    e.setSalary(e.getSalary() + 100);
                    return e;
                })
                .collect(Collectors.toList());

        System.out.println(newList);

        // Map and FlatMap : Worked in City's
        List<List<String>> cityWorked = empList.parallelStream()
                .map(Employee::getWorked)
                .collect(Collectors.toList());
        System.out.println("Map " + cityWorked);

        Set<String> ls = empList.stream()
                .flatMap(e -> e.getWorked().parallelStream())
                .collect(Collectors.toSet());
        System.out.println("FlatMap " + ls);

    }

    @Test
    public void GroupByTest() {
        System.out.println("Department vis highest salary");
        // Department vis the highest salary
        Map<Department, List<Employee>> mapOfDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDep));

        mapOfDepartment.entrySet().forEach(System.out::println);

        System.out.println("Department vis count");
        // Department vis count
        Map<Department, Long> mapOfDepartment1 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDep, Collectors.counting()));
        mapOfDepartment1.entrySet().forEach(System.out::println);
    }

    @Test
    public void GroupByworldCount() {
        String s = "He hit the ball so hard that the ball flew away and we lost the BALL";
        String[] strArray = s.split("\\s");
        // Both are okay
        //String[] strArray1 = s.split(" ");
        List<String> lsValue = Arrays.asList(strArray);
        Set<String> st = lsValue.stream()
                .filter(i -> Collections.frequency(lsValue, i) > 1)
                .skip(1).limit(1)
                .collect(Collectors.toSet());
        st.forEach(System.out::println);

        // Repitable words with count more than 1
        Map<String, Long> frequencyMap = lsValue.stream().map(String::toLowerCase)
                .filter(i -> Collections.frequency(lsValue, i) > 1)
                .filter(val -> !val.equals("the"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequencyMap);
    }

    @Test
    public void charCount() {
        String str = "Japan";
        Map<Character, Long> charCount = str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        charCount.entrySet().stream().forEach(System.out::println);

    }


    //Find first missing integer value in the array
    @Test
    public void intToInteger() {
        int[] ints = {7, 8, 2, 3, 5};
        Integer[] intgh = {2, 3, 4, 5,};
        //Convert primitive type to wrapper
        Set<Integer> intSet = IntStream.of(ints).boxed().sorted().collect(Collectors.toSet());
        //List<Integer> intL= Arrays.stream(intgh).sorted().collect(Collectors.toList());
        int initValue = intSet.iterator().next();
        int minMissingValue = 0;
        System.out.println(initValue);
        for (int value : intSet) {
            if (!intSet.contains(initValue)) {
                minMissingValue = initValue;
                break;
            }
            initValue++;
        }
        System.out.println("Find first missing integer value in the array : " + minMissingValue);
    }

}
