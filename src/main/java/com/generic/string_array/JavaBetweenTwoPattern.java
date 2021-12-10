package com.generic.string_array;

import org.apache.commons.lang3.StringUtils;

/**
 * @see https://kodejava.org/how-do-i-find-text-between-two-strings
 */
public class JavaBetweenTwoPattern {

    private static final String STAN = "STAN: '3fd4372a-0dea-4fb4-9b5f-f0697a92541f'";

    public static void main(String[] args) {
        // ////////////////////// #1.
//        String stan = extractStan(STAN);
//        System.out.println(stan);

//        System.out.println(extractStan(null));
//        System.out.println(extractStan(""));
//        System.out.println(extractStan("3fd4372a-0dea-4fb4-9b5f-f0697a92541f"));
//        System.out.println(extractStan("STAN: 3fd4372a-0dea-4fb4-9b5f-f0697a92541f"));
//        System.out.println(extractStan("STAN: '3fd4372a-0dea-4fb4-9b5f-f0697a92541f'"));

        System.out.println();

        System.out.println("1.    " + extractStan2(null));
        System.out.println("2.    " + extractStan2(""));
        System.out.println("3.    " + extractStan2("      "));
        System.out.println("4.    " + extractStan2("''"));
        System.out.println("5.    " + extractStan2("'      '"));
        System.out.println("6.    " + extractStan2("'"));
        System.out.println("7.    " + extractStan2("3fd4372a-0dea-4fb4-9b5f-f0697a92541f"));
        System.out.println("8.    " + extractStan2("STAN: 3fd4372a-0dea-4fb4-9b5f-f0697a92541f"));
        System.out.println("9.    " + extractStan2("STAN: '3fd4372a-0dea-4fb4-9b5f-f0697a92541f'"));
        System.out.println("10.   " + extractStan2("STAN: \"3fd4372a-0dea-4fb4-9b5f-f0697a92541f\""));
        System.out.println("11.   " + extractStan2("12345678"));
        System.out.println("12.   " + extractStan2("12345678-1234-1234-1234-1234567890"));
        System.out.println("13.   " + extractStan2("12345678-1234-1234-1234-1234567890ab"));
        System.out.println("14.   " + extractStan2("12345678-1234-1234-1234-1234567890abcd"));

//        String payload = "{\"operatorID\":\"operator\",\"operationReason\":\"bla bla bla\",\"operationType\":\"CALL_CENTER_ACTIVATION\",\"activationCode\":\"72STMHRM\",\"stan\":\"977f67e9-1dd0-4c2d-9dfd-b5f620572b6c\"}";
//        String getStan = extractStan3(payload);
//        System.out.println("payload: " + payload);
//        System.out.println("stan: " + getStan);

        System.out.println();
        System.out.println();
        System.out.println();

        String requestId = "55af1174-5e3a-4d5c-9c94-80327450dc62";

//        String msgRawIn = "55af1174-5e3a-4d5c-9c94-80327450dc62";

        String msgRawIn = "55af1174-5e3a-4d5c-9c94-80327450dc62\n" +
                "Address: http://localhost:8080/visa-api3-server-1.4.2/v1/retrieveStepUpMethods\n" +
                "Http-Method: POST\n" +
                "Content-Type: application/json\n" +
                "Payload: {\"otpReason\":\"PROVISIONING\",\"panSource\":\"KEY_ENTERED\",\"otpMaxReached\":false,\"tokenReferenceID\":\"DNITHE000302000000000082\",\"panReferenceID\":\"V-3017192484534844832252\",\"deviceInfo\":{\"deviceID\":\"04312E7B342C80014328036811932950DA075B1C4DC45F7C\",\"deviceType\":\"MOBILE_PHONE\",\"deviceNumber\":\"380507534412\",\"deviceName\":\"MY BEST PHONE\",\"deviceLanguageCode\":\"en\",\"deviceIDType\":\"SecureElement\",\"osBuildID\":\"TU84M\",\"osVersion\":\"8.1\",\"osType\":\"Android\",\"deviceManufacturer\":\"Samsung\",\"deviceBrand\":\"Nexus\",\"deviceModel\":\"ME571KL NA K009\",\"deviceLocation\":\"+37/-121\",\"deviceIPAddressV4\":\"10.0.1.1\",\"locationSource\":\"CELLULAR\",\"tokenProtectionMethod\":\"TRUSTED_EXECUTION_ENVIRONMENT\"},\"encryptedData\":\"eyJraWQiOiJGQVNUVEFDSyIsImN0eSI6IkpXRSIsInR5cCI6IkpPU0UiLCJhbGciOiJQUzI1NiJ9.ZXlKMGVYQWlPaUpLVDFORklpd2laVzVqSWpvaVFUSTFOa2REVFNJc0ltbGhkQ0k2TVRVMU16QTVOakk0Tml3aVlXeG5Jam9pVWxOQkxVOUJSVkF0TWpVMklpd2lhMmxrSWpvaVJrRlRWRlJCUTBzaWZRLkptVGNlMFQ1OHl0QnZhb09NZmwwdFI4MURCZFhHbkNNY0dFQ3hMeWdRT1NGd1BmWm5SSk83bjNOMlFsTGNrU3RDR1BBYmdtVmVCa2psOWQtenM2RDlJTWhoLTF3NVVQMkJ0QTkxUzlIWkdXREtzcHdOdFM2cktfRWVnUmFYMTlWdXQ2SkRUcmlfZTlHVl9GOUdIM2E4ZW45cy12d0RXcWk3YXdXSG10YjBOOTBfVW9OQUo5NzIxSmtrcGhJMGFkVkpwZDlWcVdYT2NFR2djOGFMaW5XTmlJRl8xRTdRcUpIYU45aDJZOEtRalpYbWdnQWVJckhrVVYyajZhTURRS050VGZBQnhydC1hWnQya2dnWU5oSG9EOFpKUFctNFFxR2N3VGZTbi03cUR3VDJTVFROVm9zR01HRkVGWXF0ZTRITl9hNkNYTVZ5YkhpbFV3QUdFdFZvUS4zWWN6VU1jb3oxTDVlQlZmLndXM0xCSkdtRlVaUWYxTWc3UVVfeXNmSGdhcVY1ekY0MkJKNHlCUVhILWZGd2ZzUjNuSjNmMVZtRmVfOXBBNWZqa0JoWXVoRGN4U0lSdUJnakxZc3N5eXNzUTlnR3U0UXkyYmVpaC1jcDNWN25PUVJDQTY0dks2cTYwRkI4SWI1M2daWU15SUdmZVdJM3RPcm1SMmtxcXhWUl9lZU1STENoeG5zOUhTaGI1TmFKSzhObWRQY0Z0OVJoNHAzZHBaUnFpWXV6NmhRMWNoRm96bzN2ZFNtREN3cDdlSzdMT1FkUC1nM2g3c2xEZE9ycG9EN3cxVVplUnd2dFJscExrUFJpUFZpWlNzZU9ZQkRzZXdzb0FscmhYeExzaEhPYkgtNG40YlJ2dnk0ZkZwVjVzTXlnaUpHVUNRbnZoS01yOXdaZDc0R29QSnBFU1hyZmFIaU90RnlWMWhVSmtpVnk5VTBRSHVLS1Q5UEQzb09uU012OXphRDlxMGx5ZW04S2hBdWZpRngzeHdraXRYTHlOLWw1UTgySjVzNjM4Tk9EamJkMXpTOWNrUWs1bWcyVnhMNVREQ0NhUjZib3g2VFh3ejhNUzFQckZ4Sk9iRHhsTmh5eWZnYk81U3dDSVpESEJuY0Mwazkxb0RJRzdvSlNaeUFKS1NIcDlpY25qMUJDSHNhaWxuRmdldUxmaDZGaGhyd2t1WmZEZEhEaDlqMzhnSFcxeXRlS2hHbnBMb2MyRnpNMVk4dGJTMlB3OXJkN0VxOFZGQjZQV2ZCdElHN3QzbDViSTRMX1ZNN3JuX1pHOEkwTF84cHN6bkVBQmd6TlZ0OTJtYUlMZUJseHV4OUZ4cGotU2F5Z2NjX0lQRE8tVkwzNng3dGlfemE4cGNzeVY3bkFFTEVhckhCTmVHWUlyMHZXQXFPaHlyakp5M0FNMzVnT09ZVDA2Q245MWdhZEh0YzVvTzY1VFQ1bkRhclBqNjRlMmFGTTRsRjl6bm5TLXR5QlJCN2RnOHJoNTRGWWdMQlo2N2NBaHdZYVJGSGs3aUpZWEVERllBT2EycEN3cnNQM3lXOGpSRnJVTmp3am4yZDQ1WmlhYkkzNG1LcGVmRGI2SEVpRmg5bEZaVDhBcXZ5bU5QLWlncXhqWkZXT0E4eVdTZ093QXlha1drUjFkLVhIQmMzMFVla2FYbjV4Z0FKSFZZeEVweXYzMTRwbmd4aXYzOEk5WEdfamRVSXl5RWRSZUMzRDhTSXhoNVBfZUhyd2dhLTk5ZTlnRlZwMl9UT1piVjFFZzZ1S0ZPMDNwUGVuZ3dwVklGMU5sV2hkMEhWVmpuQzh6cXhId1FLTXNQSHZuSnJCczZnQWJUbWZPMnk0Q2pkNXpoWlN4Q1NvT2d2NmpoVDZselhYZTFOMGNwZDJSUkJSRlBEQ3R2cDU5NERwX1VDeWJzWndVVWNrVUV3QXotSlF4UnFpVVNtUGF6aTlURFNHVDF5dGJNZmhkcEpCQ095NGN5VWZzNmxFdjlHeDEwUXFRWU9NeThFWUlBdm5CdlNOQlNxWjdMMmRDU3Y2X01OeFg4VEZoV0xxMjM4R1ZrRGY0dEFZaXdtSHNhOV9WM2VxMVUxZDBWRFJIVWhYZEFLQk5iS0MxUDNXX3NValpFQzNHNjFGSThnOFE1VDZOczV4WlgzbEZ4VVVjRWFiWWFsdFVnMmUwY2xYZEpiVXkxZmtJRnpOdm1EUlkxUzJnX2tpWGQ4aHBWSkJrcldQWnZqTnk5Skh3Z2JpSk5KbU1mV0hwSXloRVBNZUhsdlFDcWYzeno2dG80R2xsUDJ0ZWlVcm1jWVpoU2Q4dE5fcEtodEQtWHpXd1doWWJKd0hlY1QxaUNCU25lNDh0TEhEWDNjZHdoQi5aMzVYUV9lZ0hiS2M4VlIwLWJraWFB.DUW_7z5yqfN2UTvwNYSVi43Ytd9o4AOz-f1qJfbZv1KHjLCm3ZcwIwWawtui-05tEux9VrzIK7N_fo0Z66VIHS7pMY3dlp8j-0CgNYiS7ki9qtHQ5k7HPxav-_mQ2jom5M6qyYOQ4Ym7fQM_09jL-WOaOthnJN9Eo-rs2C8NrF8m4anVNoiV26vn2ix1-i10SZVi7HttO89MH3STLcSH9W1JzvlEDWFTbJo3HVE8AyKmpXRvqYPU_SThO_GLMo_OW4eJchCFh0h6nXNVlJnLqUYwlXTul1E1Sgy7fS6mxzWfMSRjyjS3zZvaAPwq063vrFfqRiKW_SYaqmkZ--ssNg\",\"clientWalletAccountID\":\"6Gt02SAokOGBxPoKPuP6yVpV\",\"tokenRequestorID\":\"40010030273\"}";

        msgRawIn = msgRawIn.replace("55af1174-5e3a-4d5c-9c94-80327450dc62", "");
        //if (StringUtils.isNotBlank(requestId)) msgRawIn.replace(requestId, ""); //FIXME: #FAS-13 (bugfix_FAS-13.3)

        System.out.println(requestId);

        System.out.println();

        System.out.println(msgRawIn);


        // ////////////////////// #2.

        String msg_raw_in1 = "STAN: '4f8985e5-372e-4554-81b6-23db1d1b6af4' \n" +
                "Address: http://localhost:8080/bank-server-1.5.2/tokenInfo\n" +
                "Http-Method: POST\n" +
                "Content-Type: application/xml\n" +
                "Payload: {\"requestId\":\"5f8985e5-372e-4554-81b6-23db1d1b6af5\",\"panInternalId\":\"CardID3556\",\"ips\":\"M\",\"auditInfo\":{\"userId\":\"operator\",\"userName\":\"Testovenko\"},\"refreshDeletedFromIps\":false}";

        System.out.println("msg_raw_in1    " + extractStan3(msg_raw_in1));

        String msg_raw_in2 = "null\n" +
                "Payload: {\"requestId\":\"4f8985e5-372e-4554-81b6-23db1d1b6af4\",\"auditInfo\":{\"organization\":\"BANK ALFA\",\"userName\":\"Testovenko\",\"userId\":\"operator\",\"phone\":\"0-800-50-20-50\"},\"tokenUniqueReference\":\"DSHRMC0000173160e32d9b4663e74cb395d5c402013a6553\",\"excludeDeletedIndicator\":true,\"TokenUniqueReference\":\"DSHRMC0000173160e32d9b4663e74cb395d5c402013a6553\",\"ExcludeDeletedIndicator\":true,\"AuditInfo\":{\"organization\":\"BANK ALFA\",\"userName\":\"Testovenko\",\"userId\":\"operator\",\"phone\":\"0-800-50-20-50\"}}";

        System.out.println("msg_raw_in2    " + extractStan3(msg_raw_in2));
    }

