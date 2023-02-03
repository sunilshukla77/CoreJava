package com.problems;

/**
 * 2nd smallest element of an unsorted array.
 */
public class SmallestNumber {

    public static void main(String[] args) {
        int a[] = {1, 2, 5, 6, 3, 2};
        int b[] = {44, 66, 99, 77, 33, 22, 55};
        System.out.println("Second smallest: " + getSecondSmallest(a));
        System.out.println("Second smallest: " + getSecondSmallest(b));
    }

    private static int getSecondSmallest(int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[2];
    }

}
