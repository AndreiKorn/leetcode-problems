package com.korn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DesignAddAndSearchWordsDataStructureTest {
    @Test
    void test() {
        DesignAddAndSearchWordsDataStructure dataStructure = new DesignAddAndSearchWordsDataStructure();
        dataStructure.addWord("bad");
        dataStructure.addWord("dad");
        dataStructure.addWord("mad");
        assertThat(dataStructure.search("pad")).isFalse();
        assertThat(dataStructure.search("bad")).isTrue();
        assertThat(dataStructure.search(".ad")).isTrue();
        assertThat(dataStructure.search("b..")).isTrue();
        dataStructure.addWord("gada");
        assertThat(dataStructure.search("gad")).isFalse();
        assertThat(dataStructure.search(".gad")).isFalse();
        assertThat(dataStructure.search("gad.")).isTrue();
        assertThat(dataStructure.search(".")).isFalse();
        assertThat(dataStructure.search("..")).isFalse();
        assertThat(dataStructure.search("...")).isTrue();
        assertThat(dataStructure.search("....")).isTrue();
        assertThat(dataStructure.search(".....")).isFalse();
        dataStructure.addWord("daddy");
        assertThat(dataStructure.search("dad")).isTrue();
        assertThat(dataStructure.search("dadd")).isFalse();
        assertThat(dataStructure.search("daddy")).isTrue();
        assertThat(dataStructure.search("dadds")).isFalse();
        dataStructure.addWord("bad");
        assertThat(dataStructure.search("bad")).isTrue();
        assertThat(dataStructure.search(".ad")).isTrue();
        assertThat(dataStructure.search("b..")).isTrue();
    }
}