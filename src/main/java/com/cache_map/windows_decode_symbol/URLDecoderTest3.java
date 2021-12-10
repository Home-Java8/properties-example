package com.cache_map.windows_decode_symbol;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLDecoderTest3 {

    public static void main(String[] args) {
        final String test1 = "\u001E)e";
        final String test2 = "\u0002v���\"�";
        final String test4 = "Мой телефон 1";
        final String test5 = "samsung - SM-J500FN";


//        try {
        System.out.println("Test-1: " + test1);
            String _fill = Base64.encodeBase64String(test1.getBytes());
//        String _fill = Base64.encodeBase64URLSafeString(fill.getBytes());
        System.out.println("Test-1: " + _fill);

        System.out.println("Test-2: " + test2);
        _fill = Base64.encodeBase64URLSafeString(test2.getBytes());
        System.out.println("Test-2: " + _fill);

        System.out.println();

        System.out.println("Test-1: " + test1);
        System.out.println("Test-1: " +
                Base64UrlUtil.encode(test1));

        System.out.println();
        System.out.println("Test-2: " +
                Base64UrlUtil.encode(test2));
        System.out.println("Test-2: " + test2);

        System.out.println();
        System.out.println("Test-3: " +
                Base64UrlUtil.encode(null));

        System.out.println();
        System.out.println("Test-4: " + test4);
        System.out.println("Test-4: " +
                Base64UrlUtil.encode(test4));

        System.out.println();
        System.out.println("Test-5: " + test5);
        System.out.println("Test-5: " +
                Base64UrlUtil.encode(test5));

        System.out.println();
//        String s = "Тест";
//        String s = "Абв";
        String s = test1;
        boolean cyrillic = s.chars()
                .mapToObj(Character.UnicodeBlock::of)
                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));
        System.out.println("Test-6: " + s);
        System.out.println("Test-6: " + cyrillic);

//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
    }

}
