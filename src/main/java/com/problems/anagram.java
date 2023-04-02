package com.problems;

import org.junit.Test;

import java.util.Arrays;

public class anagram {

    @Test
    public void anagram2() {

        String str1 = "race";
        String str2 = "care";
        if (str1.length() == str2.length()) {
            char[] aryChar1 = str1.toLowerCase().toCharArray();
            char[] arychar2 = str2.toLowerCase().toCharArray();

            if (Arrays.equals(aryChar1, arychar2)) {
                System.out.println("Anagram");
            } else {
                System.out.println("Not anagram");
            }
        } else
            System.out.println("Not anagram");
    }

}
