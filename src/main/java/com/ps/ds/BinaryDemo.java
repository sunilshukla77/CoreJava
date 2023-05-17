package com.ps.ds;

import org.junit.Test;

public class BinaryDemo {

    // circular array find rotation
    // Pivotal property -> previous > min < next
    // while first <= last
    @Test
    public void findCircular(){
        int arr[] = { 18, 20, 3, 6, 12, 15};

        // using binary
        //int rotation = rotation(arr, 0, arr.length-1);
        int rotation = rotationArray(arr);
        System.out.println("No of Rotation  " + rotation);
    }

    private int rotationArray(int[] arr) {

        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            int next = ((i + 1) == arr.length) ? 0 : (i + 1);
            if (arr[i] <= arr[next]) {
                k++;
            } else {
                break;
            }
        }
        if(k==arr.length) k=0;
        return k;
    }

    private int rotation(int[] arr, int start, int last) {

        while(start<=last) {
            //if it is already sorted
            if(arr[start]<=arr[last]){
                return start;
            }

            int mid = (last + start) / 2;
            int next = (mid+1)%arr.length;
            int prev = (mid-1 + arr[last])%arr.length;
            if (arr[prev] > arr[mid] && arr[mid] < arr[next]) {
                return mid;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else last = mid - 1;
        }
        return -1;
    }


}
