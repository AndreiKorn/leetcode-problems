package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class InterleavingStringTest {
    @ParameterizedTest
    @MethodSource("isInterleave")
    void isInterleaveRecursive(String s1, String s2, String s3, boolean expectedResult) {
        boolean actualResult = new InterleavingString().isInterleaveRecursive(s1, s2, s3);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
    
    @ParameterizedTest
    @MethodSource("isInterleave")
    void isInterleave2Dp(String s1, String s2, String s3, boolean expectedResult) {
        boolean actualResult = new InterleavingString().isInterleave2Dp(s1, s2, s3);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
    
    static Stream<Arguments> isInterleave() {
        return Stream.of(
                Arguments.of("", "", "", true),
                Arguments.of("", "a", "", false),
                Arguments.of("a", "b", "", false),
                Arguments.of("a", "b", "ab", true),
                Arguments.of("a", "b", "ba", true),
                Arguments.of("aba", "", "aba", true),
                Arguments.of("aba", "", "aab", false),
                Arguments.of("", "aba", "aba", true),
                Arguments.of("", "aba", "aab", false),
                Arguments.of("abc", "abc", "aabbcc", true),
                Arguments.of("abc", "abc", "abcabc", true),
                Arguments.of("abc", "abc", "abcbac", false),
                Arguments.of("aabcc", "dbbca", "aadbbcbcac", true),
                Arguments.of("aabcc", "dbbca", "aadbzcbcac", false),
                Arguments.of("aabcc", "dbbca", "aadbbbaccc", false),
                Arguments.of(
                        "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbb" +
                                "aaababaa",
                        "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababb" +
                                "abbabaab",
                        "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaab" +
                                "abbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaa" +
                                "bbbbabaaabbababbabbabbab",
                        false // check
                )
        );
    }
}