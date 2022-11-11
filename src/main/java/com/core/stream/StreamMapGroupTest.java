package com.core.stream;

import com.core.dto.Department;
import com.core.dto.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamMapGroupTest {

	public List<Employee> empList;
	public Employee emp;
	public Employee emp1;
	public Employee emp2;

	@Before
	public void setup() {
		empList = new ArrayList<>();
		String[] city = { "Nagpur", "Pune", "Bangalore", "Indore" };
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
	public void streamTest() {
		// Highest 2 salary
		Stream<Integer> Salary = Stream.of(2000, 4000, 3000, 1000);
		Salary.sorted().limit(2).forEach(System.out::println);

		// Sum of Salary
		int totalSalary = empList.stream().mapToInt(e -> e.getSalary()).sum();
		System.out.println("TotalSalary " + totalSalary);

		// Map and FlatMap : Worked in Citys
		List<List<String>> cityWorked = empList.parallelStream()
				.map(e -> e.getWorked())
				.collect(Collectors.toList());
		System.out.println("Map "+ cityWorked);

		Set<String> ls = empList.stream()
				.flatMap(e -> e.getWorked().parallelStream())
				.collect(Collectors.toSet());
		System.out.println("FlatMap "+ls);

	}

	@Test
	public void groupByTest() {
		System.out.println("Department vis highest salary");
		// Department vis highest salary
		Map<Department, List<Employee>> mapOfDepartment = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDep));
		mapOfDepartment.entrySet().forEach(System.out::println);

		System.out.println("Department vis count");
		// Department vis count
		Map<Department, Long> mapOfDepartment1 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDep, Collectors.counting()));
		mapOfDepartment1.entrySet().forEach(System.out::println);
	}

}
