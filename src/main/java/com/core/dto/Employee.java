package com.core.dto;

import java.util.List;

public class Employee{
	
	private String name;
	private int age;
	private int salary;
	private List<String> worked;
	private Department dep;
	
	public Employee() {}
	public Employee(String name, int age, List<String> worked, int salary, Department d) {
		super();
		this.name = name;
		this.age = age;
		this.worked = worked;
		this.salary = salary;
		this.dep = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDep() {
		return dep;
	}

	public List<String> getWorked() {
		return worked;
	}

	public void setWorked(List<String> worked) {
		this.worked = worked;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
