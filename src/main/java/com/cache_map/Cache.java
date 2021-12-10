package com.cache_map;

public interface Cache {
    Long add(String key, Long periodInMillis);

    void remove(String key);

    String get();
}
