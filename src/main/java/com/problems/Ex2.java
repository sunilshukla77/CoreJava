package com.problems;

import java.util.Arrays;

/*
 *2nd smallest element of a sorted rotated array. E.g. 5,6,1,2,3,4
 */
public class Ex2 {
    public static void main(String[] args) {

        int[] arrayInt = {5,6,1,2,3,4};
        Arrays.sort(arrayInt);
        System.out.println(arrayInt[1]);
    }
}
