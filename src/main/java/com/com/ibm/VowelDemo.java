package com.com.ibm;

import java.util.Scanner;

public class VowelDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] chars = input.toCharArray();
        int count = 0;

        for (char c : chars) {
            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;

            }
        }
        System.out.println("Count of Vowels:  "+ count);
    }
}
