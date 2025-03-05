package com.korn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {
    @Test
    void test1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);
        assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(4, 4);
        assertThat(cache.get(1)).isEqualTo(-1);
        assertThat(cache.get(3)).isEqualTo(3);
        assertThat(cache.get(4)).isEqualTo(4);
    }

    @Test
    void test2() {
        LRUCache cache = new LRUCache(2);
        assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(2, 6);
        assertThat(cache.get(1)).isEqualTo(-1);
        cache.put(1, 5);
        cache.put(1, 2);
        assertThat(cache.get(1)).isEqualTo(2);
        assertThat(cache.get(2)).isEqualTo(6);
    }
}