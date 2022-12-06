package com.core.problem.solving;

import java.util.Arrays;
import java.util.List;

public class ArrayNumber {

    public static void main(String[] args) {
        Integer[] arrayInt= {-1,-2,-3,-5,0,1,2,4,5};
        List list = Arrays.asList(arrayInt);
        for(int i= 0; i< list.size(); i++){
            int val= (int) list.get(i);
            if(0>val){  // - - = + //- + = -
                if(list.contains(-val)){
                    System.out.println(val+" "+(-val));
                }
            }
        }

    }
}
/*
Index display whose positive and negative value in the array
 */