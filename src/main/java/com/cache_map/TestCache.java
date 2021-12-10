package com.cache_map;

public class TestCache {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        InMemoryCache inMemoryCache = new InMemoryCache();

        System.out.println("-------------- 1");
        System.out.println( inMemoryCache.get() );

        System.out.println("-------------- 2");
//        inMemoryCache.add("2", System.currentTimeMillis());
        inMemoryCache.add("22", System.currentTimeMillis());
//        inMemoryCache.add("333", System.currentTimeMillis());
        System.out.println( inMemoryCache.get() );

        System.out.println("-------------- 3");
        inMemoryCache.remove("22");
        System.out.println( inMemoryCache.get() );
    }

    public static void test2() {
        InMemoryCache2 inMemoryCache2 = new InMemoryCache2();

        System.out.println("-------------- 0");
        inMemoryCache2.remove("22");
        System.out.println( inMemoryCache2.get() );

        System.out.println("-------------- 1");
        System.out.println( inMemoryCache2.get() );

        System.out.println("-------------- 2");
//        inMemoryCache2.add("2");
//        inMemoryCache2.add("2");
        inMemoryCache2.add("22");
        inMemoryCache2.add("22");
//        inMemoryCache2.add("333");
//        inMemoryCache2.add("333");
        System.out.println( inMemoryCache2.get() );

        System.out.println("-------------- 3");
        inMemoryCache2.remove("22");
        System.out.println( inMemoryCache2.get() );
    }
}
