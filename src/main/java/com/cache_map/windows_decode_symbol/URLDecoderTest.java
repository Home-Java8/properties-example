package com.cache_map.windows_decode_symbol;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLDecoderTest {

    public static void main(String[] args) {
//        String deviceName = "\u0002v���\"�";
////        String _deviceName = deviceName.replaceAll("[^a-zA-Z0-9-_\\.]", "");
//        String _deviceName = null;
////        try {
////            _deviceName = URLEncoder.encode(deviceName, "UTF-8");
////            System.out.println(_deviceName.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", ""));
////        } catch (UnsupportedEncodingException e) {
////            e.printStackTrace();
////        }
//
//        System.out.println(deviceName.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", ""));
//
////        System.out.println(_deviceName);


        String pattern = "[A-Za-z0-9!@#$%^&*()-_=+;:',./?\\ ]*";
        String text = "Hello, I need everything in " + "\u0002v���\"�" + " this string except the { or }";

        Pattern p = Pattern.compile( pattern );
        Matcher m = p.matcher( text );
        StringBuilder sb = new StringBuilder();
        while( m.find() )
        {
            sb.append( m.group() );
        }
        String result = sb.toString();
        System.out.println( "Result: '" + result + "'" );
    }

}
