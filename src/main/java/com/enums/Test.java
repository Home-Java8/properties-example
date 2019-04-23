package com.enums;

public class Test {

    public static void main(String[] args) {
        TokenEventStatus tokenEventStatus = TokenEventStatus.ACTIVATE;
        System.out.println("tokenEventStatus = " + tokenEventStatus);
        System.out.println("visaApi3TokenEventStatus = " + TokenEventStatusConverter.lightConvert(tokenEventStatus));

        VisaApi3TokenEventStatus visaApi3TokenEventStatus = VisaApi3TokenEventStatus.CALL_CENTER_ACTIVATION;
        System.out.println("visaApi3TokenEventStatus = " + visaApi3TokenEventStatus);
        System.out.println("tokenEventStatus = " + TokenEventStatusConverter.lightConvert(visaApi3TokenEventStatus));
    }

}
