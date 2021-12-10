package com.cache_map.ExpaireDate;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateFormatUtil {

    public static Date stringToDate(DateFormatEnum dateFormatEnum, String value) {
        if (StringUtils.isNotBlank(value)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatEnum.getValue());
            try {
                return dateFormat.parse(value);
            } catch (ParseException ignored) {
                ignored.printStackTrace();
            }
        }
        return null;

    }

    private static boolean expiredDate(Date startDate, Date endDate) {
        return endDate.before(startDate) ? true : false;
    }

    public static boolean expiredDate(Date startDate, LocalDate endDate) {
        LocalDate endLocalDate = endDate.minusDays(1);
        Date fixEndDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return expiredDate(startDate, fixEndDate);
    }
}
