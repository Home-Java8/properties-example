package com.enums;

public class TokenEventStatusConverter {

    public static VisaApi3TokenEventStatus lightConvert(TokenEventStatus tokenEventStatus) {
        if (tokenEventStatus!=null) return VisaApi3TokenEventStatus.values()[tokenEventStatus.ordinal()];
        return null;
    }

    public static TokenEventStatus lightConvert(VisaApi3TokenEventStatus tokenEventStatus) {
        if (tokenEventStatus!=null) return TokenEventStatus.values()[tokenEventStatus.ordinal()];
        return null;
    }
}
