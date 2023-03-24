package com.stream;

import com.core.dto.Department;
import com.core.dto.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {


    public List<Employee> empList;
    public Employee emp;
    public Employee emp1;
    public Employee emp2;
    @Before
    public void setup(){

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
    public void maxSalary(){
        Optional<EmployeeDto> person = EmployeeDto.persons().stream()
                .max(Comparator.comparingDouble(EmployeeDto::getIncome));

        if (person.isPresent()) {
            System.out.println("Highest without reduce earner: " + person.get());
        } else {
            System.out.println("Could not  get   the   highest earner.");
        }
    }

    @Test
    public void getTest(){
        Optional<EmployeeDto> person= EmployeeDto.persons().stream()
                .reduce((p1,p2)->p1.getIncome()>p2.getIncome() ? p1:p2 );
        if(person.isPresent()){
            System.out.println("Highest earner: " + person.get());
        }else {
            System.out.println("Could not get hightest : " + person.get());
        }
    }

    //how to create collector from supplier, accumulator, combiner and finisher.
    @Test
    public void supplierAccuCombiFinisher(){
        Collector<EmployeeDto, StringJoiner, String> employeeNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, e) -> j.add(e.getName().toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher
        List<EmployeeDto> empList = new ArrayList<>();
        String names = empList
                .stream()
                .collect(employeeNameCollector);
    }

    @Test
    public void RemoveDigitWhitespace(){
        String str = "5 123,123,qwe,1,123, 25";
        str.chars()
                .filter(n ->  !Character.isDigit((char)n) && !Character.isWhitespace((char)n))// && Character.isAlphabetic((char)n))
                .forEach(n ->  System.out.print((char)n));
    }

}
