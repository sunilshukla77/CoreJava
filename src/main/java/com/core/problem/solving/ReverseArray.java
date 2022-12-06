package com.core.problem.solving;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array=  {5,6,7,3,9,1};
        reverse(array, 3);
    // Expected o/p: 1,9,3,5,6,7
    }

    private static void reverse(int[] array, int k) {
        int[] rev = new int[6];
        int j= 0;
        int t= 0;
        for (int i=array.length-1;i>=0;i--) {
            if(i>=k) {
                rev[j] = array[i];
                System.out.print("\t"+ rev[j]);
                j++;
            } else{
                rev[j] = array[t];
                System.out.print("\t"+ rev[j]);
                j++;
                t++;
            }
        }

    }
}
