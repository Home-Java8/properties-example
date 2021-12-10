package com.cache_map.windows_decode_symbol;

import org.apache.commons.codec.binary.Base64;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class URLDecoderTest4 {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        InputStream in = new InputStream() {
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//        }
//        BufferedInputStream bis = new BufferedInputStream("");

//        String incorrect = "????61 ????????61";
//        String out = new String(incorrect.getBytes("ISO-8859-1"), "UTF-8");
//        System.out.println(out);
//
//        CharsetDetector detector = new CharsetDetector();
//        detector.setText(yourStr.getBytes());
//        detector.detect();  // <- return the result, you can check by .getName() method

//        String str = "\u00F6";
//        char c = '\u00F6';
//        Character letter = new Character('\u00F6');
//
//        OutputStreamWriter out = new OutputStreamWriter(new ByteArrayOutputStream());
//        System.out.println(out.getEncoding());

//        String value = "שלומ";
//        Map map = Charset.availableCharsets();
//        Iterator it = map.keySet().iterator();
//        while (it.hasNext()) {
//            // Get charset name
//            String charsetName = (String)it.next();
//            // Get charset
//            Charset charset = Charset.forName(charsetName);
//            //  тут есть несколько вариантов например так:
//            try {
//                byte[] b = value.getBytes(charsetName);
//                value = new String(b, "UTF-8");
//                System.out.println("charsetName="+charsetName+"; value ="+value );
//            } catch (Exception e) {
//                System.out.println("Is not "+charsetName+"; message:"+e.getMessage());
//            }
//        }

//        String original = new String("A" + "\u00ea" + "\u00f1" + "\u00fc" + "C");
//        System.out.println( original );
//
//        try {
//            byte[] utf8Bytes = original.getBytes("UTF8");
//            byte[] defaultBytes = original.getBytes();
//
//            String roundTrip = new String(utf8Bytes, "UTF8");
//            System.out.println("roundTrip = " + roundTrip);
//            System.out.println();
//            printBytes(utf8Bytes, "utf8Bytes");
//            System.out.println();
//            printBytes(defaultBytes, "defaultBytes");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

////        String str = "hey\u6366";
////        String str = "\u001E)e";
//        String str = "\u0002v���\"�";
//        byte[] charset = str.getBytes("UTF-8");
//        String result = new String(charset, "UTF-8");
//        System.out.println(result);

//        System.out.println(
////                convertToBinary("T", "US-ASCII"));
//            convertToBinary("\u001E)e", "UTF-8"));


        final String test1 = "samsung - SM-J500FN";
        final String test2 = "Мой телефон 1";
        final String test3 = "\u001E)e";
        final String test4 = "\u0002v���\"�";
        final String test5 = "u�ں[";
        final String test6 = "samsung - SM-J500FN" + "Мой телефон 1" + "\u001E)e";
        final String test7 = "\u041F" + "\u0440" + "\u0438" + "\u0432" + "\u0435" + "\u0442" + "!";

//        String s = test2;
//        boolean isCyrillic = s.chars()
//                .mapToObj(Character.UnicodeBlock::of)
//                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));
//        System.out.println("Test-2: \"" + s + "\" is cyrillic='" + isCyrillic + "'");

//        s = test4;
//        boolean isLatin = s.chars()
//                .mapToObj(Character.UnicodeBlock::of)
//                .anyMatch(b -> b.equals(Character.UnicodeBlock.BASIC_LATIN));
//        System.out.println("Test-1: \"" + s + "\" is latin='" + isLatin + "'");

//        try {
////            String priwet = new String("\u041F" + "\u0440" + "\u0438" + "\u0432" + "\u0435" + "\u0442" + "!");
////            String priwet = new String(test1);
//            String priwet = new String(test4);
//            byte[] utf8Bytes = priwet.getBytes("UTF8");
//            String priwet2 = new String(utf8Bytes,"UTF8");
//            System.out.println(priwet2);
//        }   catch (UnsupportedEncodingException e)  {
//            e.printStackTrace();
//        }

        // @see https://souluran.wordpress.com/2015/04/09/what-encoding-string-utf8-or-win1251

////        String utf8String= new String(test3.getBytes("windows-1251"), "UTF-8");
//        String utf8String= new String(test3.getBytes("UTF-8"), "cp1251");
//        System.out.println(utf8String);
//        String cp1251Str = new String(stringInUtf8.getBytes("UTF-8"), "cp1251");

//        String s2 = test4;
//        boolean isCyrillic2 = s2.chars()
//                .mapToObj(Character.UnicodeBlock::of)
//                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));
//        boolean isBase64 = Base64.isBase64(s2);
//        System.out.println("Test: " + s2);
//        System.out.println("Test: Cyrillic=" + isCyrillic2);
//        System.out.println("Test: Base64=" + isBase64);
//        if (!isCyrillic2 && !isBase64) {
//            System.out.println("Test: " +
//                    Base64.encodeBase64String(s2.getBytes()));
//        } else {
//            System.out.println("Test: " + s2);
//        }

        test(test1);
        test(test2);
        test(test3);
        test(test4);
        test(test5);
        test(test6);
        test(test7);
    }

    static void test(String str) {
        String convert = convert(str);
        System.out.println(" Origin: '" + str + "'");
        System.out.println("Convert: '" + convert + "'");
//        System.out.println("decode: " + Base64.decodeBase64(str));
//        System.out.println("Test: " + new String(str.getBytes("cp1251"), "UTF-8"));
//        System.out.println("isBase64: " + Base64.isBase64(convert));
        System.out.println();
    }

    static boolean checkUnicode(String str) {
        boolean isCyrillic = str.chars()
                .mapToObj(Character.UnicodeBlock::of)
                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));
        boolean isBase64 = Base64.isBase64(str);
        System.out.println("Is Cyrillic='" + isCyrillic + "'. " + "Is Base-64='" + isBase64 + "'. ");
        return (!isCyrillic && !isBase64);
    }

    static boolean ignoreUnicode(String str) {
        boolean isArabic = str.chars()
                .mapToObj(Character.UnicodeBlock::of)
                .anyMatch(b -> b.equals(Character.UnicodeBlock.ARABIC));
        System.out.println("Is Arabic='" + isArabic + "'.");
        return isArabic;
    }

    static String convert(String str) {
        if (ignoreUnicode(str)) return "";
        String encodeStr = checkUnicode(str)
//                ? Base64.encodeBase64String(str.getBytes())
                ? Base64UrlUtil.encode(str)
                : str;

//        Pattern pattern = Pattern.compile("[а-яА-Я]");
////        Pattern pattern = Pattern.compile("[a-zA-Z]");
////        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9]");
//        Matcher matcher = pattern.matcher(encodeStr);
//        System.out.println("Is matches='" + matcher.find() + "'.");
////        System.out.println("Is matches='" + Pattern.matches("[a-zA-Z]", encodeStr) + "'.");

        return encodeStr;
    }

    // @see https://www.codeflow.site/ru/article/java-char-encoding
    static String convertToBinary(String input, String encoding) throws UnsupportedEncodingException {
        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();
        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e ^ 255))
                .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }

    public static void printBytes(byte[] array, String name) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x" +
                    UnicodeFormatter.byteToHex(array[k]));
        }
    }
}
