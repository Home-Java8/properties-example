package com.cache_map.completable_future;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture
                .supplyAsync(()-> sendData(new Date().toString()))
                .thenApply(data -> getData(data));

        System.out.println("response: '" + cf.get() + "' [" + new Date() + "]");
    }

    private static String sendData(String id) {
        System.out.println("sendData: '" + id + "' [" + new Date() + "]");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {}
        return "Data: " + id;
//        return null;
    }

    private static String getData(String data) {
        if (data!=null) System.out.println("getData: '" + data + "' + incrementAndGet [" + new Date() + "]");
        else System.out.println("getData: '" + data + "' [" + new Date() + "]");
        return data;
    }
}
