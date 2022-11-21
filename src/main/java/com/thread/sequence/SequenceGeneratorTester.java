package com.thread.sequence;

public class SequenceGeneratorTester {
    private static final int NUMBER_OF_THREADS = 3;
    private static final int TOTAL_NUMBERS_IN_SEQ = 10;

    public static void main(String[] args) {
        NumbersGenerator numbersGenerator = new NumbersGenerator(NUMBER_OF_THREADS, TOTAL_NUMBERS_IN_SEQ);

        Thread t1 = new Thread(new SequenceGenerator(numbersGenerator, 1), "THREAD-1");
        Thread t2 = new Thread(new SequenceGenerator(numbersGenerator, 2), "THREAD-2");
        Thread t3 = new Thread(new SequenceGenerator(numbersGenerator, 0), "THREAD-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
Write a Java program to print a sequence of numbers upto N using 3 threads.
For example, if we want to print a sequence of numbers upto 10 then it’ll look like this:
 */