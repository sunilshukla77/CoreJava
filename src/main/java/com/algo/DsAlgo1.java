package com.algo;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DsAlgo1 {

    /**
     * start traversing from end compare MAX value
     * The time complexity of this solution is O(n).
     */
    @Test
    public void MaxValueRightElement() {
        int[] arrayInt = {17, 5, 13, 8, 16, 1, 2};
        List<Integer> result = new ArrayList<>();
        int MaxValue = arrayInt[6];
        for (int i = 6; i >= 0; i--) {
            if (MaxValue <= arrayInt[i]) {
                MaxValue = arrayInt[i];
                result.add(MaxValue);
            }
        }
        System.out.println(result.toString());
    }

    /*
     * SubString counter problem ??
     * Find String subStr= abc, The time complexity of this solution is O(n).
     */
    @Test
    public void StringCount() {
        String str = "abcdabceabcfabch";
        String findSubString = "abc";
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            String subStr= str.substring(i, i + 3);
            if (findSubString.equals(subStr)){
                count++;
            }
        }
        System.out.println("Count " + count);
    }

    /**
     * print sequence of ticket
     */
    @Test
    public void SourceToDestinationSequence(){
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet, "Bombay");

        double d1 = 12342.23;
        double d2 = 12342.23;
        System.out.println(d1==d2);
    }

    private void printResult(Map<String, String> dataSet, String source) {
        String destination = dataSet.get(source);
        if(destination!=null) {
            System.out.println(source + "->" + destination);
            printResult(dataSet, destination);
        }
    }
}
