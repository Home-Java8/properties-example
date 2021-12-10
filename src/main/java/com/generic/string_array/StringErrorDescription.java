package com.generic.string_array;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringErrorDescription {

    public static void main(String[] args) {
//        String data = "status=400,message=VSE_ERROR_INVALID_DATA,reason=VSE40000,details=<null>";
//        String[] errors = data.split(",");
//
//        Map<String, String> map =
//                Stream.of(errors)
//                        .map(e -> e.split("="))
//                        .collect(Collectors.toMap(p -> p[0], p -> p[1]));
//        System.out.println(map);


//        String errorDescription = null;
//        String errorDescription = "";
//        String errorDescription = "Error calling VTS service:";
//        String errorDescription = "Error calling VTS service: []";
//        String errorDescription = "Error calling VTS service: [status=400,message=VSE_ERROR_INVALID_DATA,reason=VSE40000,details=<null>";
//        String errorDescription = "Error calling VTS service: [reason=VSE40000]";
//        String errorDescription = "Error calling VTS service: [status=400,message=VSE_ERROR_INVALID_DATA,reason=VSE40000,details=<null>]]";
//        String errorDescription = "Error calling VTS service: [status=400,message=VSE_ERROR_INVALID_DATA,reason=,details=<null>]";
        String errorDescription = "Error calling VTS service: [status=400,message=VSE_ERROR_INVALID_DATA,reason=VSE40000,details=<null>]";
        System.out.println(errorDescription);

        Map<String, String> errorData = getErrorData(errorDescription);
        String status = errorData.get("status");
        String reason = errorData.get("reason");
        String message = errorData.get("message");
        String details = errorData.get("details");
        System.out.println("status = " + status);
        System.out.println("reason = " + reason);
        System.out.println("message = " + message);
        System.out.println("details = " + details);
    }


    static Map<String, String> getErrorData(String errorDescription) {
        if (StringUtils.isNotBlank(errorDescription)) {
            errorDescription = StringUtils.substringBetween(errorDescription, "[", "]");
            if (StringUtils.isNotBlank(errorDescription)) {
                String[] errors = 0 < errorDescription.split(",").length
                        ? errorDescription.split(",")
                        : new String[]{errorDescription};
                return Stream.of(errors)
                        .map(e -> e.split("="))
                        .filter(e -> 1 < e.length)
                        .collect(Collectors.toMap(p -> p[0], p -> p[1]));
            }
        }
        return new HashMap<>();
    }
}
