package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherListTest {
    @ParameterizedTest
    @MethodSource
    void peopleIndexes(List<List<String>> favoriteCompanies, List<Integer> expectedResult) {
        List<Integer> actualResult = new PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList()
                .peopleIndexes(favoriteCompanies);

        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    static Stream<Arguments> peopleIndexes() {
        return Stream.of(
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(List.of("amazon")), List.of(0)),
                Arguments.of(List.of(List.of("amazon"), List.of("amazon", "google")), List.of(1)),
                Arguments.of(List.of(List.of("amazon"), List.of("amazon", "google")), List.of(1)),
                Arguments.of(
                        List.of(
                                List.of("leetcode", "google", "facebook"),
                                List.of("google", "microsoft"),
                                List.of("google", "facebook"),
                                List.of("google"),
                                List.of("amazon")
                        ),
                        List.of(0, 1, 4)
                ),
                Arguments.of(
                        List.of(
                                List.of("google", "facebook"),
                                List.of("google", "microsoft"),
                                List.of("leetcode", "google", "facebook"),
                                List.of("google"),
                                List.of("amazon")
                        ),
                        List.of(1, 2, 4)
                ),
                Arguments.of(
                        List.of(
                                List.of("leetcode", "google", "facebook"),
                                List.of("leetcode", "amazon"),
                                List.of("facebook", "google")
                        ),
                        List.of(0, 1)
                ),
                Arguments.of(
                        List.of(
                                List.of("leetcode"),
                                List.of("google"),
                                List.of("facebook"),
                                List.of("amazon")
                        ),
                        List.of(0, 1, 2, 3)
                ),
                Arguments.of(
                        List.of(
                                List.of("leetcode", "google", "amazon", "microsoft", "apple", "netflix"),
                                List.of("leetcode", "google", "microsoft", "apple", "netflix"),
                                List.of("google", "amazon", "microsoft", "apple", "netflix")
                        ),
                        List.of(0)
                )
        );
    }
}