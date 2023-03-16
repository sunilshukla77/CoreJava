package com.thread.Assignment;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ThreadTest {

    Date startTime = new Date();
    int NUM_OF_THREAD = 4;
    int NUM_OF_CYCLE = 10;


    @Test
    public void showVal() throws InterruptedException {
        List<String> urlList = readUrl();
        //Start number of cycle
        for (int i = 0; i < NUM_OF_CYCLE; i++) {
            //Run number of threads using executor 4 display time and url

            executeUrl(urlList);
        }
        // calculate final
        calculate(urlList);

    }

    List<String> readUrl() {
        String[] strArr = {"www.google.com", "www.yahoo.com", "www.bing.com", "www.rediff.com"};
        return Arrays.stream(strArr).collect(Collectors.toList());
    }

    void executeUrl(List<String> urls) throws InterruptedException {
        ExecutorService exc = Executors.newFixedThreadPool(NUM_OF_THREAD);
        urls.parallelStream().forEach(url -> exc.execute(new UrlThread(url, new Date())));

        //exc.submit(new UrlThread(url, new Date()));

        Random r = new Random();
        Thread.sleep(r.nextInt(10)*1000);
        System.out.println();
        exc.shutdownNow();
    }

    void calculate(List<String> urls) {
        System.out.println("\n Final Standing");
        for (String url: urls) {
            UrlThread t= new UrlThread(url, startTime);
            t.run();
        }

        while(true){
            UrlThread t  = new UrlThread("test", startTime);
        }
    }
}
