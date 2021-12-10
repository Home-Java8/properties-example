package com.generic.string_array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java8pattern {

    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final Pattern EXPIRATION_DATE_PATTERN = Pattern.compile("^(?<" + YEAR + ">\\d{4})-(?<" + MONTH + ">\\d{2})-(\\d{2})$");

    public static void main(String[] args) {
        String tokenExpdate = convertTokenExpirationDate("2018-11-20");
        System.out.println(tokenExpdate); //TODO: 1118
    }

    private static String convertTokenExpirationDate(String source) {
        Matcher expirationDateMatcher = EXPIRATION_DATE_PATTERN.matcher(source);
        if (expirationDateMatcher.matches()) {
            String year = expirationDateMatcher.group(YEAR);
            String month = expirationDateMatcher.group(MONTH);
            return month + year.substring(2);
        }
        return null;
    }

}
