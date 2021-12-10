package com.petrikainulainen;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @see https://www.base64decoder.io/java/
 *      http://qaru.site/questions/7255934/decode-base64-url-in-java
 */
public class Base64EncoderDemo {

    public static void main(String[] args) {
//        String url = "aHR0cDovL05jLmtwaS51YS9hdXR1bW4yMDEz";
//        System.out.println( base64Decode(url) );

//        String data = "hello:world!?$*&()'-=@~";
//        String data = "aHR0cDovL05jLmtwaS51YS9hdXR1bW4yMDEz";
        String data = "Жо";
        String encodedData = base64Encode(data);
        System.out.println(base64Decode(encodedData));
    }

    // Base64 Basic Decoding
    private static String base64Decode(String value) {
        try {
            byte[] decodedValue = Base64.getDecoder().decode(value);
            return new String(decodedValue, StandardCharsets.UTF_8.toString());
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    // Base64 Basic Encode
    private static String base64Encode(String value) {
        try {
            return Base64.getEncoder()
                    .encodeToString(value.getBytes(StandardCharsets.UTF_8.toString()));
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
