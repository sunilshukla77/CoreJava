package com.test;

public class FirstDemo {

    int multiply (int a, int b){
        return a*b;
    }

    public static void main(String[] args) {
        System.out.println("This is my first program");

        for (int i = 0; i <= 10; i++) {  // i local variable
            System.out.println("2*" +i+ "="+i*2);
        }

        FirstDemo fd = new FirstDemo(); // Creating a memory in JVM (Creating instance in memory)
        int mu= fd.multiply(4,5); // fd instance variable

        // Boxing and unboxing concept
        byte b1 = (byte) 120;
        byte b2 = (byte) 120;

        int b3 = Integer.valueOf(b1);  //Integer is static variable
        int b4 = Integer.valueOf(b2);

        int sum = Integer.sum(b3, b4 );

        String salary = "50000";
        int sal = Integer.parseInt(salary);

        System.out.println(sum);
        System.out.println(salary);
        System.out.println(sal+2000+"$");
        System.out.println(mu);

        // Difference between static and instance variable


    }
}
