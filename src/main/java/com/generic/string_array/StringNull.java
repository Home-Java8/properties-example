package com.generic.string_array;

import org.apache.commons.lang3.StringUtils;

public class StringNull {

    public static void main(String[] args) {
        String requestId = "3fd4372a-0dea-4fb4-9b5f-f0697a92541f";
//        String stan = "3ded881a-1da5-49f3-84b0-8dc613c3125e";
//        String stan = "XXXXXXXX-XXXX-XXXX-XXXX-554811548094";
        String stan = null;

//        String id = !"XXXXXXXX-XXXX-XXXX-XXXX-".contains(stan) ? stan : requestId;
        String id = (StringUtils.isNotBlank(stan) && !stan.contains("XXXXXXXX-XXXX-XXXX-XXXX-")) ? stan : requestId;
        System.out.println(id);

    }

}
