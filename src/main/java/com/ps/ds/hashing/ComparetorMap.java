package com.ps.ds.hashing;

import com.core.dto.Employee;
import com.stream.EmployeeDto;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.nio.charset.CodingErrorAction;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparetorMap {

    List<Employee> list;
    @Before
    public void init() {
        Employee e1 = new Employee("Sunil", 1000);
        Employee e2 = new Employee("RAJ", 5000);
        Employee e3 = new Employee("ALOK", 1500);
        list = new ArrayList<>();

    }

    @Test
    public void compareMap() {
        //Map<String, Integer> map = list.stream().collect(Collectors.groupingBy(Employee::getName, Employee::getSalary));
        //List<Map.Entry<String,Employee>>
    }

    @Test
    public void Test(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 5);
        map.put(5, 2);
        map.put(7, 4);
        map.put(6, 3);

        LinkedHashMap<Integer, Integer> lmap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        //Map.Entry lmap.entrySet();
        //lmap.entrySet().stream().forEach(System.out::println);

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1,o2)-> o1.getValue().compareTo(o2.getValue()));

        Map<Integer, Integer> linkedList= new LinkedHashMap<>();

        for (Map.Entry<Integer, Integer> aa : list) {
            linkedList.put(aa.getKey(), aa.getValue());
        }

        linkedList.entrySet().stream().forEach(System.out::println);
    }

}
