package com.petrikainulainen;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @see https://www.base64decoder.io/java/
 *      http://qaru.site/questions/7255934/decode-base64-url-in-java
 */
class Base64UrlDecodeExample {

    // Base64 URL Decoding
    private static String base64UrlDecode(String value) {
        try {
            byte[] decodedValue = Base64.getUrlDecoder().decode(value);
            return new String(decodedValue, StandardCharsets.UTF_8.toString());
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String base64UrlEncode(String value) {
        try {
            return Base64.getUrlEncoder()
                    .encodeToString(value.getBytes(StandardCharsets.UTF_8.toString()));
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        test1();

        System.out.println( test2("hello:world!?$*&()'-=@~") );
        System.out.println( test2("Жо") );
        System.out.println( test2("aHR0cDovL05jLmtwaS51YS9hdXR1bW4yMDEz") );
    }

    static void test1() {
        String data = "hello:world!?$*&()'-=@~";

        String urlEncodedData = base64UrlEncode(data);
        System.out.println(base64UrlDecode(urlEncodedData));
    }

    static String test2(String data) {
        try {
            return base64UrlDecode(data);
        } catch (Exception ex) {
            return data;
        }
    }
}
