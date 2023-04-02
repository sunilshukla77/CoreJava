package com.problems;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int i = 10;
        byte j = 20;
        float k = 30; // Primitive data type

        Float f = k; //wrapper class

        Integer ii= i; //AutoBoxing and  unboxing

        //Collection and Streaming Object (primitive datatype to Object)
        List<Integer> listNum = new ArrayList<>();

        String salary = "10000";
        int sal= Integer.valueOf(salary); // Parsing

        int t = 10/0; //

        System.out.println(t);


    }
}


