package com.enums;

public enum VisaApi3TokenEventStatus {
    CALL_CENTER_ACTIVATION,
    UPDATE_PAN,
    UPDATE_EXP,
    UPDATE,
    SUSPEND,
    RESUME,
    DELETE;


    public boolean isActive() {
        return this == CALL_CENTER_ACTIVATION;
    }

    public boolean isResume(){
        return this == RESUME;
    }

    public static VisaApi3TokenEventStatus getInstance(String name) {
        try {
            return VisaApi3TokenEventStatus.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
