package com.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    @Test
    public void predicate(){
        int[] intArray = {2,3,4,5,7,6,9,8};

        Arrays.stream(intArray).filter(v-> isEven(v)).forEach(System.out::println);

        Arrays.stream(intArray).filter(v-> v%2==0).forEach(System.out::println);

    }

    boolean isEven(int val){
        return val%2 == 0 ? true : false;
    }

}