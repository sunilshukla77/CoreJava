package com.ps.assignment;

public class A {

    A(){
        System.out.println("A");
    }

    public static void main(String[] args) {
        String[] s ={"SDF","sadf"};
        //B.main(s); //.StackOverflowError
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

    }
}
