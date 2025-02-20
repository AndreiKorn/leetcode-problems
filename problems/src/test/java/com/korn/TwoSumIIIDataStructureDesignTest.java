package com.korn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumIIIDataStructureDesignTest {
    @Test
    void test1() {
        TwoSumIIIDataStructureDesign twoSumIIIDataStructureDesign = new TwoSumIIIDataStructureDesign();
        twoSumIIIDataStructureDesign.add(1);
        twoSumIIIDataStructureDesign.add(3);
        twoSumIIIDataStructureDesign.add(5);
        assertThat(twoSumIIIDataStructureDesign.find(4)).isTrue();
        assertThat(twoSumIIIDataStructureDesign.find(7)).isFalse();
    }

    @Test
    void test2() {
        TwoSumIIIDataStructureDesign twoSumIIIDataStructureDesign = new TwoSumIIIDataStructureDesign();
        twoSumIIIDataStructureDesign.add(0);
        assertThat(twoSumIIIDataStructureDesign.find(0)).isFalse();
    }

    @Test
    void test3() {
        TwoSumIIIDataStructureDesign twoSumIIIDataStructureDesign = new TwoSumIIIDataStructureDesign();
        twoSumIIIDataStructureDesign.add(0);
        twoSumIIIDataStructureDesign.add(0);
        assertThat(twoSumIIIDataStructureDesign.find(0)).isTrue();
    }

    @Test
    void test4() {
        TwoSumIIIDataStructureDesign twoSumIIIDataStructureDesign = new TwoSumIIIDataStructureDesign();
        twoSumIIIDataStructureDesign.add(0);
        twoSumIIIDataStructureDesign.add(-1);
        twoSumIIIDataStructureDesign.add(1);
        assertThat(twoSumIIIDataStructureDesign.find(0)).isTrue();
    }

    @Test
    void test5() {
        TwoSumIIIDataStructureDesign twoSumIIIDataStructureDesign = new TwoSumIIIDataStructureDesign();
        twoSumIIIDataStructureDesign.add(3);
        twoSumIIIDataStructureDesign.add(2);
        twoSumIIIDataStructureDesign.add(1);
        assertThat(twoSumIIIDataStructureDesign.find(2)).isFalse();
        assertThat(twoSumIIIDataStructureDesign.find(3)).isTrue();
        assertThat(twoSumIIIDataStructureDesign.find(4)).isTrue();
        assertThat(twoSumIIIDataStructureDesign.find(5)).isTrue();
        assertThat(twoSumIIIDataStructureDesign.find(6)).isFalse();
    }
}