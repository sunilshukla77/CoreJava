package com.ps.ds.hashing;

import org.junit.Test;

import java.util.*;

public class HashMapDemp {

    @Test
    public void addFrequency() {
        int arr[] = new int[]{15, 16, 27, 27, 28, 15};
        int n = arr.length;
        countFreq(arr, n);
    }             // 15 - 2times
                        // hashmap me value add karo if exist than add count else add new value
    void countFreq(int arr[], int n) {
        Map<Integer, Integer> hmp = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            if (hmp.containsKey(arr[i]) == true)
                hmp.put(arr[i], hmp.get(arr[i]) + 1);
            else
                hmp.put(arr[i], 1);
        }
        for (Map.Entry<Integer, Integer> itr : hmp.entrySet())
            System.out.println(itr.getKey() + " " + itr.getValue());
    }

    @Test
    public void SlidingWindow () {  // Sliding window
        int[] arr = {1, 2, 3, 7, 5};
        Set<Integer> set = new HashSet<>();
        int target = 12;
        int presum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            presum += arr[i];
            if (set.contains(presum - target)) {
                count++;                                             // Count if target exists
                List<Integer> listIndex = new ArrayList<>();
                int sum = 0;
                for (int j = i; sum <= target; j--) {       // Return index
                    sum += arr[j];
                    if (sum <= target) {
                        listIndex.add(j);
                    }
                }
                System.out.println(listIndex.toString());
            }
            set.add(presum);
        }
        System.out.println(count);
    }
    // Sum = 12
    // arr[] = {1,2,3,7,5}
    // pre_sum = {1,3,6,13,18}
    // arr[i] - 12;

    @Test
    public void arrayRotation() {
        int[] arr = {7, 9, 11, 12, 5};
        int rotation = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr[i + 1]) {
                ++rotation;
            } else if (i == arr.length) {
                if (arr[i] == arr[0])
                    ++rotation;
            } else {
                break;
            }
            if (rotation == arr.length) {
                rotation = 0;
            }
        }
        System.out.println(rotation);

    }

    //Input: arr[] = {7, 9, 11, 12, 5}
    //Output: 4
    //Find the Rotation Count in Rotated Sorted array


}
