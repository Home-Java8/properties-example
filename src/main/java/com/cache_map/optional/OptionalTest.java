package com.cache_map.optional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class OptionalTest {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    static void test1() {
        AtomicLong deliveredMessages = new AtomicLong();

        String test = "test";
//        String test = null;

        String response = Optional.ofNullable(test)
                .map(res -> {
                    if (res!=null) deliveredMessages.incrementAndGet();
                    return res;
                })
                .orElse(null);

        System.out.println("response = '" + response + "'; " + "deliveredMessages = " + deliveredMessages + ";");
    }

    static void test2() {
        AtomicLong deliveredMessages = new AtomicLong();

//        String test = "test";
        String test = null;

        String response = Optional.ofNullable(test)
                .filter(o -> {
                    System.out.println("-" + o + "-");
                    return true;
                })
                .map(res -> {
                    System.out.println("=" + res + "=");
                    if (res!=null) deliveredMessages.incrementAndGet();
                    return res;
                })
//                .orElse(null);
        .orElseGet(() -> {
            System.out.println("+" + "+");
            return null;
        });

        System.out.println("response = '" + response + "'; " + "deliveredMessages = " + deliveredMessages + ";");
    }
}
