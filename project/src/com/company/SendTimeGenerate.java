package com.company;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Pouya on 1/6/2018.
 */
public class SendTimeGenerate {
    public String run(){
        GregorianCalendar calendar = new GregorianCalendar();
        int year = ThreadLocalRandom.current().nextInt(2005, 2014);
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        int day = ThreadLocalRandom.current().nextInt(1, 31);
        int hour = ThreadLocalRandom.current().nextInt(0, 24);
        int min = ThreadLocalRandom.current().nextInt(1, 60);
        int sec = ThreadLocalRandom.current().nextInt(1, 60);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        calendar.set(year, month, day, hour, min, sec);
        String sendTime = sdf.format(calendar.getTime());
        return sendTime;
    }
}
