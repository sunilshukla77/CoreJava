package com.ps.assignment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Duplicate {
    @Test
    public void removeDuplicate(){ //o(n)
        int[] a = {1,1,1,2,2,2,3,3,3,3,4,4,4,5,5,5,5};
        List<Integer> nonDuplicate = new ArrayList<>();
        int start = 0;
        int next = 1;
        //int mid = a.length/2;
        //recursive(a, )
        for (int i = 0; i < a.length-1; i++) {
            addInList(a, nonDuplicate, start, next);
            start++;
            next++;
        }
        System.out.println(nonDuplicate.toString());

    }

    private static void addInList(int[] a, List<Integer> nonDuplicate, int start, int next) {
        if(a[start]!= a[next]){
            if(!nonDuplicate.contains(a[start]) && !nonDuplicate.contains(a[next])){
                nonDuplicate.add(a[start]);
                nonDuplicate.add(a[next]);
            }else if(!nonDuplicate.contains(a[start])){
                nonDuplicate.add(a[start]);
            }else if(!nonDuplicate.contains(a[next])) nonDuplicate.add(a[next]);
        }
    }
}
