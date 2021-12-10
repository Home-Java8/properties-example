package com.cache_map.ExpaireDate;

public enum DateFormatEnum {
    DATETIME("dd.MM.yyyy HH:mm:ss"),
    DATETIME_MILLISECONDS("dd.MM.yyyy HH:mm:ss.SSS"),
    DATETIME_NO_SECONDS("dd.MM.yyyy HH:mm"),
    DATETIME_WITHOUT_SEPARATION("yyyyMMddHHmmss"),
    EXPIRE_DATE("MM/yy"),
    EXPIRATION_DATE("MMyy"),
    DATE("dd.MM.yyyy"),
    CARD_ISSUE_DATE("ddMMyyyy"),
    SLASH_DATE("dd/MM/yyyy"),
    RNS_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ"),
    MDES_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"),
    BOG_DATE_FORMAT("yyyy-MM-dd'T'HH:mm:ssZ"),
    FEEDBACK_DATE_FORMAT("yyyy-MM-dd'T'HH:mm:ss.Z"),
    MINI_STATEMENT_DATE_FORMAT("yyyy-MM-dd HH:mm:ss"),
    MINI_STATEMENT_DATE_FORMATT("yyyy-MM-dd'T'HH:mm:ss"),
    BOG_DATE("MMyy"),
    PROVUS_DATE("yyMM"),
    TAV_DATE("MMyy"),
    TRANSACTION_HISTORY_FORMAT("yyyy-MM-dd'T'HH:mm:ss'Z'"),
    VTS_DATETIMEOFEVENT_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSX"),
    UKRCARD_DATETIMEOFEVENT_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    private String value;

    DateFormatEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
