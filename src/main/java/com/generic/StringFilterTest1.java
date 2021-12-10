package com.generic;

public class StringFilterTest1 {

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

    public static void main(String[] args) {
//        System.out.println(HEASDERS);

//        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String[] arrHead = HEASDERS.split("=\"");
        System.err.println(arrHead.length);
        System.err.println();
        System.err.println();

        System.err.println("0.\n--");
        System.err.println(arrHead[0]);

        System.err.println("1.\n--");
        System.err.println(arrHead[1]);

        System.err.println("2.\n--");
        System.err.println(arrHead[2]);


//        for (String head: arrHead) {
//            System.err.println();
//            System.err.println(head);
//        }
    }

}
