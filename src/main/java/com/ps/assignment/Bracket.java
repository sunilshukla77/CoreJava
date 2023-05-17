package com.ps.assignment;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Bracket {

    @Test
    public void bracket(){
        String brackets = "[{)}]";
        if(isValid(brackets)){
            System.out.println("Valid" + brackets);
        }else {
            System.out.println("InValid");
        }

    }

    private boolean isValid(String brackets) {
        Stack<Character> stack = new Stack();
        char[] chars = brackets.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if(ch=='(' || ch =='{' || ch != '['){
                stack.push(ch);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                else if (ch == ')' && '(' != stack.peek()) {
                    return false;
                }
                else if (ch == '}' && '{' != stack.peek()) {
                    return false;
                }
                else if (ch == ']' && '[' != stack.peek()) {
                    return false;
                } else stack.pop();
            }
        }
        return stack.isEmpty();

    }
}
