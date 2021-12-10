package com.generic;

import java.util.Map;

import com.google.common.base.Splitter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StringFilterTest2 {

    static String HEASDERS = "{\n" +
            "  Accept=[\n" +
            "    application/json,\n" +
            "    application/xml,\n" +
            "    application/*+json,\n" +
            "    text/xml,\n" +
            "    application/*+xml\n" +
            "  ],\n" +
            "  Content-Length=[\n" +
            "    0\n" +
            "  ],\n" +
            "  User-Agent=[\n" +
            "    sdk-api-core: 1.4.19/1.0.6\n" +
            "  ],\n" +
            "  Authorization=[\n" +
            "    OAuthoauth_consumer_key=\"Dy6G99Y-myMEAQY-fStuIdTbCEJibMe5pyHM1Qdp2e2377d2%218881ec2129384c8998a828f86f608fe40000000000000000\",\n" +
            "    oauth_nonce=\"3v86ut8eun7tiq1t3kkop9v17g\",\n" +
            "    oauth_signature=\"K5nDvWFXXZ7JnCPQ%2FHpQ0NCm8VaEGzol%2BMfAnGLxMKR4X8RTLQtg07ECvYYg1FAdZ3vc3MpjiDq8ul042ujm96Xl2iWUQTBpwde8x1Ia2NcOKyyD9KoKrds%2FEK9zhzgWfFSSZbFMA9Iwer1XuuB6%2FGsWaOU%2FSeGRVQ0dfh3SGys9NZrezKiNgDa8l%2F%2BmCm6JlwjocUCYkDaeUb5d4d0C%2FYZRMSM3Gfpc4qxJH5qACiL3bQZtu90KbfQd0jYCh4wgYVzRn8zlOFbzAC4EBh2b3REDT9C0rrX2pcic34ya5fe5yO0u%2BqSHBi2TJDycVYyQWPvV7ZARkH5c%2FxmLABR%2FnQ%3D%3D\",\n" +
            "    oauth_signature_method=\"RSA-SHA256\",\n" +
            "    oauth_timestamp=\"1612951345\",\n" +
            "    oauth_version=\"1.0\"\n" +
            "  ]\n" +
            "}";

    static String HEADERS3 = "{\"Authorization\":\"OAuth oauth_body_hash\\u003d\\\"6cqzqBW2oWsKCix5JhYv/cFp66ISXx0I2RZ9GU1f0Xg\\u003d\\\",oauth_nonce\\u003d\\\"7bIgZtaXLBnYWM4o\\\",oauth_signature\\u003d\\\"fgZ%2FA1AnJ8qawCqBaD6J7B4Gs6O4x45O5v4PxZCp\n" +
            "QJj0fxWLmAjR2GP1zyX2%2BL%2FIh%2FWRx%2BmdAGm%2FToNznhmQZwBb%2F0cwQ19fF8LgCiZpxoaZv%2By9xU%2BAZzDfIs%2BIE2qSdp8sVjXyPPSBtFHJCIMF08o21FwSPEEbXie4xC%2BFWfscsgWwdOGgcQtmr4ZouinjOvdPxz%2BjxhZSynefi2ptz7hBvoXVzsbvmJrRy\n" +
            "caK835%2BDRHX%2B2t5b8A8W2Y1GC6T%2FDF7vKHVv3PAWX3d1iDBUR%2F9vQm3uZfMjIVUyX1SSsDjkMjBi2oTkFUfLNle%2F40ZHppoODbSmlmywVkJ%2Btp4Cw%3D%3D\\\",oauth_consumer_key\\u003d\\\"Dy6G99Y-myMEAQY-fStuIdTbCEJibMe5pyHM1Qdp2e2377d2!88\n" +
            "81ec2129384c8998a828f86f608fe40000000000000000\\\",oauth_signature_method\\u003d\\\"RSA-SHA256\\\",oauth_timestamp\\u003d\\\"1612873889\\\",oauth_version\\u003d\\\"1.0\\\"\",\"Accept\":\"application/json, application/*+json\",\"User-A\n" +
            "gent\":\"sdk-api-core:1.4.19/1.0.6\",\"Content-Type\":\"application/json;charset\\u003dUTF-8\"}";

    static String HEADERS4 = "{\"Authorization\":\"OAuth oauth_body_hash\\u003d\\\"F//TELP1JcZSA3bUnl7LMeWXf6GZBE90NqZPWK1sA6c\\u003d\\\",oauth_nonce\\u003d\\\"4ANinaDkgyhSCS9u\\\",oauth_signature\\u003d\\\"PkB7FDNlIK4yLzzWZh70voCQHBw6i%2BToWkneMvml\n" +
            "c71N%2B9NghbHltMaLJnOIZwd7Sd9AkTU4CjT0XCHKaBOwIJsU3x%2B0kVdquafXB%2Bmxb67rCY2kWVdVz3pYt81OSVNKKyP822pNbXVjYivVcKNczeqjz262dc75PE7O%2BPye6wyfv6oZiOKm4dXtVmy43jfcKMltorZo1C27uc8ViK8mj%2FQQhuNtmJtLRrIL2dcboqX7x5eUr\n" +
            "gwd9yTXFtVB5a9CeblPJyOarPVPZM0HjW%2FVUYs%2BuDR69lIlEailSlaVSMT7quxSAl3rMCRr0NlpTZSJkvZtquPA0rIf1we5AB55sg%3D%3D\\\",oauth_consumer_key\\u003d\\\"Dy6G99Y-myMEAQY-fStuIdTbCEJibMe5pyHM1Qdp2e2377d2!8881ec2129384c8998a828\n" +
            "f86f608fe40000000000000000\\\",oauth_signature_method\\u003d\\\"RSA-SHA256\\\",oauth_timestamp\\u003d\\\"1612873892\\\",oauth_version\\u003d\\\"1.0\\\"\",\"Accept\":\"application/json, application/*+json\",\"User-Agent\":\"sdk-api-core:\n" +
            "1.4.19/1.0.6\",\"Content-Type\":\"application/json;charset\\u003dUTF-8\"}";

    public static void main(String[] args) {
        String str = "ZZZZL <%= dsn %> AFFF <%= AFG %>";
//        Pattern pattern = Pattern.compile("<%=(.*?)%>");
//        String[] result = pattern.split(str);
//        System.out.println(Arrays.toString(result));

//        String[] result = StringUtils.substringsBetween(str, "<%=", "%>");
//        System.out.println(Arrays.toString(result));

//        String[] result = StringUtils.substringsBetween(HEASDERS, " ", "\",");
////        System.out.println(Arrays.toString(result));
//        System.out.println(result[0]);

//        HashMap<String, String> holder = new HashMap();
//        String payload = "cossn=0, abc=hello/=world";
//        String[] keyVals = payload.split(", ");
//        for(String keyVal:keyVals) {
//            String[] parts = keyVal.split("=",2);
//            holder.put(parts[0],parts[1]);
//        }

        // This String contains key-value pairs.
//        String value = "Data Structures=Coding,Sports=Football,Capital=Delhi";
        String value = "{\n" +
                "    OAuthoauth_consumer_key=\"Dy6G99Y-myMEAQY-fStuIdTbCEJibMe5pyHM1Qdp2e2377d2%218881ec2129384c8998a828f86f608fe40000000000000000\",\n" +
                "    oauth_nonce=\"3v86ut8eun7tiq1t3kkop9v17g\",\n" +
                "    oauth_signature=\"K5nDvWFXXZ7JnCPQ%2FHpQ0NCm8VaEGzol%2BMfAnGLxMKR4X8RTLQtg07ECvYYg1FAdZ3vc3MpjiDq8ul042ujm96Xl2iWUQTBpwde8x1Ia2NcOKyyD9KoKrds%2FEK9zhzgWfFSSZbFMA9Iwer1XuuB6%2FGsWaOU%2FSeGRVQ0dfh3SGys9NZrezKiNgDa8l%2F%2BmCm6JlwjocUCYkDaeUb5d4d0C%2FYZRMSM3Gfpc4qxJH5qACiL3bQZtu90KbfQd0jYCh4wgYVzRn8zlOFbzAC4EBh2b3REDT9C0rrX2pcic34ya5fe5yO0u%2BqSHBi2TJDycVYyQWPvV7ZARkH5c%2FxmLABR%2FnQ%3D%3D\",\n" +
                "    oauth_signature_method=\"RSA-SHA256\",\n" +
                "    oauth_timestamp=\"1612951345\",\n" +
                "    oauth_version=\"1.0\"\n" +
                "}";
//
        // Using Splitter to parse key-value separators.
        // This returns a MapSplitter which splits
        // entries based on this splitter, and splits
        // entries into keys and
        // values using the specified separator.
        Map<String, String> mp = Splitter.on(',').withKeyValueSeparator('=')
                .split(value);
//                .split(HEASDERS);

        for (Map.Entry<String, String> entry : mp.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
            System.out.println(entry.getValue());
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


//        JsonParser parser = new JsonParser();
//        String json = "{ \"f1\":\"Hello\",\"f2\":{\"f3\":\"World\"}}";
//        JsonElement jsonTree = parser.parse(json);
//        if(jsonTree.isJsonObject()){
//            JsonObject jsonObject = jsonTree.getAsJsonObject();
//            JsonElement f1 = jsonObject.get("f1");
//            JsonElement f2 = jsonObject.get("f2");
//            if(f2.isJsonObject()){
//                JsonObject f2Obj = f2.getAsJsonObject();
//                JsonElement f3 = f2Obj.get("f3");
//            }
//        }

        // @see https://www.codingame.com/playgrounds/3743/how-to-parse-json-in-java
        String json = "{\"name\": \"Bob\", \"id\": \"123\"}";
        // Method 1: parsing into a JSON element
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        System.out.println(jsonObject.get("name").getAsString());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        JsonObject jsonObject2 = new JsonParser().parse(value).getAsJsonObject();
        System.out.println(jsonObject2.get("oauth_signature_method").getAsString());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for (Map.Entry<String, JsonElement> entry: jsonObject2.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        JsonObject jsonObject3 = new JsonParser().parse(HEADERS3).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry: jsonObject3.entrySet()) {
            JsonElement entryValue = entry.getValue();
            boolean isJsonObject = entryValue.isJsonObject();
//            String strJsonObject = entryValue.getAsString();
            String strJsonObject = entryValue.toString();
            System.out.println("( isJsonObject=" + isJsonObject + " ) " + entry.getKey() + "=" + strJsonObject);

//            Map<String, String> mpp = Splitter.on(',').withKeyValueSeparator('=')
//                    .split(strJsonObject);
//            for (Map.Entry<String, String> entryy : mpp.entrySet()) {
//                System.out.println(entryy.getValue());
//            }
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

//        String aaa = "oauth_body_hash=\"6cqzqBW2oWsKCix5JhYv/cFp66ISXx0I2RZ9GU1f0Xg=\",oauth_nonce=\"7bIgZtaXLBnYWM4o\",oauth_signature=\"fgZ%2FA1AnJ8qawCqBaD6J7B4Gs6O4x45O5v4PxZCp\n" +
//                "QJj0fxWLmAjR2GP1zyX2%2BL%2FIh%2FWRx%2BmdAGm%2FToNznhmQZwBb%2F0cwQ19fF8LgCiZpxoaZv%2By9xU%2BAZzDfIs%2BIE2qSdp8sVjXyPPSBtFHJCIMF08o21FwSPEEbXie4xC%2BFWfscsgWwdOGgcQtmr4ZouinjOvdPxz%2BjxhZSynefi2ptz7hBvoXVzsbvmJrRy\n" +
//                "caK835%2BDRHX%2B2t5b8A8W2Y1GC6T%2FDF7vKHVv3PAWX3d1iDBUR%2F9vQm3uZfMjIVUyX1SSsDjkMjBi2oTkFUfLNle%2F40ZHppoODbSmlmywVkJ%2Btp4Cw%3D%3D\",oauth_consumer_key=\"Dy6G99Y-myMEAQY-fStuIdTbCEJibMe5pyHM1Qdp2e2377d2!88\n" +
//                "81ec2129384c8998a828f86f608fe40000000000000000\",oauth_signature_method=\"RSA-SHA256\",oauth_timestamp=\"1612873889\",oauth_version=\"1.0\"";
//
//        Map<String, String> mpp = Splitter.on(',').withKeyValueSeparator('=').split(aaa);

//        String payload = "cossn=\"0\",itwrqm=\"200006033213\"";
//        String payload = "oauth_body_hash=\"6cqzqBW2oWsKCix5JhYv/cFp66ISXx0I2RZ9GU1f0Xg=\",oauth_nonce=\"7bIgZtaXLBnYWM4o\",oauth_signature=\"fgZ%2FA1AnJ8qawCqBaD6J7B4Gs6O4x45O5v4PxZCpQJj0fxWLmAjR2GP1zyX2%2BL%2FIh%2FWRx%2BmdAGm%2FToNznhmQZwBb%2F0cwQ19fF8LgCiZpxoaZv%2By9xU%2BAZzDfIs%2BIE2qSdp8sVjXyPPSBtFHJCIMF08o21FwSPEEbXie4xC%2BFWfscsgWwdOGgcQtmr4ZouinjOvdPxz%2BjxhZSynefi2ptz7hBvoXVzsbvmJrRycaK835%2BDRHX%2B2t5b8A8W2Y1GC6T%2FDF7vKHVv3PAWX3d1iDBUR%2F9vQm3uZfMjIVUyX1SSsDjkMjBi2oTkFUfLNle%2F40ZHppoODbSmlmywVkJ%2Btp4Cw%3D%3D\",oauth_consumer_key=\"Dy6G99YmyMEAQYfStuIdTbCEJibMe5pyHM1Qdp2e2377d28881ec2129384c8998a828f86f608fe40000000000000000\",oauth_signature_method=\"RSASHA256\",oauth_timestamp=\"1612873889\",oauth_version=\"1.0\"";
//        String payload = "oauth_signature_method=\"RSASHA256\",oauth_timestamp=\"1612873889\",oauth_version=\"1.0\"";
//        String payload = "oauth_nonce=\"7bIgZtaXLBnYWM4o\",oauth_signature=\"fgZ%2FA1AnJ8qawCqBaD6J7B4Gs6O4x45O5v4PxZCpQJj0fxWLmAjR2GP1zyX2%2BL%2FIh%2FWRx%2BmdAGm%2FToNznhmQZwBb%2F0cwQ19fF8LgCiZpxoaZv%2By9xU%2BAZzDfIs%2BIE2qSdp8sVjXyPPSBtFHJCIMF08o21FwSPEEbXie4xC%2BFWfscsgWwdOGgcQtmr4ZouinjOvdPxz%2BjxhZSynefi2ptz7hBvoXVzsbvmJrRycaK835%2BDRHX%2B2t5b8A8W2Y1GC6T%2FDF7vKHVv3PAWX3d1iDBUR%2F9vQm3uZfMjIVUyX1SSsDjkMjBi2oTkFUfLNle%2F40ZHppoODbSmlmywVkJ%2Btp4Cw%3D%3D\",oauth_consumer_key=\"Dy6G99YmyMEAQYfStuIdTbCEJibMe5pyHM1Qdp2e2377d28881ec2129384c8998a828f86f608fe40000000000000000\",oauth_signature_method=\"RSASHA256\",oauth_timestamp=\"1612873889\",oauth_version=\"1.0\"";
        String payload = "oauth_body_hash=\"6cqzqBW2oWsKCix5JhYv/cFp66ISXx0I2RZ9GU1f0Xg=\",oauth_nonce=\"7bIgZtaXLBnYWM4o\",oauth_signature=\"fgZ%2FA1AnJ8qawCqBaD6J7B4Gs6O4x45O5v4PxZCpQJj0fxWLmAjR2GP1zyX2%2BL%2FIh%2FWRx%2BmdAGm%2FToNznhmQZwBb%2F0cwQ19fF8LgCiZpxoaZv%2By9xU%2BAZzDfIs%2BIE2qSdp8sVjXyPPSBtFHJCIMF08o21FwSPEEbXie4xC%2BFWfscsgWwdOGgcQtmr4ZouinjOvdPxz%2BjxhZSynefi2ptz7hBvoXVzsbvmJrRycaK835%2BDRHX%2B2t5b8A8W2Y1GC6T%2FDF7vKHVv3PAWX3d1iDBUR%2F9vQm3uZfMjIVUyX1SSsDjkMjBi2oTkFUfLNle%2F40ZHppoODbSmlmywVkJ%2Btp4Cw%3D%3D\",oauth_consumer_key=\"Dy6G99YmyMEAQYfStuIdTbCEJibMe5pyHM1Qdp2e2377d28881ec2129384c8998a828f86f608fe40000000000000000\",oauth_signature_method=\"RSASHA256\",oauth_timestamp=\"1612873889\",oauth_version=\"1.0\"";

        Map<String, String> holder = Splitter.on(",").trimResults().withKeyValueSeparator("=").split(payload);
        for (Map.Entry<String, String> h : holder.entrySet()) {
            System.out.println(h.getKey() + "=" + h.getValue());
        }
    }

}
