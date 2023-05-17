package com.ps.assignment;

import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FloorCeil {

    @Test
    public void maxSumOfMaxSequence() {
        int a[] = {1, 3, 8, -2, 6, -8, 5};
        int b[] = {2, -8, 3, -2, 4, -10};
        System.out.println("Max value " + maxSeq(a));
    }

    private int maxSeq(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i <= n - 1; i++) {
            currSum += arr[i];// currSum = currSum + arr[i]
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    /**
     * { 2,-8,3,-2,4,-10) output: 5 (i.e 3,-2,4).
     */
    @Test
    public void maxSequence() {
        int a[] = {1, 3, 8, -2, 6, -8, 5};
        int b[] = {2, -8, 3, -2, 4, -10};
        System.out.println("Max value " + maximumSubarraySum(a));
    }

    public int maximumSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= n - 1; i++) {
            int currSum = 0;
            for (int j = i; j <= n - 1; j++) {
                currSum += arr[j];
                if (currSum > maxSum) {
                    System.out.println(arr[j]);
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    private int[] findCeilingFloor(int[] arrayInt, int value) {
        int[] ceilFloor = new int[2];
        for (int i = 0; i < arrayInt.length - 1; i++) {
            if (arrayInt[i] < value && arrayInt[i + 1] > value)
                return ceilFloor = new int[]{arrayInt[i], arrayInt[i + 1]};
            if (arrayInt[i] == value)
                return ceilFloor = new int[]{arrayInt[i], arrayInt[i]};
            if (arrayInt[i + 1] == value)
                return ceilFloor = new int[]{arrayInt[i + 1], arrayInt[i + 1]};
        }
        return ceilFloor;
    }

    @Test
    public void ceilingFloor() { //O(n)
        int[] arrayInt = {0, 10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(findCeilingFloor(arrayInt, 40)));
        //System.out.println(Arrays.toString(binarySearchFloor(arrayInt, 40)));
    }

    private int[] binarySearchFloor(int[] arrayInt, int searchVal) {
        return new int[2];
    }



}
