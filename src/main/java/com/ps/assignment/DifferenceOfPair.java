package com.ps.assignment;

import java.util.Arrays;

public class DifferenceOfPair {

    // Function to find a pair with the given difference in the array.
    // This method handles duplicates in the array
    public static void findPair(int[] A, int diff)
    {
        // sort array in ascending order
        Arrays.sort(A);

        // do for each array element
        for (int i = 0; i < A.length; i++)
        {
            // to avoid printing duplicates (skip adjacent duplicates)
            while (i < A.length - 1 && A[i] == A[i+1]) {
                i++;
            }

            // perform a binary search on element `A[i]-diff`
            if (Arrays.binarySearch(A, A[i] - diff) >= 0) {
                System.out.println("(" + A[i] + ", " + (A[i] - diff) + ")");
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = 3;

        findPair(A, diff);
    }
}
