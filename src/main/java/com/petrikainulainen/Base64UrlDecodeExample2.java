//package com.petrikainulainen;
//
//import org.apache.commons.codec.Charsets;
//import org.apache.commons.codec.binary.Base64;
//import org.bouncycastle.util.encoders.Hex;
//
///**
// * @see https://webmail.adm.tools/?_task=mail&_caps=pdf%3D1%2Cflash%3D0%2Ctiff%3D0%2Cwebp%3D1&_uid=1589&_mbox=INBOX&_action=show
// */
//class Base64UrlDecodeExample2 {
//
//    // Base64 URL Decoding
//    public static void main(String[] args) {
//        String b64 = "UG9saW5hJ3MgQXBwbGUgV2F0Y2g.";
//        System.out.println("b64URL" + b64);
//
//        System.out.println(Base64.decodeBase64(b64));
//        System.out.println(Base64.encodeBase64(b64.getBytes()));
//
//        Hex.toHexString(b64.getBytes());
//    }
//
//}
