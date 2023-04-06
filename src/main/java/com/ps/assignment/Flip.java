package com.ps.assignment;

import org.junit.Test;

public class Flip {
    /**
     * 10 = 01010
     * 20 = 10100
     * op = 11110 = 30 = 4 time flip
     */
    @Test
    public void usingXorFlipCount() {  // Best O(n)
        int a = 10, b = 20;  //0101 0111 = 0010 = 2
        int xor = a ^ b;
        int count = 0;
        while (xor > 0) { //o(n)
            if(xor%2 ==1) count++;
            xor = xor / 2;
        }
        System.out.println(count);
    }

    /**
     * 10 = 01010
     * 20 = 10100
     * op = 11110 4 time flip
     */
    @Test
    public void flipCount() {  //Worst O(n2)
        int a = 10;
        int b = 20;
        int count = 0;
        String bin = Integer.toBinaryString(a);
        int[] aBit = convertBinary(10);
        int[] bBit = convertBinary(b);
        for (int i = 0; i < aBit.length; i++) {
            if (aBit[i] != bBit[i]) {
                count++;
            }
        }
        System.out.println("Count of flip: "+count);

    }

    int[] convertBinary(int a) {
        int[] result = new int[5];
        int i = 0;
        while (a > 0) {
            result[i] = a % 2;  //10= 0101 =1010  //20
            a = a / 2;
            i++;
        }
        return result;
    }
}
