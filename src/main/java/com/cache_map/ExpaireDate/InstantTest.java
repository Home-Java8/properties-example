package com.cache_map.ExpaireDate;

import java.time.Instant;
import java.util.Date;

public class InstantTest {

    public static void main(String[] args) {
        // 2020-12-22 09:00:53.385000

        Instant end1 = Instant.now();
        System.out.println("end1             = '" + end1 + "'");
        System.out.println("end1.toString()  = '" + end1.toString()  + "'");

        Date end2 = new Date();
        System.out.println("end2             = '" + end2.toString() + "'");


        Date dateEnd1 = Date.from(end1);
    }

}
