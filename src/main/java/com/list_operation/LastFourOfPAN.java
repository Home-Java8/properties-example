package com.list_operation;

import org.apache.commons.lang3.StringUtils;

public class LastFourOfPAN {

    public static void main(String[] args) {
        String maskedPan = "56123_098876";
//        String lastFourOfPAN = maskedPan.substring(maskedPan.length()-4, maskedPan.length());
//        String lastFourOfPAN = getLastFourOfPAN(""); //
//        String lastFourOfPAN = getLastFourOfPAN(null); //
//        String lastFourOfPAN = getLastFourOfPAN("6"); // 6
//        String lastFourOfPAN = getLastFourOfPAN("876"); // 876
        String lastFourOfPAN = getLastFourOfPAN("56123_098876"); // 8876

        System.out.println(maskedPan);
        System.out.println(lastFourOfPAN);
    }

    static String getLastFourOfPAN(String maskedPan) {
        if (StringUtils.isNotBlank(maskedPan) && 0 < maskedPan.length()) {
            return maskedPan.length() < 4
                    ? maskedPan.substring(0, maskedPan.length())
                    : maskedPan.substring(maskedPan.length()-4, maskedPan.length());
        }
        return "";
    }

}
