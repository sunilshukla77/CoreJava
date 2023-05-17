package com.ps.ds.hashing;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class RotatedArrayKey {

    @Test
    public void findKey() {
        //int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int rotaion = binarySe(arr, arr.length - 1, key);
        System.out.println(rotaion);
    }

    private int binarySe(int[] arr, int end, int key) {
        int start = 0; 
        while(start<= end){
            int mid = (start+end)/2;
            if(arr[mid]== key){
                return mid;
            } else if (key >= arr[start] && key <= arr[mid]) {
                if(key < arr[start]){
                   start = mid+1;
                }else{
                    end= mid-1;
                }
            } else {
                if(key < arr[end]){
                    end = mid-1;
                }else{
                    start= mid+1;
                }
            }
        }
        return -1;
    }

    private int binaryPivote(int[] arr){
        int start = 0, end = arr.length-1;

        return -1;
    }



    //Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
    //Output : Found at index 8
    //Search an element in a sorted and rotated Array
    // O(n)  O(1)
    //

    //1
    //2
    //3

    /*
    Input: arr[] = [ 4 , 5 , 2 , 25 ]
      Output:  4      –>   5
               5      –>   25
               2      –>   25
              25     –>   -1

     */

    @Test
    public void nextGreater() {
        int arr[] = {4, 5, 2, 25};
        int[] result = nextGreater(arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    /*
     4      –>   5
                   5      –>   25
                   2      –>   25
                  25     –>   -1
     */
    private int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack();
        for (int i = arr.length-1; i >= 0; i--) {

            // next value is greater result   //- val +
            while ((stack.size() > 0) && (arr[i] >= stack.peek())) {
                stack.pop();
            }
            int val = stack.isEmpty() ? -1 : stack.peek();
            result[i] = val;
            stack.push(arr[i]);
            //System.out.println(stack.peek());
        }
        return result;
    }

}
