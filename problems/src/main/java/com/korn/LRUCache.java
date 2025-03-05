package com.korn;

import java.util.LinkedHashMap;

/**
 * Solution for <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 */
public class LRUCache {
    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
        if (cache.size() > capacity) {
            cache.remove(cache.firstEntry().getKey());
        }
    }
}
