package com.ps.ds.hashing;

import org.junit.Test;

import java.util.Map;

public class SecondHeightest {

    @Test
    public void test(){
        //int[] arr = { 4 , 5 , 30, 2 , 25, 50, 60};
        int[] arr = { 2,2,5,6,10,2,3,4,5};
        int val = getValu(arr);
        System.out.println(val);
    }

    private int getValu(int[] arr) {
        int max = 0;
        int second =0;
        for (int i = 0, j=1; i < arr.length-1; i++, j++) {
            //max = Math.max(arr[i], arr[j]);
            //if(arr[i] <= arr[j] &&)

        }
        System.out.println("Max" + max);
        for (int i = 0, j = 1; i < arr.length-1; i++, j++) {
            /*if(arr[j]<max && arr[i]<arr[j]){
                max = arr[j];
                //second = arr[j];
            }*/
        }
        return second;

    }
}
