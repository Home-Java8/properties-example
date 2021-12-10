package com.cache_map;

import java.util.HashSet;
import java.util.Set;

public class InMemoryCache2 {

    private final Set<String> cache = new HashSet();

    public boolean add(String key) {
        return cache.isEmpty()
                ? cache.add(key)
                : false;
    }

    public boolean remove(String key) {
        return cache.remove(key);
    }

    public String get() {
        return !cache.isEmpty()
                ? cache.iterator().next()
                : null;
    }
}
