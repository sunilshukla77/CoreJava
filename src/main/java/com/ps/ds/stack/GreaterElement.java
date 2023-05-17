package com.ps.ds.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class GreaterElement {

    Deque<Integer> stack;
    @Before
    public void init(){
        stack = new ArrayDeque<>();
    }
    public int[] nextGreater(int[] arr, int length) {
        int[] array = {2,5,9,4,6,12,8,9,10,7};

        stack.add(array.length);
        System.out.println(stack.peek());
        for (int i = array.length-1; i > 0; i--) {
            if(array[i]>array[i+1]){
                stack.push(array[i]);
            }
        }


        return array;
    }
    //I/P: 2,5,9,4,6,12,8,9,10,7
    //O/P: 5,9,12,6,-1,9,10,-1,-1

    //I/P = 3,4,6,8,5
    // 4,6,8,-1-1


    @Test
    public void prevousGreaterThan(){
        //O/P: -1 -1 30 10 30
        int[] arr=new int[]{20,30,10,5,15};
        int [] result= result(arr, arr.length);
        System.out.println("Result");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(result[i]+ " ");
        }
    }


    @Test
    public void NextGreaterThan(){
        //O/P: -1 -1 30 10 30
        int[] arr=new int[]{20,30,10,5,15};
        //30,-1,15,15,-1
        //int [] result= nextGt(arr);
        nextGt(arr);

    }


    void nextGt(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack();
        //st.push(-1);
        for (int a = arr.length-1; a >= 0; a--) {
            while (st.size()>0 && arr[a]>st.peek()){
                st.pop();
            }
            int val = st.isEmpty() ? -1 : st.peek();
            //result[a] = val;
            System.out.println(val);
            st.push(arr[a]);
        }

        //return result;
    }


    int[] result(int[] arr, int l){
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            while(stack.size()>0 &&  stack.peek()<= arr[i]){
                System.out.print(" "+ i + " pop " + stack.peek());
                stack.pop();  // Removed from array jab tak badi value na mile

            }
            int val = stack.isEmpty() ? -1 : stack.peek();
            result[i] = val;  // add greater value in array only
            stack.push(arr[i]); //added in array
            System.out.print(" "+i+  " push "+ stack.peek());  // Added in stack

        }
        return result;
    }

}
