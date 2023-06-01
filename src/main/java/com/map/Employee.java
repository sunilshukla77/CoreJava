package com.map;

public class Employee implements Comparable<Employee> {

    private String name;
    private int id;
    private int age;

    private String dept;

    private int salary;


    public Employee(int id, String name, int age, String dept, int salary) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        Employee employee = (Employee) o;
        int id = employee.id;
        return this.id - id ;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

}
