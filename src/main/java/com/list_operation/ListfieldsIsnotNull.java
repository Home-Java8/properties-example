package com.list_operation;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListfieldsIsnotNull {

    public static void main(String[] args) {
        List<String> emptyParams = getEmptyParams();
        if (!emptyParams.isEmpty()) System.out.println(emptyParams);

        // ////////////
        emptyParams = getEmptyParams(new Object[]{"A","Aaa"},
                new Object[]{"B",null},
                new Object[]{"C",""},
                new Object[]{"D",0},
                new Object[]{"F",false},
                new Object[]{"E",new Date()},
                new Object[]{"I",new TokenInfo()});
        if (!emptyParams.isEmpty()) System.out.println(emptyParams);

        // ////////////
        TokenExpirationDate tokenExpirationDate = new TokenExpirationDate();
        tokenExpirationDate.setMonth("01");
        tokenExpirationDate.setYear("2023");

        TokenInfo tokenInfo = new TokenInfo();
//        tokenInfo.setToken("4321098765432109");
//        tokenInfo.setTokenType("HCE");
        tokenInfo.setTokenStatus("ACTIVE");
//        tokenInfo.setTokenActivationDate(new Date());
        tokenInfo.setTokenExpirationDate(tokenExpirationDate);

        emptyParams = getEmptyParams(new Object[]{"token",tokenInfo.getToken()},
                new Object[]{"tokenType",tokenInfo.getTokenType()},
                new Object[]{"tokenStatus",tokenInfo.getTokenStatus()},
                new Object[]{"tokenActivationDate",tokenInfo.getTokenActivationDate()},
                new Object[]{"month",tokenInfo.getTokenExpirationDate().getMonth()},
                new Object[]{"year",tokenInfo.getTokenExpirationDate().getYear()});
        if (!emptyParams.isEmpty()) System.out.println(emptyParams);
    }

    static List<String> getEmptyParams(Object... params) {
        List<String> emptyParams = new ArrayList<>();
        for (Object oParam: params) {
            Object[] oParams = (Object[]) oParam;
            String key = String.valueOf(oParams[0]);
            Object value = oParams[1];
            if (value==null) emptyParams.add(key);
            else if (isString(value) && StringUtils.isBlank(String.valueOf(value))) emptyParams.add(key);
        }
        return emptyParams;
    }

    static boolean isInteger(Object obj) {
        if (obj==null) {
            return false;
        }
        if(obj instanceof Integer) {
            return true;
        } else {
            try {
                Integer.parseInt(obj.toString());
            } catch(NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }

    static boolean isString(Object obj) {
        if (obj==null) {
            return false;
        }
        if(obj instanceof String) {
            return true;
        }
        return false;
    }

    static boolean isDate(Object obj) {
        if (obj==null) {
            return false;
        }
        if(obj instanceof Date) {
            return true;
        }
        return false;
    }
}

class TokenInfo {
    private String token;

    private String tokenType;

    private String tokenStatus;

    private Date tokenActivationDate;

    private TokenExpirationDate tokenExpirationDate;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public Date getTokenActivationDate() {
        return tokenActivationDate;
    }

    public void setTokenActivationDate(Date tokenActivationDate) {
        this.tokenActivationDate = tokenActivationDate;
    }

    public TokenExpirationDate getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(TokenExpirationDate tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }
}

class TokenExpirationDate {
    private String month;

    private String year;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}