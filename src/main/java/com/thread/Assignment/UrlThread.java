package com.thread.Assignment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UrlThread implements Runnable{

    String url;
    Date startTime;
    public UrlThread(String url, Date startTime) {
        this.url = url;
        this.startTime= startTime;
    }

    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String strDate = format.format(startTime);
        Long diffTime = (System.currentTimeMillis()-startTime.getTime());
        System.out.print(strDate + " "+ url + " " + new Date(diffTime));
    }
}
