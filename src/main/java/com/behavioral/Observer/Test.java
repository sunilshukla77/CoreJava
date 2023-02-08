package com.behavioral.Observer;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String str = "apcdeefghiijkleee";   //e=3 i=1
        char[] ch= str.toCharArray();
        int counter = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i<str.length()-1; i++){
             //for(int j= 1; j< str.length(); j++){
                 if(ch[i]==ch[i+1]){
                     counter++;
                     map.put(ch[i], counter);
                 }
             //}
            map.put(ch[i], counter);
        }

        System.out.println(map);
    }
}
