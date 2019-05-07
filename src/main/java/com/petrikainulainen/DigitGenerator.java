package com.petrikainulainen;

/**
 * @see https://www.experts-exchange.com/questions/28935451/Generate-UUID-with-14-digit.html
 */

public class DigitGenerator {

    public static void main(String[] args) {
        System.out.println(getUID());
        System.out.println(getUID());
        System.out.println(getUID());
        System.out.println(getUID());
    }

    public static String getUID() {
        int DIGITS = 18;
        StringBuilder sb = new StringBuilder(DIGITS);
        for(int i = 0;i < DIGITS;i++) {
            sb.append((char) (Math.random() * 10 + '0'));
        }
        return sb.toString();
    }
}
