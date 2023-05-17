package com.stream;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class EmployeeDto {
    public static enum Gender {
        MALE, FEMALE
    }

    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    public EmployeeDto(long id, String name, Gender gender, LocalDate dob,
                       double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }
    public double getIncome() {
        return income;
    }
    public static List<EmployeeDto> persons() {
        EmployeeDto p1 = new EmployeeDto(1, "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        EmployeeDto p2 = new EmployeeDto(2, "Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        EmployeeDto p3 = new EmployeeDto(3, "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        EmployeeDto p4 = new EmployeeDto(4, "Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        EmployeeDto p5 = new EmployeeDto(5, "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        EmployeeDto p6 = new EmployeeDto(6, "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<EmployeeDto> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String str = String.format("(%s, %s,  %s,  %s,  %.2f)\n", id, name, gender,
                dob, income);
        return str;
    }
}
