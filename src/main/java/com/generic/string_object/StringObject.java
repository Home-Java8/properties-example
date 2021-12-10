package com.generic.string_object;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class StringObject {

    public static void main(String[] args) {
        JmsLifecycleTokenResponseDto response = new JmsLifecycleTokenResponseDto();
        response.setRequestId("3f72d9e0-20f8-4fea-a779-e152f611b39f");

        String sbShowUpdateUrl = "tokens[0].tokenRefId=DTC1MC0000171740bf9605c539fe4c418343322319&tokens[0].tokenRequestorId=50110030273&tokens[1].tokenRefId=DTC1MC0000171740bf9605c539fe4c418343322319&tokens[1].tokenRequestorId=50110030273&tokens[2].tokenRefId=DTC1MC0000171740bf9605c539fe4c418343322319&tokens[2].tokenRequestorId=50110030273";

        response = showUpdateUrlToResponse(response, sbShowUpdateUrl);
        System.out.println(response);
    }

    static JmsLifecycleTokenResponseDto showUpdateUrlToResponse(JmsLifecycleTokenResponseDto response, String sbShowUpdateUrl) {
        response.setTokensInfo(new ArrayList());
        String[] showUpdates = sbShowUpdateUrl.split("&");
        for (int count=0; count<showUpdates.length; count++) addResponse(response, showUpdates, "tokens[" + count + "].tokenRefId=", "tokens[" + count + "].tokenRequestorId=");
        return response;
    }

    static void addResponse(JmsLifecycleTokenResponseDto tokensInfo, String[] showUpdates, String tokenRefId, String tokenRequestorId) {
        JmsTokenInfoEventRefDto tokenInfo = new JmsTokenInfoEventRefDto();
        for (String showUpdate : showUpdates) {
            if (showUpdate.contains(tokenRefId)) tokenInfo.setTokenRefId(showUpdate.replace(tokenRefId, ""));
            if (showUpdate.contains(tokenRequestorId)) tokenInfo.setTokenRequestorId(showUpdate.replace(tokenRequestorId, ""));
        }
        if (StringUtils.isNotBlank(tokenInfo.getTokenRefId()) || StringUtils.isNotBlank(tokenInfo.getTokenRequestorId())) tokensInfo.addTokenInfo(tokenInfo);
    }
}
