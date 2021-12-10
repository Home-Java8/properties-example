package com.petrikainulainen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @see https://www.mkyong.com/java/how-to-convert-string-to-date-java
 */

public class TestDateExample1 {

    public static void main(String[] argv) {
        test1();
        test2();
//        test3_1();
        test3_2();

        test4();
    }

    static void test1() {
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
        Date date = new Date();
        String date2 = formatter.format(date);
//        System.out.println(dateInDate);
        System.out.println(date + " >>> " + date2);
    }

    static void test2() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyy");

        try {
            String dateInString = "12042019";
            Date date1 = formatter.parse(dateInString);
            System.out.println(dateInString + "   >>> " + date1);
//            System.out.println(formatter.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("#################");
        Date date = new Date();
        String date2 = formatter.format(date);
//        System.out.println(dateInDate);
        System.out.println(date + " >>> " + date2);
    }

//    static void test3_1() {
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd.mm.yyyy");
//        SimpleDateFormat formatter2 = new SimpleDateFormat("ddmmyyyy");
//
//        String dateInString1 = "12.04.2019";
//        String dateInString2 = "12042019";
//
//        try {
//            System.out.println("#################");
//            Date date2 = formatter2.parse(dateInString2);
//            String date1 = formatter1.format(date2);
//            System.out.println(dateInString2 + " >>> " + date1);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

    static void test3_2() {
        String formatter1 = "dd.mm.yyyy";
        String formatter2 = "ddmmyyyy";

        String dateInString1 = "12.04.2019";
        String dateInString2 = "12042019";

        System.out.println("#################");
        String dateInString = toFormat(formatter1, formatter2, dateInString1);
        System.out.println(dateInString1 + " >>> " + dateInString);

        dateInString = toFormat(formatter2, formatter1, dateInString2);
        System.out.println(dateInString2 + "   >>> " + dateInString);
    }

//    static void test4() {
//        String formatter1 = "dd MMMM yyyy";
//        String dateInString1 = "12.04.2019";
//
//        System.out.println("#################");
//        String dateInString = toFormat(formatter1, formatter1, dateInString1);
//        System.out.println(dateInString1 + " >>> " + dateInString);
//    }

    static void test4() {

        SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMMM yyyy");
        Date now = new Date();
        String strDate = sdfDate.format(now);

        System.out.println("#################");
        System.out.println(">>> " + strDate + " <<<");
    }

    static String toFormat(String dateFormatFrom, String dateFormatTo, String dateInString) {
        final SimpleDateFormat formatterFrom = new SimpleDateFormat(dateFormatFrom);
        final SimpleDateFormat formatterTo = new SimpleDateFormat(dateFormatTo);

        try {
            return formatterTo.format(
                    formatterFrom.parse(dateInString));
        } catch (ParseException e) {
            return null;
        }
    }
}
