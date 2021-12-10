package com.generic;

/**
 * @see https://javatalks.ru/topics/6044
 */

public class StringTest {

    public static void main(String[] args) {
//        String tokenrequestor_id = "40010030273";
        String tokenrequestor_id = "50110030273";

//        char firstChar = tokenrequestor_id.charAt(0);
//        switch ( firstChar ) {
//            case '4':
//                System.out.println( "V" );
//                break;
//            case '5':
//                System.out.println( "M" );
//                break;
//            default:
//                System.out.println( "not equals" );
//                break;
//        }

        System.out.println( getIps(tokenrequestor_id) );
    }

    static String getIps(String tokenRequestorId) {
        char V = '4';
        return V==tokenRequestorId.charAt(0) ? "V" : "M";
    }
}
