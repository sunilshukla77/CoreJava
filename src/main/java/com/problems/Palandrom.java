package com.problems;

import java.util.List;
import java.util.stream.Collectors;

public class Palandrom {
    public static void main(String[] args) {
        String val = "A man, a plan, a canal: Panama";
        List<Character> arrayChar = val.chars().mapToObj(i -> (char) i).
                filter(Character::isAlphabetic)
                .map(Character::toLowerCase).
                collect(Collectors.toList());
        System.out.println(arrayChar.toString());
        System.out.println("Palandrom " + isPalandrom(arrayChar));
    }

    static boolean isPalandrom(List<Character> arrayChar) {
        for (int i = 0, j = arrayChar.size() - 1; i <= arrayChar.size() / 2; i++, j--) {
            if (!arrayChar.get(i).equals(arrayChar.get(j))) {
                return false;
            }
        }
        return true;

    }
}

