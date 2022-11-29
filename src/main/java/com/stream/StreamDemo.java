package com.stream;

import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        String s1= "This is first line.";
        String s2= "This is second line.";
        String s3= "This is third line.";
        Stream.of(s1, s2, s3).forEach(System.out::println);
        System.out.println();
    }
}
