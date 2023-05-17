package com.ps.ds;

public class Slidingwindow {
    public static void main(String[] args) {
        int[] arr = {1,4,2,10,2,3,1,0,20};
        int k= 4;
        int length= arr.length;
        System.out.println(maxSum(arr, length,k));
    }

    private static int maxSum(int[] arr, int length, int k) {
        if(length<k){
            System.out.println("Invalid");
            return -1;
        }

        int maxSum=0;
        for (int i = 0; i < k; i++) {
            maxSum+=arr[i];  //maxSum= maxSum+arr[i]
        }
        System.out.println("maxSum "+ maxSum);
        int windowSum= maxSum;
        for (int i = k; i < length; i++) {
            System.out.println(i +" , "+ (i-k));
            windowSum += arr[i]-arr[i-k];  //windowSum = windowsum + (arr[i]- arr[i-k]
            System.out.println("Window sum : " + windowSum);
            maxSum= Math.max(maxSum,windowSum);
            System.out.println("Max value : " + maxSum);
        }
        return maxSum;
    }
}
