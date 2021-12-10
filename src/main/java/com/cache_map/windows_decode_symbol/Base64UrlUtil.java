package com.cache_map.windows_decode_symbol;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.apache.commons.lang3.StringUtils;

public class Base64UrlUtil {

    public static String encode(String value) {
        if (StringUtils.isBlank(value)) return null;
        try {
            value = value.replace(".", "");
            return Base64.getUrlEncoder()
                    .encodeToString(value.getBytes(StandardCharsets.UTF_8.toString()));
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String decode(String value) {
        if (StringUtils.isBlank(value)) return null;
        try {
            value = value.replace(".", "");
            byte[] decodedValue = Base64.getUrlDecoder()
                    .decode(value);
            return new String(decodedValue, StandardCharsets.UTF_8.toString());
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