    private static String extractStan(String source) {
        if (StringUtils.isNotBlank(source)) {
            return StringUtils.substringBetween(source, "'", "'");
        }
        return null;
    }

    private static String extractStan2(String source) {
        int stanLength = 36;
        if (StringUtils.isNotBlank(source)) {
            String substringBetween1 = StringUtils.substringBetween(source, "'", "'");
            String substringBetween2 = StringUtils.substringBetween(source, "\"", "\"");
            String substringBetween = StringUtils.isNotBlank(substringBetween1) ? substringBetween1 : substringBetween2;
            String replaceAll = source.replaceAll(" ", "").replaceAll(":", "").replaceAll("stan", "").replaceAll("STAN", "");
            String stan = StringUtils.isNotBlank(substringBetween) ? substringBetween : replaceAll;
            return (stanLength < stan.length()) ? stan.substring(0, stanLength) : stan.substring(0, stan.length());
        }
        return null;
    }

    private static String extractStan3(String source) {
        if (StringUtils.isNotBlank(source)) {
//            return StringUtils.substringBetween(source, "\"stan\":\"", "\"");
            String substringBetween1 = StringUtils.substringBetween(source, "STAN: '", "'");
            String substringBetween2 = StringUtils.substringBetween(source, "STAN: \"", "\"");
            return StringUtils.isNotBlank(substringBetween1) ? substringBetween1 : substringBetween2;
        }
        return null;
    }

}
