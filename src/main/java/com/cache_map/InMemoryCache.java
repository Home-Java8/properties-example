package com.cache_map;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache implements Cache {

    private final ConcurrentHashMap<String, Long> cache = new ConcurrentHashMap<>();

    @Override
    public Long add(String key, Long periodInMillis) {
        return cache.put(key, periodInMillis);
    }

    @Override
    public String get() {
        Iterator<Map.Entry<String, Long>> iterator = cache.entrySet().iterator();
        String key = null;
        boolean isFirst = false;
        while (iterator.hasNext() && !isFirst) {
            Map.Entry<String, Long> item = iterator.next();
            System.out.println("> " + item.getKey());
            key = item.getKey();
            isFirst = true;
        }
        return key;
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }
}
