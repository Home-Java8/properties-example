package com.cache_map.completable_future;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

public class SupplyAsyncExample2 {

    static AtomicLong deliveredMessages = new AtomicLong();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("0 " + new Date());
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println((end-start) + " " + new Date());

        String data = "Data";
//        String data = null;

        System.out.println("response: \"" + getResponse(data) + "\" deliveredMessages = " + deliveredMessages);
    }

//    static String getResponse(final String data) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> cf = CompletableFuture
//                .supplyAsync(()-> inOut(data))
//                .thenApply(res -> deliveredMessage(res));
//
//        return cf.get();
//    }

    static String getResponse(final String data) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(()-> inOut(data))
                .thenApply(res -> deliveredMessage(res))
                .get();
    }

    private static String inOut(String data) {
        System.out.println("inOut: [" + new Date() + "]");
        try { Thread.sleep(3500L); } catch (InterruptedException e) {}
        return data;
    }

    private static String deliveredMessage(String data) {
        if (data!=null) {
            deliveredMessages.incrementAndGet();
            System.out.println("deliveredMessage: incrementAndGet [" + new Date() + "]");
        }
        else System.out.println("deliveredMessage: [" + new Date() + "]");
        return data;
    }
}
