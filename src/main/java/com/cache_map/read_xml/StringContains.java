package com.cache_map.read_xml;

public class StringContains {

    public static void main(String[] args) {
        String messageType1 = "TOKEN_CHANGED_EXCEPTION";
        String messageType2 = "CARD_DATA_UPDATE_EXCEPTION";
        String messageType3 = "TOKEN_INFO_EXCEPTION";
        String messageType4 = "TOKEN_STATUS_UPDATED";
        String messageType5 = "SEND_NOTIFICATION_TO_CUSTOMER";
        String messageType6 = "CARD_TOKENIZED";
        String messageType7 = "TOKEN_CREATED";

//        boolean isExceptionMessageType = messageType1.contains("_EXCEPTION");
        System.out.println( isNotExceptionMessageType(messageType1, "_EXCEPTION") );
        System.out.println( isNotExceptionMessageType(messageType2, "_EXCEPTION") );
        System.out.println( isNotExceptionMessageType(messageType3, "_EXCEPTION") );
        System.out.println( isNotExceptionMessageType(messageType4, "_EXCEPTION") );
        System.out.println( isNotExceptionMessageType(messageType5, "_EXCEPTION") );
        System.out.println( isNotExceptionMessageType(messageType6, "_EXCEPTION") );
        System.out.println( isNotExceptionMessageType(messageType7, "_EXCEPTION") );
    }

    static boolean isExceptionMessageType(String messageType, String like) {
        return messageType.contains(like);
    }

    static boolean isNotExceptionMessageType(String messageType, String like) {
        return !messageType.contains(like);
    }
}
