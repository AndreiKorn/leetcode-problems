package com.korn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ImplementTriePrefixTreeTest {
    @Test
    void test() {
        ImplementTriePrefixTree.Trie trie = new ImplementTriePrefixTree.Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        trie.insert("apps");
        trie.insert("apples");

        assertThat(trie.search("app")).isTrue();
        assertThat(trie.search("apps")).isTrue();
        assertThat(trie.search("apples")).isTrue();
        assertThat(trie.search("ad")).isFalse();
        assertThat(trie.search("apple")).isTrue();
        assertThat(trie.search("app")).isTrue();
        assertThat(trie.search("beer")).isTrue();
        assertThat(trie.search("jam")).isTrue();
        assertThat(trie.search("rental")).isTrue();
        assertThat(trie.startsWith("apps")).isTrue();
        assertThat(trie.startsWith("apples")).isTrue();
        assertThat(trie.startsWith("ad")).isTrue();
        assertThat(trie.startsWith("apple")).isTrue();
        assertThat(trie.startsWith("app")).isTrue();
        assertThat(trie.startsWith("beer")).isTrue();
        assertThat(trie.startsWith("jam")).isTrue();
        assertThat(trie.startsWith("rental")).isTrue();
    }
}