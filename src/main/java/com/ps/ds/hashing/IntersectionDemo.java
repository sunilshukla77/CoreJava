package com.ps.ds.hashing;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//Union of two unsorted arrays
public class IntersectionDemo {

    int[] arr;

    @Test
    public void intersection() {
        int arr1[] = new int[]{2, 8, 3, 5, 6};
        int arr2[] = new int[]{4, 8, 3, 6, 1};
        int m = arr1.length;
        int n = arr2.length;

        System.out.println(unionSize(arr1, m, arr2, n));
    }

    int unionSize(int arr1[], int m, int arr2[], int n) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < m; i++)
            hs.add(arr1[i]);
        for (int i = 0; i < n; i++)
            hs.add(arr2[i]);
        return hs.size();  //Set not allow duplicate so automatically we will get intersect
    }

    // arr= {8,3,4,5}  sum = 6 pair of given set
    @Test
    public void pairSum(){
        int[] arr= {8,3,4,2,5};
        int target = 6;
        Set set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            int val= target - arr[i];
            if(set.contains(val)){
                System.out.println("Pair contains");
            }else {
                set.add(arr[i]);
            }
        }
    }

    // Sub-array with 0 sum
    // arr[] = {1,4,13,-3, -10, 5}      o/p = Yes  O hai ya nahi
    // arr[] = {-1,4,-3,5,1}   O/P = Yes 0 = (-1,4,-3)
    // arr[] = {5,6,0,8} O/P = Yes
    @Test
    public void subArrayZero(){
        arr = new int[]{1, 4, 13, -3, -10, 5}; // Sum =0
        //arr = new int[]{5,8,6,13,3,-1}; //sum = 22
        // arr = new int[]{15,2,8,10,-5,-8,6}; //sum = 3
        // arr = new int[]{3,2,5,6}; //sum = 10
        extracted(arr, 22);
    }

    private static void extracted(int arr[], int target) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        set.add(target);  // add 0; which we are searching
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if(set.contains(preSum)){
                System.out.println("Zero Exist");
            }
            set.add(preSum);
        }
    }

    // arr = {5,8,6,13,3,-1}   sum = 22
    // arr = {15,2,8,10,-5,-8,6}   sum = 3
    // arr = {3,2,5,6} sum = 10
    public void subArrayGiven(){
// arr = {5,8,6,13,3,-1}   sum = 22
        // arr = {15,2,8,10,-5,-8,6}   sum = 3
        // arr = {3,2,5,6} sum = 10
    }

}
