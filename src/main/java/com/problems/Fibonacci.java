package com.problems;

import org.junit.Test;

import java.util.stream.Stream;

public class Fibonacci {

    private static final String ASTERISK = "*";
    private static final String NEXT_LINE = "\n";
    String UNDER_SCORE = "__";
    String EMPTY = "";

    @Test
    public void fibonacci(){
        Stream.iterate(new int[]{0,1}, t->new int[]{t[1], t[1]+t[0]}).limit(10).map(t->t[0]).forEach(System.out::println);
    }

    @Test
    public void startPattern(){
        int noOfRows= 10;
        String leftSpace = Stream.generate(()-> UNDER_SCORE).limit(noOfRows/2).reduce(EMPTY, (i,j)-> i+j);
        String rightSpaces ="-";
        for (int i =0; i< noOfRows-1; i++) {
            System.out.print(leftSpace.substring(0, leftSpace.length() - i - 1)+ASTERISK);
            System.out.print(rightSpaces +ASTERISK+NEXT_LINE);
            rightSpaces+=UNDER_SCORE;

        }
    }
}
