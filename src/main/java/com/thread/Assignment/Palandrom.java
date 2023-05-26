package com.thread.Assignment;

import java.util.List;
import java.util.stream.Collectors;

public class Palandrom {
    public static void main(String[] args) {
        String val = "A man, a plan, a canal: Panama";
        List<Character> listChar = val.chars().mapToObj(i -> (char) i).
                filter(Character::isAlphabetic)
                .map(Character::toLowerCase).
                collect(Collectors.toList());
        System.out.println(listChar.toString());
        System.out.println("Palandrom " + isPalandrom(listChar));
    }

    static boolean isPalandrom(List<Character> listChar) {// half rotation
        for (int i = 0, j = listChar.size() - 1; i <= listChar.size() / 2; i++, j--) {
            if (!listChar.get(i).equals(listChar.get(j))) {
                return false;
            }
        }
        return true;

    }
}

