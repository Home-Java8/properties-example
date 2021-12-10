//package com.generic;
//
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.JsonSyntaxException;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class StringFilterTest3 {
//
//    static String Headers1 = "{\"Authorization\":\"OAuth oauth_body_hash\\u003d\\\"F//TELP1JcZSA3bUnl7LMeWXf6GZBE90NqZPWK1sA6c\\u003d\\\",oauth_nonce\\u003d\\\"4ANinaDkgyhSCS9u\\\",oauth_signature\\u003d\\\"PkB7FDNlIK4yLzzWZh70voCQHBw6i%2BToWkneMvml" +
//            "c71N%2B9NghbHltMaLJnOIZwd7Sd9AkTU4CjT0XCHKaBOwIJsU3x%2B0kVdquafXB%2Bmxb67rCY2kWVdVz3pYt81OSVNKKyP822pNbXVjYivVcKNczeqjz262dc75PE7O%2BPye6wyfv6oZiOKm4dXtVmy43jfcKMltorZo1C27uc8ViK8mj%2FQQhuNtmJtLRrIL2dcboqX7x5eUr" +
//            "gwd9yTXFtVB5a9CeblPJyOarPVPZM0HjW%2FVUYs%2BuDR69lIlEailSlaVSMT7quxSAl3rMCRr0NlpTZSJkvZtquPA0rIf1we5AB55sg%3D%3D\\\",oauth_consumer_key\\u003d\\\"Dy6G99Y-myMEAQY-fStuIdTbCEJibMe5pyHM1Qdp2e2377d2!8881ec2129384c8998a828" +
//            "f86f608fe40000000000000000\\\",oauth_signature_method\\u003d\\\"RSA-SHA256\\\",oauth_timestamp\\u003d\\\"1612873892\\\",oauth_version\\u003d\\\"1.0\\\"\",\"Accept\":\"application/json, application/*+json\",\"User-Agent\":\"sdk-api-core:" +
//            "1.4.19/1.0.6\",\"Content-Type\":\"application/json;charset\\u003dUTF-8\"}";
//
//    static String Headers2 = "{\n" +
//            "  Accept=[\n" +
//            "    application/json,\n" +
//            "    application/xml,\n" +
//            "    application/*+json,\n" +
//            "    text/xml,\n" +
//            "    application/*+xml\n" +
//            "  ],\n" +
//            "  Content-Length=[\n" +
//            "    0\n" +
//            "  ],\n" +
//            "  User-Agent=[\n" +
//            "    sdk-api-core: 1.4.19/1.0.6\n" +
//            "  ],\n" +
//            "  Authorization=[\n" +
//            "    OAuthoauth_consumer_key=\"Dy6G99Y-myMEAQY-fStuIdTbCEJibMe5pyHM1Qdp2e2377d2%218881ec2129384c8998a828f86f608fe40000000000000000\",\n" +
//            "    oauth_nonce=\"3v86ut8eun7tiq1t3kkop9v17g\",\n" +
//            "    oauth_signature=\"K5nDvWFXXZ7JnCPQ%2FHpQ0NCm8VaEGzol%2BMfAnGLxMKR4X8RTLQtg07ECvYYg1FAdZ3vc3MpjiDq8ul042ujm96Xl2iWUQTBpwde8x1Ia2NcOKyyD9KoKrds%2FEK9zhzgWfFSSZbFMA9Iwer1XuuB6%2FGsWaOU%2FSeGRVQ0dfh3SGys9NZrezKiNgDa8l%2F%2BmCm6JlwjocUCYkDaeUb5d4d0C%2FYZRMSM3Gfpc4qxJH5qACiL3bQZtu90KbfQd0jYCh4wgYVzRn8zlOFbzAC4EBh2b3REDT9C0rrX2pcic34ya5fe5yO0u%2BqSHBi2TJDycVYyQWPvV7ZARkH5c%2FxmLABR%2FnQ%3D%3D\",\n" +
//            "    oauth_signature_method=\"RSA-SHA256\",\n" +
//            "    oauth_timestamp=\"1612951345\",\n" +
//            "    oauth_version=\"1.0\"\n" +
//            "  ]\n" +
//            "}";
//
//    static String[] allowedHeaders = {"X-REQUEST-ID", "Accept", "Content-Language", "x-pay-token"};
//
//    public static void main(String[] args) {
////        JsonObject jsonObject1 = new JsonParser().parse(Headers1).getAsJsonObject();
////        for (Map.Entry<String, JsonElement> entry: jsonObject1.entrySet()) {
////            String strJsonObject = entry.getValue().getAsString();
////
////            int lengthJsonObject = strJsonObject.split("=\"").length;
////
////            if (1 < lengthJsonObject) {
////                String[] arrJsonObject = strJsonObject.split(",");
////                for (String strPropObject: arrJsonObject) {
////                    String arrPropObject[] = strPropObject.split("=", 2);
////                    if (1 < arrPropObject.length) System.out.println(arrPropObject[0] + " = " + arrPropObject[1]);
////                    else System.out.println(entry.getKey() + " = " + strJsonObject);
////                }
////            } else {
////                System.out.println(entry.getKey() + " = " + strJsonObject);
////            }
////        }
//
////        for (Map.Entry<String, String> entry: getAsProperies(Headers1).entrySet()) {
////            Arrays.asList(allowedHeaders).replaceAll(String::toLowerCase);
////
////            if (Arrays.asList(allowedHeaders).contains(entry.getKey().toLowerCase())) System.out.println(entry.getKey() + " = " + entry.getValue());
////            else System.err.println(entry.getKey() + " = " + entry.getValue());
////        }
//
//        for (Map.Entry<String, String> entry: getAsProperies1(Headers1, allowedHeaders).entrySet()) System.out.println(entry.getKey() + " = " + entry.getValue());
//
////        for (Map.Entry<String, String> entry: getAsProperies(Headers2, allowedHeaders).entrySet()) System.out.println(entry.getKey() + " = " + entry.getValue());
//
////        // ////////////////////////////////////////////////////////
////        /**
////         * @see https://javadevblog.com/primer-ispol-zovaniya-metoda-split-na-java.html
////         */
////        String[] arr1 = Headers2.split("\\[");
////        String[] arr2 = StringUtils.substringsBetween(Headers2, "=[", "]");
////        System.out.println("==================");
////        System.out.println("length1 = " + arr1.length);
////        System.out.println("length2 = " + arr2.length);
////        for (String a: arr1) {
////            System.out.println("------------------1");
////////            int i1 = a.indexOf(" ") + 1;
////////            int i2 = a.indexOf("=");
//////            int i1 = a.lastIndexOf(" ") + 1;
//////            int i2 = a.lastIndexOf("=");
////////            System.out.println(a);
////////            System.out.println(a.length());
//////            System.out.println(a.substring(i1, i2));
////            try {
////                int i1 = a.lastIndexOf(" ") + 1;
////                int i2 = a.lastIndexOf("=");
////                System.out.println(a.substring(i1, i2));
////            } catch (Exception e) { }
////        }
////        for (String a: arr2) {
////            System.out.println("------------------2");
////            System.out.println(a);
////        }
//
////        // ////////////////////////////////////////////////////////
////
////        String[] header1 = Headers2.split("\\[");
////        String[] header2 = StringUtils.substringsBetween(Headers2, "=[", "]");
////
////        for (int h2=0; h2<header2.length; h2++) {
////            System.out.println("...................");
////            int i1 = header1[h2].lastIndexOf(" ") + 1;
////            int i2 = header1[h2].lastIndexOf("=");
////            System.out.println(header1[h2].substring(i1, i2));
////            System.out.println(header2[h2]);
////        }
//
//        // ////////////////////////////////////////////////////////
//        System.out.println();
//
//        for (Map.Entry<String, String> entry: getAsProperies2(Headers2, allowedHeaders).entrySet()) System.out.println(entry.getKey() + " = " + entry.getValue());
//    }
//
//    /**
//     * @see https://www.geeksforgeeks.org/collectors-tomap-method-in-java-with-examples/
//     */
//    static Map<String,String> getAsProperies1(String value, String[] allowedHeaders) {
//        Arrays.asList(allowedHeaders).replaceAll(String::toLowerCase);
////        try {
//            Map<String,String> asProperies = getAsProperies(value);
//            return mapToStream(asProperies)
//                    .filter(prop ->
//                            Arrays.asList(allowedHeaders).contains(prop.getKey().toLowerCase()))
//                    .collect(Collectors.toMap(prop -> prop.getKey(), prop -> prop.getValue()));
////        } catch (JsonSyntaxException e) {
////            return new HashMap<>();
////        }
//    }
//
//    static Map<String,String> getAsProperies2(String value, String[] allowedHeaders) {
//        Arrays.asList(allowedHeaders).replaceAll(String::toLowerCase);
//        Map<String,String> asProperies = new HeaderHeader(value).getAsProperies();
//
//        return mapToStream(asProperies)
//                .filter(prop ->
//                        Arrays.asList(allowedHeaders).contains(prop.getKey().toLowerCase()))
//                .collect(Collectors.toMap(prop -> prop.getKey(), prop -> prop.getValue()));
//    }
//
//    /**
//     * @see https://www.techiedelight.com/convert-map-stream-java/
//     * Generic function to convert Map<K,V> to a Stream of <Map.Entry<K,V>
//     */
//    private static <K,V> Stream<Map.Entry<K,V>> mapToStream (Map<K,V> map) {
//        return map.entrySet().stream();
//    }
//
//    static Map<String,String> getAsProperies(String value) {
//        Map<String,String> asProperies = new HashMap<>();
//
//        try {
//            JsonObject jsonObject = new JsonParser().parse(value).getAsJsonObject();
//
//            for (Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
//                String strJsonObject = entry.getValue().getAsString();
//
//                int lengthJsonObject = strJsonObject.split("=\"").length;
//
//                if (1 < lengthJsonObject) {
//                    String[] arrJsonObject = strJsonObject.split(",");
//                    for (String strPropObject: arrJsonObject) {
//                        String arrPropObject[] = strPropObject.split("=", 2);
//                        if (1 < arrPropObject.length) asProperies.put(arrPropObject[0], arrPropObject[1]);
//                        else asProperies.put(entry.getKey(), strJsonObject);
//                    }
//                } else {
//                    asProperies.put(entry.getKey(), strJsonObject);
//                }
//            }
//            return asProperies;
//        } catch (JsonSyntaxException e) {
//            return new HashMap<>();
//        }
//    }
//}
//
//class HeaderHeader {
//    private final String regexValue = "^\\s+";
//    private Map<String, String> hashtable = new HashMap<>();
//
//    public HeaderHeader(String str) {
//        if (StringUtils.isNotBlank(str)) {
//            String[] keys = str.split("\\[");
//            String[] values = StringUtils.substringsBetween(str, "=[", "]");
//
//            for (int i=0; i<values.length; i++) {
//                int firstKey = keys[i].lastIndexOf(" ") + 1;
//                int endKey = keys[i].lastIndexOf("=");
//                String key = keys[i].substring(firstKey, endKey);
//                String value = values[i].replaceAll(regexValue, "");
//                value = value.replaceAll("[\\s|\\t|\\r\\n]+"," ").trim();
//                hashtable.put(key, value);
//            }
//        }
//    }
//
//    public Map<String, String> getAsProperies() {
//        return hashtable;
//    }
//}