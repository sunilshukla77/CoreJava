package com.ps.assignment;

import java.util.DoubleSummaryStatistics;

import java.util.stream.Stream;

public class Summarize {

    public static void main(String[] args) {

        Stream<Double> stream = Stream.of(1.2, 2.4, 3.6, 4.8, 6.0);
        DoubleSummaryStatistics stats = stream.mapToDouble((x) -> x)
                .summaryStatistics();
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        //System.out.println("Range: " + stats.getRange());
        //System.out.println("Standard Deviation: " + stats.getStandardDeviation());

        //System.out.println("Variance: " + stats.getVariance());

    }

}



