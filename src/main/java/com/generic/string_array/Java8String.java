package com.generic.string_array;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8String {

    public static void main(String[] args) {
        String str;

        str = null;
        System.out.println("str = " + str);

        str = "sendOtp";
        System.out.println("str = " + str);

        str = "confirmProvisioning,AVS1,sendOtp";
        System.out.println("str = " + str +
                "; sendOtp = " + contains(str, "sendOtp") + ";");

        str = null;       // false
        str = "";         // false
        str = " ";        // false
        str = "    ";     // false
        str = ",";        // false
        str = ", ";       // false
        str = "  ,  ";    // false
        str = ",,";       // false
        str = ", , ";     // false
        str = "  ,  ,  "; // false
        str = "sendOtp";                          // true
        str = " sendOtp ";                        // true
        str = "sendOtp,";                         // true
        str = " sendOtp , ";                      // true
//        str = "confirmProvisioning,AVS1,sendOtp"; // true
        str = "confirmProvisioning,AVS1,sendOtpp";  // false
        System.out.println("str = " + str +
                "; sendOtp = " + contains(str, "sendOtp") + ";");
    }

    static boolean contains(String clients, String item) {
        if (StringUtils.isBlank(clients)) return false;
        String[] arr = clients.replace(" ", "").split(",");
        return Arrays.asList(arr).contains(item);
    }

//    static boolean contains(String str, String item) {
//        return get(str).contains(item);
//    }
//
//    static List<String> get(String str) {
////        System.out.println("........." + str + "........." + StringUtils.isBlank(str));
//        if (StringUtils.isBlank(str)) return new ArrayList<>();
//        String[] arr = str.replace(" ", "").split(",");
//        return Arrays.asList(arr);
//    }

}
