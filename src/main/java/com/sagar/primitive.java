package com.sagar;

public class primitive {

    public static void main(String[] args) {
        int i = 10;
        Integer inte= i; // Convert int to integer Boxing / unboxing
        i= inte;
        String obtainMarks= "In Math obtain : ";
        String mathsMarks= String.valueOf(i);
        int i1 = Integer.parseInt(mathsMarks);
        System.out.println(obtainMarks + obtainMarks);
    }
}
/*
 Java V1, Object oriented programing
 */