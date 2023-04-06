package com.behavioral.Observer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestNokia {

    public static void main(String[] args) {
        String str = "apcdeefghiijkleee";   //e=3 i=1
        char[] ch = str.toCharArray();
        int counter = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                map.put(ch[i], counter++);
            }
        }
        map.entrySet().stream().filter(v -> v.getValue() > 1).forEach(System.out::println);
        // or
        Map<Character, Long> chaMap =
                str.chars().mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors. counting()));
       chaMap.entrySet().stream().filter(v->v.getValue()>1).forEach(System.out::print);

    }
}
