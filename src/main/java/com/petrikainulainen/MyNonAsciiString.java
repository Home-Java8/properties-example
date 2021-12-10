package com.petrikainulainen;

import java.nio.charset.StandardCharsets;

/**
 * @see https://www.java2novice.com/java_string_examples/remove-non-ascii-chars/
 *      https://www.techiedelight.com/convert-byte-array-string-java/
 *      https://memorynotfound.com/remove-accents-diacritics-from-string/
 *
 * https://stackoverflow.com/questions/28890907/implement-a-function-to-check-if-a-string-byte-array-follows-utf-8-format
 */

public class MyNonAsciiString {

    public static void main(String[] args) {

        String str = "Bj��rk����oacute�";
        System.out.println(str);

        System.out.println();

//        str = str.replaceAll("[^\\p{ASCII}]", "?");
        str = replaceNonASCII(str);
        System.out.println("After removing non ASCII chars:");
        System.out.println(str);

        String tmp = replaceNonASCII("Ж~");
        System.out.println("After removing non ASCII chars:");
        System.out.println(tmp);
        tmp = replaceNonASCII("�~John\u0080\u0099s Phone");
        System.out.println("After removing non ASCII chars:");
        System.out.println(tmp);
        tmp = replaceNonASCII("Ж~John\u0080\u0099s Phone");
        System.out.println("After removing non ASCII chars:");
        System.out.println(tmp);

        System.out.println();

        byte[] bytes = replaceNonASCII_2(str);
        System.out.println("After removing non ASCII chars:");
        System.out.println(bytes);

        System.out.println();

        // Create a string from the byte array with "UTF-8" encoding
        str = "Bj��rk����oacute�Жdj";
        final byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);

        String string = new String(bytes2, StandardCharsets.UTF_8);
        System.out.println(string);
        string = replaceNonASCII(bytes2);
        System.out.println("After removing non ASCII chars:");
        System.out.println(string);
        byte[] bytes3 = replaceNonASCII_2(bytes2);
        System.out.println("After removing non ASCII chars:");
        System.out.println(bytes3);
    }

    // @see http://dostmuhammad.com/blog/strip-non-ascii-characters-from-a-string-using-regex-regular-expressions/
    static String replaceNonASCII(final String str) {
//        return str.replaceAll("[^\\p{ASCII}]", "?"); //TODO:  ?~
        return str.replaceAll("[^u0000-u007F]+","?"); //TODO:  ?
    }

    static byte[] replaceNonASCII_2(final String str) {
        return str.replaceAll("[^\\p{ASCII}]", "?").getBytes();
    }

    static String replaceNonASCII(final byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        return str.replaceAll("[^\\p{ASCII}]", "?");
    }

    static byte[] replaceNonASCII_2(final byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        return str.replaceAll("[^\\p{ASCII}]", "?").getBytes();
    }
}
