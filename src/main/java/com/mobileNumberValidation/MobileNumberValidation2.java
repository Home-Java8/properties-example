package com.mobileNumberValidation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

/**
 * java check if string is phone number
 * ************************************
 * @see https://www.javatpoint.com/mobile-number-validation-in-java
 *      https://mvnrepository.com/artifact/com.googlecode.libphonenumber/libphonenumber/8.12.31
 */
public class MobileNumberValidation2 {

    public static void main(String args[]) throws NumberParseException {
        System.out.println("US Number Formats: ");
        //creating an array of US number formats
        String[] usFormats = { "(541) 777-3777", "+1-541-999-3111", "1-541-788-5010", "001-541-876-9090", "181 541 745 9090" };
        //method calling to validate numbers
        validateNumber(usFormats, "US");

        System.out.println("\nIndian Number Formats: ");
        //creating an array of Indian number formats
        String[] indiaNumberFormats = { "+91 9999999999", "8888888888", "+91-3333333333", "+91 9222222222", "+91 8888 999 777", "+7666 999 999" };
        //method calling to validate numbers
        validateNumber(indiaNumberFormats, "IN");
    }

    //function that validates mobile numbers
    private static void validateNumber(String[] phoneNumbers, String country) throws NumberParseException {
        //PhoneNumberUtil class provides formatting, parsing and validation
        //getInstance() method is loaded with all phone number metadata
        PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();
        //for each loop iterate over the number formats array
        for (String number : phoneNumbers) {
            //the parse() method parses a string and country and returns it as a phone number in proto buffer format
            PhoneNumber phoneNumber = numberUtil.parse(number, country);
            //tests whether a phone number matches a valid pattern or not
            boolean isValid = numberUtil.isValidNumber(phoneNumber);
            if (isValid) {
                //prints if a number is a valid number
                System.out.println(number + " is a valid mobile number.");
            } else {
                //prints if the number is invalid
                System.out.println(number + " is a not valid mobile number. ");
            }
        }
    }
}
