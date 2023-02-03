package com.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorization {
    public static ArrayList<Integer> primeFactorization(int input)
    {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        if( input < 2 )
            return primeFactors;
        for(int i = 2; i <= input; i++)
        {
            while( input % i == 0 )
            {
                input = input / i;
                primeFactors.add(i);
            }
        }
        return primeFactors;
    }

    public static void main(String args[])
    {

        System.out.println(primeFactorization(6) + " " + primeFactorization(5));
        if(primeFactorization(6).equals(Arrays.asList(2,3))
                &&
                primeFactorization(5).equals(Arrays.asList(5))
        ) {
            System.out.println("All passed");
        }else {
            System.out.println("Failed");
        }

    }
}
