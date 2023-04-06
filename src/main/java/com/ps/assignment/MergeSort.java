package com.ps.assignment;


import org.junit.Test;

import java.util.Arrays;
public class MergeSort {

    private int[] merge(int[] left, int[] right) {
        int[] combineArray = new int[left.length + right.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {

            if (left[i] < right[j]) {
                combineArray[index] = left[i];
                index++;
                i++;
            } else {
                combineArray[index] = right[j];
                index++;
                j++;
            }

        }
        while (i < left.length) {
            combineArray[index] = left[i];
            index++;
            i++;
        }
        while (j < right.length) {
            combineArray[index] = right[j];
            index++;
            j++;
        }
        return combineArray;
    }
    private int[] mergeSort(int[] arr) {
        if(arr.length==1) return arr;

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));// Break using recursive mergeSort
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length)); // Break again left right
        return  merge(left, right);
    }
    @Test
    public void sort() {
        int[] arr = {1, 4, 3, 2, 9, 7, 6, 5};
        int[] result = mergeSort(arr);
        System.out.println( "\nOriginal Array: " + Arrays.toString( arr ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( result ) );

    }

    @Test
    public void arraysMerge(){ // O(nlogn) Best
        int[] arr = {1, 4, 3, 2};
        int[] arr1 = {9, 7, 6, 5};

        int[] merge = merge(arr, arr1); //Big array
        int[] result= mergeSort(merge);

        System.out.println( "\nOriginal 1 Array: " + Arrays.toString( arr ) );

        System.out.println( "\nOriginal 2 Array: " + Arrays.toString( arr1 ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( result ) );

    }

    @Test
    public void seqSort(){
        //int[] join = Arrays.

    }
}
