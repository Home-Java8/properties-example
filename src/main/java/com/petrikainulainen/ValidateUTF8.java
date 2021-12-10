package com.petrikainulainen;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @see https://stackoverflow.com/questions/28890907/implement-a-function-to-check-if-a-string-byte-array-follows-utf-8-format
 */

public class ValidateUTF8 {

    public static void main(String[] args) {
        byte[] invalidUTF8Bytes1 = new byte[]{ (byte)0b10001111, (byte)0b10111111 };
        byte[] invalidUTF8Bytes2 = new byte[]{ (byte)0b10101010, (byte)0b00111111 };
        byte[] validUTF8Bytes1 = new byte[]{ (byte)0b11001111, (byte)0b10111111 };
        byte[] validUTF8Bytes2 = new byte[]{ (byte)0b11101111, (byte)0b10101010, (byte)0b10111111 };
        byte[] validUTF8Bytes3 = new byte[]{ (byte)0x7e };

        System.out.println("invalidUTF8Bytes1 = " + isUTF8(invalidUTF8Bytes1));
        System.out.println("invalidUTF8Bytes2 = " + isUTF8(invalidUTF8Bytes2));
        System.out.println("validUTF8Bytes1 = " + isUTF8(validUTF8Bytes1));
        System.out.println("validUTF8Bytes2 = " + isUTF8(validUTF8Bytes2));
        System.out.println("validUTF8Bytes3 = " + isUTF8(validUTF8Bytes3));

        System.out.println();

        System.out.println("invalidUTF8Bytes1 = " + validUTF8(invalidUTF8Bytes1));
        System.out.println("invalidUTF8Bytes2 = " + validUTF8(invalidUTF8Bytes2));
        System.out.println("validUTF8Bytes1 = " + validUTF8(validUTF8Bytes1));
        System.out.println("validUTF8Bytes2 = " + validUTF8(validUTF8Bytes2));
        System.out.println("validUTF8Bytes3 = " + validUTF8(validUTF8Bytes3));
    }

    static final boolean isUTF8(final byte[] inputBytes) {
        final String converted = new String(inputBytes, StandardCharsets.UTF_8);
        final byte[] outputBytes = converted.getBytes(StandardCharsets.UTF_8);
        return Arrays.equals(inputBytes, outputBytes);
    }

    static boolean validUTF8(byte[] input) {
        int i = 0;
        // Check for BOM
        if (input.length >= 3 && (input[0] & 0xFF) == 0xEF
                && (input[1] & 0xFF) == 0xBB & (input[2] & 0xFF) == 0xBF) {
            i = 3;
        }

        int end;
        for (int j = input.length; i < j; ++i) {
            int octet = input[i];
            if ((octet & 0x80) == 0) {
                continue; // ASCII
            }

            // Check for UTF-8 leading byte
            if ((octet & 0xE0) == 0xC0) {
                end = i + 1;
            } else if ((octet & 0xF0) == 0xE0) {
                end = i + 2;
            } else if ((octet & 0xF8) == 0xF0) {
                end = i + 3;
            } else {
                // Java only supports BMP so 3 is max
                return false;
            }

            while (i < end) {
                i++;
                octet = input[i];
                if ((octet & 0xC0) != 0x80) {
                    // Not a valid trailing byte
                    return false;
                }
            }
        }
        return true;
    }


}
