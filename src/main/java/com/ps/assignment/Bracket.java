package com.ps.assignment;

import org.junit.Test;

import java.util.Stack;

public class Bracket {

    @Test
    public void bracket(){
        String brackets = "[{)}]";
        if(isValid(brackets)){
            System.out.println("Valid");
        }else {
            System.out.println("InValid");
        }

    }

    private boolean isValid(String brackets) {
        boolean isValid = false;
        Stack<Character> bStack = new Stack();
        if (!brackets.isEmpty()) {
            for (char br : brackets.toCharArray()) {
                if (br == '(' || br == '{' || br == '[') {
                    bStack.push(br);
                    //break;
                } else if (br == ')') {
                    if (!bStack.isEmpty() || bStack.pop() == '(') {
                        isValid= true;
                    }
                } else if (br == '}'){
                    if (!bStack.isEmpty() || bStack.pop() == '{') {
                        isValid = true;
                    }
                } else if (br == ']') {
                    if (!bStack.isEmpty() || bStack.pop() == ']') {
                        isValid = true;
                    }
                } else if (bStack.isEmpty()) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }
}
