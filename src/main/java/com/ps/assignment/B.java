package com.ps.assignment;

import java.sql.SQLOutput;

public class B extends A{

    B(){
        System.out.println("B");
    }
    public static void main(String[] args) {
        String[] s ={"SDF","sadf"};
        A.main(s);  // Work

        System.out.println();
    }
}
