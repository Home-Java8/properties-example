package com.petrikainulainen;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @see https://www.journaldev.com/2800/java-8-date-localdate-localdatetime-instant
 *      https://stackoverflow.com/questions/3581258/adding-n-hours-to-a-date-in-java
 */

public class DateMinusHour {

    public static void main(String[] args) {
        Date date1 = new Date();
        Instant date2 = date1.toInstant();
        Date date3 = plusHours(date1, 3);
        Date date4 = plusHours(date1, -3);

        System.out.println("date-1 = " + date1);
        System.out.println("date-2 = " + date2);
        System.out.println("date-3 = " + date3);
        System.out.println("date-4 = " + date4);


        LocalTime time1 = LocalTime.now();
        LocalTime time2 = time1.minusHours(3);
        LocalTime time3 = time1.plusHours(3);

        System.out.println("time-1 = " + time1);
        System.out.println("time-2 = " + time2);
        System.out.println("time-3 = " + time3);
    }

    static Date plusHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(date);                     // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, hours);  // adds one hour
        return cal.getTime();
    }
}
