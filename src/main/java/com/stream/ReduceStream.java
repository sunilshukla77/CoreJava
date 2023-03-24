package com.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceStream {

    @Before
    public void setup() {

    }

    @Test
    public void oddNumberSquire() {
        // 1+ 9+ 25= 35
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
    @Test
    public void findDuplicate() {

    }
    @Test
    public void sumOperation() {
        // Stream pipeline->To perform a sequence of operations over the elements of the
        // data source and aggregate their results,
        // we need three parts: the source, intermediate operation(s) and a terminal
        // operation.
        // Stream Reduction-> reduce() and collect

        OptionalInt reduced = IntStream.range(1, 5).reduce((a, b) -> a + b); // 1+2+3+4= 10
        System.out.println(reduced.getAsInt());

        // 10+1= 11, 10+2=12, 10+3=13 combine 11+12+13= 36
        int sumval = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("Combined value called");
                    return a + b;
                });

        System.out.println(sumval);
    }


    @Test
    public void oddNumberSquire1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = 0;
        for (int n : numbers) {
            if (n % 2 == 1) {
                int square = n * n;
                sum = sum + square;
            }
        }
        System.out.println(sum);
    }



}
