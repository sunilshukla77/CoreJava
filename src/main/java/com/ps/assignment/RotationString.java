package com.ps.assignment;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RotationString {

    //Assume you have a method isSubstring which checks if one word is a substring of another. Given
    // two strings , s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
    // isSubstring (i.e "waterbottle" is a rotation of "erbottlewat"
    @Test
    public void RotationString() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
       
        if(isRotationString(s1, s2)){
            System.out.println("Yes Rotational String");
        }else {
            System.out.println("Not a Rotational String");
        }

    }

    // join same source string
    // (source+source).substring(i,source.length()+i);
    private boolean isRotationString(String source, String rotation) {

        if(source.length()==rotation.length()){
            for (int i = 1; i < source.length(); i++) {
                String substring= (source+source).substring(i,source.length()+i);
                if((rotation).equals(substring)){
                    return true;
                }
            }
        }
        return false;
    }

    //GOOOGLE ---OOO GOOGLEEE --- EEE.
    @Test
    public void longestSequence(){
        String str = "GOOOGLLLLLE";
        char[] chars = str.toCharArray();
        int j=1;
        int count =0;
        char ch;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length-1 ; i++) {
            if(chars[i]==chars[j]){
                if(count==0) { // First time increment
                    sb.append(chars[i]).append(chars[i]);
                    count++;
                }else { //Second time increment
                    sb.append(chars[i]);
                    count++;
                }
            }else{
                count=0; //Reset Count
            }
            j++;
        }
        System.out.println(sb.toString());
    }
}
