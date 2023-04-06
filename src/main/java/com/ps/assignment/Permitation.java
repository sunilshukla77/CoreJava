package com.ps.assignment;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Permitation {
    @Test
    public void permutationCombination(){
        String value = "abc";
        int fact =1;
        Map<String, Integer> insertI= new HashMap<>();
        for (int i=1;i<=value.length();i++){
            fact*=i; //fact = fact*i;

            System.out.println(fact);
        }
        for (int i = 0; i < fact; i++) {

        }
    }
}
