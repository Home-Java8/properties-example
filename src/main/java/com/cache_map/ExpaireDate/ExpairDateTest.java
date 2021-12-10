package com.cache_map.ExpaireDate;

import java.time.LocalDate;
import java.util.Date;

public class ExpairDateTest {

    public static void main(String[] args) {
        Date validUntilDate = DateFormatUtil.stringToDate(DateFormatEnum.MINI_STATEMENT_DATE_FORMATT, "2020-08-20T00:00:00");
//        boolean isValidUntilDate = DateFormatUtil.expiredDate(validUntilDate, new Date());
//        System.out.println("isValidUntilDate = " + isValidUntilDate);

        boolean isValidUntilDate = DateFormatUtil.expiredDate(validUntilDate, LocalDate.now());
        System.out.println("isValidUntilDate = " + isValidUntilDate);
    }
}
