package com.petrikainulainen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @see https://www.mkyong.com/java/how-to-convert-string-to-date-java
 */

public class TestDateExample1 {

    public static void main(String[] argv) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");

        try {
            String dateInString = "12.04.2019";
            Date date1 = formatter.parse(dateInString);
            System.out.println(dateInString + " >>> " + date1);
//            System.out.println(formatter.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("#################");
        Date dateInDate = new Date();
        String date2 = formatter.format(dateInDate);
//        System.out.println(dateInDate);
        System.out.println(dateInDate + " >>> " + date2);
    }
}
