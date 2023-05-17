package com.ps.assignment;

public class SqureRoot {
    // Function to find the floor of the square root of `x`
    public static int sqrt(int x)
    {
        // find the first positive number `i` such that `i×i` is greater than `x`
        int i = 1;
        while (i*i <= x) {
            i++;
        }

        return i - 1;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i <= 16; i++) {
            System.out.printf("sqrt(%d) = %d\n", i, sqrt(i));
        }
    }
}
