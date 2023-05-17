package com.ps.assignment;

import org.junit.Test;

public class BinarySearch {

    @Test
    public void searchValue() {
        int[] arr = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int key = 110;
        //int index = binarySearch(arr, 0, arr.length - 1, key);
        int index = binarySearchIt(arr, key);
        if (index < 0) {
            System.out.println("Key not found  : " + index);
        } else {
            System.out.println("Key found at index no : " + index);
        }
    }

    int binarySearchIt(int[] arr, int key){
        int left = 0, right = arr.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            System.out.println("mid "+mid + " val "+ arr[mid]+ " left "+ left+ " right " +right);
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]< key){ // key bada hai to move right side
                left = mid+1;
            }else right = mid-1;
        }
        return -1;
    }

    //May get stackoverflow exception if using recursive
    int binarySearch(int[] intArray, int left, int right, int key) {
        int index = Integer.MIN_VALUE;
        int mid = (left + right) / 2;
        // right is not greater than low else will get stackoverflow error
        if (right >= left) {
            index = -1;
        }
        if (intArray[mid] == key) {
            index = mid;
        } else if (intArray[mid] > key) { //if key is less than mid value
            return binarySearch(intArray, left, mid - 1, key);
        } else if (intArray[mid] < key) {
            return binarySearch(intArray, mid + 1, right, key);
        }

        return index;
    }


    //Use iterative flow while loop
   /* int binarySearchIterative(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // key not found
    }*/


}
