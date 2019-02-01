package com.petrikainulainen;

import java.util.HashMap;
import java.util.Map;

/**
 * @see https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
 * @see https://stackoverflow.com/questions/31094305/java-gson-getting-the-list-of-all-keys-under-a-jsonobject
 */
public class JsonConverter {

    public static void main(String[] args) {

        String requestData = "{\n" +
                "  \"requestId\": \"01a3e0c5-d876-4fa0-a91e-56bb8c7e7bc6\",\n" +
                "  \"tokens\": [\n" +
                "    {\n" +
                "      \"tokenUniqueReference\": \"DTC1MC0000171740bf9605c539fe4c41834520eeb0719137\",\n" +
                "      \"status\": \"SUSPENDED\",\n" +
                "      \"suspendedBy\": [\n" +
                "        \"ISSUER\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"reasonCode\": \"STATUS_UPDATE\"\n" +
                "}";
        String memberName = "requestId";

//        System.out.println("memberName = " + StringUtil.getAsString(requestData, memberName));


        String jsonText = "{\"originator\":\"MDES\",\"messageHistoryId\":66721,\"authorizeServiceDto\":{\"requestId\":\"01a3e0c5-d876-4fa0-a91e-56bb8c7e7bc6\",\"services\":[\"DIGITIZATION\"],\"correlationId\":\"D1000003322390\",\"tokenRequestorId\":\"40010030273\",\"walletId\":\"220\",\"paymentAppInstanceId\":\"E029361010194\",\"activeTokenCount\":0,\"tokenType\":\"CLOUD\",\"encryptedData\":\"2887FB5238FD2EDDBB33D971A5169271EDDCE21CA79562B75B4072987CA8B7102CF2B227A730D2925A1EF105A54405B0D0271043D3D0520E916FD055C8D222796A80FFCD0ACC01DCF6A5DCCA1E3335697F02581838359CA73F19245648EDC8461213C12CC0E10B0E9CE9752363F1B2205F2162B9DE61E6E0833B232295357F2B941C7AF42E11EAFE524E37D3C70093913E2CA417F2D905DF87330F2E231B9BEF3203BB901D4196B2E5592CA3502E8D88EC06CFBAD59A4669F4AB810CF855ECC36396693145424C416E864B17BFA2CBAB335132FBDFB9FD394FB1CF321914AA933F2A21F82FD7AEDFEF392163775F21E56D1B1C757B715327080BD210453D6648FE70ADA66725985C3C4BC0EB95745BF775B60ADC5C61EE22934021C8D0DD151365A87AA21A92E8DC45747AF1B5F62F706D550832327E03DBEF0B005DD67E3F591A295197062800110B34A01B255AA1D7250691C684A386160A59CA08A984BFAEC3C9F7BCA93ED8FCF6F46453AB483B3EFAC88C3CAAF3CD2A95E7D0615F1CEE5C0DBADB7A97530B704FECAB0FFA6243EE20FA8D61834216C3A42CBE815E38E06C4F2CC7803DB236A05ED14E9BF7D21104B493F78BCFF7C361EFFAA41C8A4E99419D4ED8FA98385C6721458919BA5FAC34\",\"publicKeyFingerprint\":\"3e70356e5a17b769009bc099c2dcae4b6b82f482a3f59711715d683f7e6fd167\",\"encryptedKey\":\"AAD08D20380DC188FF0C36E7725D3C2158F6152A113D07E17DDE79326FA464FE2ECFAC2952B93FC8FD3F5DA618E01C97D2A5A4A159A537384D9AF7754923F9B9E363C8400434753C65747AA916D964E0E3A815B92DCFC605A8F9A4B53FE585B9D5DF5B9F09B07C7ECA10D8A25CD8AF6832001C00EFA8C0AA6B79907FC732AFA677DA47D80E778C960AB1C2741D44EAF25A1B434E327ECA186C93C45AED33FB3D047ADFB9C493A4417DC8645B8CFA731B98C0930752B3B5AC1BD8EC5C5B94B46BAA2AAF13F4BDF4E6B02ABFFD9E4EF8DBA6BBE65BAFDCF13ED9064A3FE680DBFFFAB45365C5920C6341C9B68C5053F68195860258710FCC0F9EC441D92CBA65BA\",\"oaepHashingAlgorithm\":\"SHA256\",\"iv\":\"33CC701395B23592B48326F67984D618\",\"panUniqueReference\":\"FSHRMC0000171740c1e6896893b74619836a21a20a543b64\",\"deviceName\":\"Test Phone\",\"formFactor\":\"PHONE\",\"isoDeviceType\":\"14\",\"osName\":\"ANDROID\",\"osVersion\":\"4.4\",\"paymentTypes\":[\"NFC\",\"DSRP\"],\"storageTechnology\":\"DEVICE_MEMORY\",\"recommendedDecision\":\"REQUIRE_ADDITIONAL_AUTHENTICATION\",\"recommendationStandardVersion\":\"1.0\",\"deviceScore\":1,\"accountScore\":\"1\",\"recommendationReasons\":[\"ACCOUNT_TOO_NEW\",\"TOO_MANY_RECENT_ATTEMPTS\",\"OUTSIDE_HOME_TERRITORY\"]}}";

        String jsonText2 = "{\n" +
                "  \"originator\": \"MDES\",\n" +
                "  \"messageHistoryId\": 66721,\n" +
                "  \"authorizeServiceDto2\": {\n" +
                "    \"authorizeServiceDto3\": {\n" +
                "      \"requestId\": \"01a3e0c5-d876-4fa0-a91e-56bb8c7e7bc6\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"authorizeServiceDto\": {\n" +
                "    \"services\": [\n" +
                "      \"DIGITIZATION\"\n" +
                "    ],\n" +
                "    \"correlationId\": \"D1000003322390\",\n" +
                "    \"tokenRequestorId\": \"40010030273\",\n" +
                "    \"walletId\": \"220\",\n" +
                "    \"paymentAppInstanceId\": \"E029361010194\",\n" +
                "    \"activeTokenCount\": 0,\n" +
                "    \"tokenType\": \"CLOUD\",\n" +
                "    \"encryptedData\": \"2887FB5238FD2EDDBB33D971A5169271EDDCE21CA79562B75B4072987CA8B7102CF2B227A730D2925A1EF105A54405B0D0271043D3D0520E916FD055C8D222796A80FFCD0ACC01DCF6A5DCCA1E3335697F02581838359CA73F19245648EDC8461213C12CC0E10B0E9CE9752363F1B2205F2162B9DE61E6E0833B232295357F2B941C7AF42E11EAFE524E37D3C70093913E2CA417F2D905DF87330F2E231B9BEF3203BB901D4196B2E5592CA3502E8D88EC06CFBAD59A4669F4AB810CF855ECC36396693145424C416E864B17BFA2CBAB335132FBDFB9FD394FB1CF321914AA933F2A21F82FD7AEDFEF392163775F21E56D1B1C757B715327080BD210453D6648FE70ADA66725985C3C4BC0EB95745BF775B60ADC5C61EE22934021C8D0DD151365A87AA21A92E8DC45747AF1B5F62F706D550832327E03DBEF0B005DD67E3F591A295197062800110B34A01B255AA1D7250691C684A386160A59CA08A984BFAEC3C9F7BCA93ED8FCF6F46453AB483B3EFAC88C3CAAF3CD2A95E7D0615F1CEE5C0DBADB7A97530B704FECAB0FFA6243EE20FA8D61834216C3A42CBE815E38E06C4F2CC7803DB236A05ED14E9BF7D21104B493F78BCFF7C361EFFAA41C8A4E99419D4ED8FA98385C6721458919BA5FAC34\",\n" +
                "    \"publicKeyFingerprint\": \"3e70356e5a17b769009bc099c2dcae4b6b82f482a3f59711715d683f7e6fd167\",\n" +
                "    \"encryptedKey\": \"AAD08D20380DC188FF0C36E7725D3C2158F6152A113D07E17DDE79326FA464FE2ECFAC2952B93FC8FD3F5DA618E01C97D2A5A4A159A537384D9AF7754923F9B9E363C8400434753C65747AA916D964E0E3A815B92DCFC605A8F9A4B53FE585B9D5DF5B9F09B07C7ECA10D8A25CD8AF6832001C00EFA8C0AA6B79907FC732AFA677DA47D80E778C960AB1C2741D44EAF25A1B434E327ECA186C93C45AED33FB3D047ADFB9C493A4417DC8645B8CFA731B98C0930752B3B5AC1BD8EC5C5B94B46BAA2AAF13F4BDF4E6B02ABFFD9E4EF8DBA6BBE65BAFDCF13ED9064A3FE680DBFFFAB45365C5920C6341C9B68C5053F68195860258710FCC0F9EC441D92CBA65BA\",\n" +
                "    \"oaepHashingAlgorithm\": \"SHA256\",\n" +
                "    \"iv\": \"33CC701395B23592B48326F67984D618\",\n" +
                "    \"panUniqueReference\": \"FSHRMC0000171740c1e6896893b74619836a21a20a543b64\",\n" +
                "    \"deviceName\": \"Test Phone\",\n" +
                "    \"formFactor\": \"PHONE\",\n" +
                "    \"isoDeviceType\": \"14\",\n" +
                "    \"osName\": \"ANDROID\",\n" +
                "    \"osVersion\": \"4.4\",\n" +
                "    \"paymentTypes\": [\n" +
                "      \"NFC\",\n" +
                "      \"DSRP\"\n" +
                "    ],\n" +
                "    \"storageTechnology\": \"DEVICE_MEMORY\",\n" +
                "    \"recommendedDecision\": \"REQUIRE_ADDITIONAL_AUTHENTICATION\",\n" +
                "    \"recommendationStandardVersion\": \"1.0\",\n" +
                "    \"deviceScore\": 1,\n" +
                "    \"accountScore\": \"1\",\n" +
                "    \"recommendationReasons\": [\n" +
                "      \"ACCOUNT_TOO_NEW\",\n" +
                "      \"TOO_MANY_RECENT_ATTEMPTS\",\n" +
                "      \"OUTSIDE_HOME_TERRITORY\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        memberName = "requestId";

        System.out.println("memberName = " + StringUtil.getAsString(requestData, memberName));
        System.out.println("memberName = " + StringUtil.getAsString(jsonText, memberName));
        System.out.println("memberName = " + StringUtil.getAsString(jsonText2, memberName));



        String getText = "{\n" +
                "  \"cardholderInfo\": {\n" +
                "    \"primaryAccountNumber\": \"4102321250000006\",\n" +
                "    \"expirationDate\": {\n" +
                "      \"month\": \"12\",\n" +
                "      \"year\": \"2020\"\n" +
                "    },\n" +
                "    \"billingAddress\": {\n" +
                "      \n" +
                "    },\n" +
                "    \"highValueCustomer\": false\n" +
                "  },\n" +
                "  \"riskInformation\": {\n" +
                "    \"walletProviderAccountScore\": \"5\",\n" +
                "    \"walletProviderDeviceScore\": \"3\",\n" +
                "    \"deviceIMEI\": \"17\",\n" +
                "    \"deviceSerialNumber\": \"97\",\n" +
                "    \"deviceTimeZone\": \"Europ\",\n" +
                "    \"deviceTimeZoneSetting\": \"NETWORK_SET\",\n" +
                "    \"simSerialNumber\": \"97\",\n" +
                "    \"walletProviderPANAge\": \"0\",\n" +
                "    \"userAccountAge\": \"999\",\n" +
                "    \"walletAccountAge\": \"999\",\n" +
                "    \"walletProviderReasonCodes\": \"A0\"\n" +
                "  },\n" +
                "  \"tokenInfo\": {\n" +
                "    \"token\": \"4551360150000027\",\n" +
                "    \"tokenType\": \"HCE\",\n" +
                "    \"tokenStatus\": \"ACTIVE\",\n" +
                "    \"tokenExpirationDate\": {\n" +
                "      \"month\": \"12\",\n" +
                "      \"year\": \"2023\"\n" +
                "    },\n" +
                "    \"numberOfActiveTokensForPAN\": 1,\n" +
                "    \"numberOfInactiveTokensForPAN\": 0,\n" +
                "    \"numberOfSuspendedTokensForPAN\": 0\n" +
                "  }\n" +
                "}";

        String pan = "primaryAccountNumber";
        String exp = "expirationDate";
        System.out.println("primaryAccountNumber = " + StringUtil.getAsString(getText, pan));

        String jsonExp = StringUtil.getAsString(getText, exp);
        System.out.println("expirationDate = " + jsonExp);

        String month = StringUtil.getAsString(jsonExp, "month");
        String year = StringUtil.getAsString(jsonExp, "year").substring(2, 4);
        exp = year + month;
        System.out.println("month = " + month);
        System.out.println("year = " + year);
        System.out.println("exp = " + exp);


        Map<String, String> parseDecrypted = parseDecrypted(getText);
        System.out.println(parseDecrypted);
        System.out.println( parseDecrypted.get("pan") );
        System.out.println( parseDecrypted.get("expdt") );


        System.out.println("------------------------------");
        String stan = getStan(jsonText, "requestId", "correlationId");
        System.out.println(stan);



        System.out.println("==============================");

        String messageJson = "{\"originator\":\"VTS\",\"messageHistoryId\":93201,\"jmsTokenCreateNotificationDto\":{\"messageReasonCode\":\"3700\",\"dateTimeOfEvent\":1521456287000,\"panReferenceID\":\"V-3017192484534844832252\",\"walletAccountEmailAddressHash\":\"19F6683D83B8A5236E6A9599EB167D46E593ECBCF4717225415EB9F5A8256272\",\"clientWalletAccountID\":\"uGrOxzwW2ghVx1nuoC2Fnwko\",\"panSource\":\"KEY_ENTERED\",\"deviceInfo\":{\"deviceID\":\"oUL7aJtruSi4rUO_WyMe1oF3\",\"deviceLanguageCode\":\"eng\",\"osType\":\"ANDROID\",\"osVersion\":\"5.1.1\",\"deviceType\":\"MOBILEPHONE_OR_TABLET\",\"deviceManufacturer\":\"samsung\",\"deviceBrand\":\"samsung\",\"deviceModel\":\"SM-J500FN\",\"deviceName\":\"(test-1) samsung - SM-J500FN\",\"deviceIPAddressV4\":\"91.197.217.52\",\"tokenProtectionMethod\":\"SOFTWARE\",\"storageTechnology\":\"SOFTWARE\"},\"encryptedData\":{\"cardholderInfo\":{\"primaryAccountNumber\":\"4102321250000006\",\"expirationDate\":{\"month\":\"12\",\"year\":\"2020\"}},\"tokenInfo\":{\"token\":\"4551360150000027\",\"tokenType\":\"HCE\",\"tokenStatus\":\"ACTIVE\",\"tokenExpirationDate\":{\"month\":\"12\",\"year\":\"2023\"},\"numberOfActiveTokensForPAN\":\"1\",\"numberOfInactiveTokensForPAN\":\"0\",\"numberOfSuspendedTokensForPAN\":\"0\"}},\"termsAndConditions\":{\"id\":\"73208cd0469c4e08a8b8b3c72b41ae13\",\"date\":1521456286000},\"tokenReferenceID\":\"DNITHE301736046984008715\",\"tokenRequestorID\":\"40010030273\",\"eventType\":\"TOKEN_CREATED\",\"eventID\":\"f42ecc499121c49ea9f316a7a2288201\"}}";
        String eventID = getStan(messageJson, "eventID");
        System.out.println("eventID = " + eventID);

    }

    static Map<String, String> parseDecrypted(String decrypted) {
        Map<String, String> map = new HashMap<>();

        map.put("pan", StringUtil.getAsString(decrypted, "primaryAccountNumber"));

        String jsonExp = StringUtil.getAsString(decrypted, "expirationDate");
        String month = StringUtil.getAsString(jsonExp, "month");
        String year = StringUtil.getAsString(jsonExp, "year").substring(2, 4);
        map.put("expdt", year + month);

        return map;
    }

    static String getStan(String jsonText, String... memberNames) {
        for (String memberName: memberNames) {
            String requestId = StringUtil.getAsString(jsonText, memberName);
            if (requestId!=null) return "STAN: '" + requestId.replace("\"", "") + "' ";
        }
        return "STAN: '" + StringUtil.randomUUID() + "' ";
    }
}
