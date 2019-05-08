package com.petrikainulainen;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @see https://stackoverflow.com/questions/4267475/generating-8-character-only-uuids
 */
public class CharacterGenerator {

    public static void main(String[] args) {
        final int SHORT_UID_LENGTH = 8;

        // all possible unicode characters
        String shortId = RandomStringUtils.random(SHORT_UID_LENGTH);
        System.out.println("shortId = " + shortId);
        System.out.println("shortId = " + shortId);
        System.out.println("shortId = " + shortId);

        System.out.println();

        // HEX: 0-9, a-f. For example: 6587fddb, c0f182c1
        shortId = RandomStringUtils.random(8, "0123456789abcdef");
        System.out.println("shortId = " + shortId);

        // a-z, A-Z. For example: eRkgbzeF, MFcWSksx
        shortId = RandomStringUtils.randomAlphabetic(8);
        System.out.println("shortId = " + shortId);

        // 0-9. For example: 76091014, 03771122
        shortId = RandomStringUtils.randomNumeric(8);
        System.out.println("shortId = " + shortId);

        System.out.println();
        System.out.println();

        // a-z, A-Z, 0-9. For example: WRMcpIk7, s57JwCVA
        shortId = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("shortId = " + shortId);
        shortId = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("shortId = " + shortId);
        shortId = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("shortId = " + shortId);
    }

}
