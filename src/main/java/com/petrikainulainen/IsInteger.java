package com.petrikainulainen;

public class IsInteger {

    public static void main(String[] args) {
        String val1 = "MOBILE_PHONE";
        String val2 = "99";
        String val3 = "03";

        System.out.println(val1 + " = " + isInteger(val1));
        System.out.println(val2 + " = " + isInteger(val2));
        System.out.println(val3 + " = " + isInteger(val3));
    }

    static boolean isInteger(Object obj) {
        if(obj instanceof Integer) {
            return true;
        } else {
            try {
                Integer.parseInt(obj.toString());
            } catch(NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }
}
