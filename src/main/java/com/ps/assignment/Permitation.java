package com.ps.assignment;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Permitation {
    @Test
    public void permutationCombination() {
        String a = "abc";
        printPermutation(a.toCharArray(), 0);

    }

    //cid = current index
    private void printPermutation(char[] chars, int cid) {
        //Print chars
        if(cid == chars.length-1) {
            System.out.println("\n");
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i] + " ");
            }
        }
        System.out.println( " cid " +(cid+1));
        for (int i = cid; i < chars.length; i++) {
            swap(chars, i, cid);
            printPermutation(chars, cid+1);
            swap(chars, i, cid);
        }
    }

    private void swap(char[] chars, int i, int j) {
        System.out.println(" i " + i +" j " + j);
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    @Test
    public void fabonesisStream() {
        String value = "abc";
        int fact = 1;
        for (int i = 1; i <= value.length(); i++) {
            fact *= i; //fact = fact*i; 1*2*3 =6
            System.out.println(fact);
        }
    }
}
