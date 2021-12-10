package com.cache_map.windows_decode_symbol;

public class URLDecoderTest2 {

    public static void main(String[] args) {
        String deviceName = "\u0002v���\"�";

        System.out.println(deviceName);
        System.out.println(dotInvalidXMLCharacters(deviceName));
    }

    public static String dotInvalidXMLCharacters(String in) {
        if (in == null) {
            return in;
        }

        String xmlPattern = "[^" +
                "\u0009\r\n" +
                "\u0020-\u007E" +
                "\u00A0-\uD7FF" +
                "\uE000-\uFFFD" +
                "\u0002" +
                "]";

        return in.replaceAll(xmlPattern, ".").trim();
    }

}
