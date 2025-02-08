package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LetterCombinationsOfAPhoneNumberTest {
    @ParameterizedTest
    @MethodSource
    void letterCombinations(String digits, List<String> expectedResult) {
        List<String> actualResult = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> letterCombinations() {
        return Stream.of(
                Arguments.of("", List.of()),
                Arguments.of("2", List.of("a", "b", "c")),
                Arguments.of("22", List.of("aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc")),
                Arguments.of("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("32", List.of("da", "ea", "fa", "db", "eb", "fb", "dc", "ec", "fc")),
                Arguments.of(
                        "759",
                        List.of(
                                "pjw", "pjx", "pjy", "pjz", "pkw", "pkx", "pky", "pkz", "plw", "plx", "ply", "plz",
                                "qjw", "qjx", "qjy", "qjz", "qkw", "qkx", "qky", "qkz", "qlw", "qlx", "qly", "qlz",
                                "rjw", "rjx", "rjy", "rjz", "rkw", "rkx", "rky", "rkz", "rlw", "rlx", "rly", "rlz",
                                "sjw", "sjx", "sjy", "sjz", "skw", "skx", "sky", "skz", "slw", "slx", "sly", "slz"
                        )
                ),
                Arguments.of(
                        "75784",
                        List.of(
                                "pjptg", "pjpth", "pjpti", "pjpug", "pjpuh", "pjpui", "pjpvg", "pjpvh", "pjpvi",
                                "pjqtg", "pjqth", "pjqti", "pjqug", "pjquh", "pjqui", "pjqvg", "pjqvh", "pjqvi",
                                "pjrtg", "pjrth", "pjrti", "pjrug", "pjruh", "pjrui", "pjrvg", "pjrvh", "pjrvi",
                                "pjstg", "pjsth", "pjsti", "pjsug", "pjsuh", "pjsui", "pjsvg", "pjsvh", "pjsvi",
                                "pkptg", "pkpth", "pkpti", "pkpug", "pkpuh", "pkpui", "pkpvg", "pkpvh", "pkpvi",
                                "pkqtg", "pkqth", "pkqti", "pkqug", "pkquh", "pkqui", "pkqvg", "pkqvh", "pkqvi",
                                "pkrtg", "pkrth", "pkrti", "pkrug", "pkruh", "pkrui", "pkrvg", "pkrvh", "pkrvi",
                                "pkstg", "pksth", "pksti", "pksug", "pksuh", "pksui", "pksvg", "pksvh", "pksvi",
                                "plptg", "plpth", "plpti", "plpug", "plpuh", "plpui", "plpvg", "plpvh", "plpvi",
                                "plqtg", "plqth", "plqti", "plqug", "plquh", "plqui", "plqvg", "plqvh", "plqvi",
                                "plrtg", "plrth", "plrti", "plrug", "plruh", "plrui", "plrvg", "plrvh", "plrvi",
                                "plstg", "plsth", "plsti", "plsug", "plsuh", "plsui", "plsvg", "plsvh", "plsvi",
                                "qjptg", "qjpth", "qjpti", "qjpug", "qjpuh", "qjpui", "qjpvg", "qjpvh", "qjpvi",
                                "qjqtg", "qjqth", "qjqti", "qjqug", "qjquh", "qjqui", "qjqvg", "qjqvh", "qjqvi",
                                "qjrtg", "qjrth", "qjrti", "qjrug", "qjruh", "qjrui", "qjrvg", "qjrvh", "qjrvi",
                                "qjstg", "qjsth", "qjsti", "qjsug", "qjsuh", "qjsui", "qjsvg", "qjsvh", "qjsvi",
                                "qkptg", "qkpth", "qkpti", "qkpug", "qkpuh", "qkpui", "qkpvg", "qkpvh", "qkpvi",
                                "qkqtg", "qkqth", "qkqti", "qkqug", "qkquh", "qkqui", "qkqvg", "qkqvh", "qkqvi",
                                "qkrtg", "qkrth", "qkrti", "qkrug", "qkruh", "qkrui", "qkrvg", "qkrvh", "qkrvi",
                                "qkstg", "qksth", "qksti", "qksug", "qksuh", "qksui", "qksvg", "qksvh", "qksvi",
                                "qlptg", "qlpth", "qlpti", "qlpug", "qlpuh", "qlpui", "qlpvg", "qlpvh", "qlpvi",
                                "qlqtg", "qlqth", "qlqti", "qlqug", "qlquh", "qlqui", "qlqvg", "qlqvh", "qlqvi",
                                "qlrtg", "qlrth", "qlrti", "qlrug", "qlruh", "qlrui", "qlrvg", "qlrvh", "qlrvi",
                                "qlstg", "qlsth", "qlsti", "qlsug", "qlsuh", "qlsui", "qlsvg", "qlsvh", "qlsvi",
                                "rjptg", "rjpth", "rjpti", "rjpug", "rjpuh", "rjpui", "rjpvg", "rjpvh", "rjpvi",
                                "rjqtg", "rjqth", "rjqti", "rjqug", "rjquh", "rjqui", "rjqvg", "rjqvh", "rjqvi",
                                "rjrtg", "rjrth", "rjrti", "rjrug", "rjruh", "rjrui", "rjrvg", "rjrvh", "rjrvi",
                                "rjstg", "rjsth", "rjsti", "rjsug", "rjsuh", "rjsui", "rjsvg", "rjsvh", "rjsvi",
                                "rkptg", "rkpth", "rkpti", "rkpug", "rkpuh", "rkpui", "rkpvg", "rkpvh", "rkpvi",
                                "rkqtg", "rkqth", "rkqti", "rkqug", "rkquh", "rkqui", "rkqvg", "rkqvh", "rkqvi",
                                "rkrtg", "rkrth", "rkrti", "rkrug", "rkruh", "rkrui", "rkrvg", "rkrvh", "rkrvi",
                                "rkstg", "rksth", "rksti", "rksug", "rksuh", "rksui", "rksvg", "rksvh", "rksvi",
                                "rlptg", "rlpth", "rlpti", "rlpug", "rlpuh", "rlpui", "rlpvg", "rlpvh", "rlpvi",
                                "rlqtg", "rlqth", "rlqti", "rlqug", "rlquh", "rlqui", "rlqvg", "rlqvh", "rlqvi",
                                "rlrtg", "rlrth", "rlrti", "rlrug", "rlruh", "rlrui", "rlrvg", "rlrvh", "rlrvi",
                                "rlstg", "rlsth", "rlsti", "rlsug", "rlsuh", "rlsui", "rlsvg", "rlsvh", "rlsvi",
                                "sjptg", "sjpth", "sjpti", "sjpug", "sjpuh", "sjpui", "sjpvg", "sjpvh", "sjpvi",
                                "sjqtg", "sjqth", "sjqti", "sjqug", "sjquh", "sjqui", "sjqvg", "sjqvh", "sjqvi",
                                "sjrtg", "sjrth", "sjrti", "sjrug", "sjruh", "sjrui", "sjrvg", "sjrvh", "sjrvi",
                                "sjstg", "sjsth", "sjsti", "sjsug", "sjsuh", "sjsui", "sjsvg", "sjsvh", "sjsvi",
                                "skptg", "skpth", "skpti", "skpug", "skpuh", "skpui", "skpvg", "skpvh", "skpvi",
                                "skqtg", "skqth", "skqti", "skqug", "skquh", "skqui", "skqvg", "skqvh", "skqvi",
                                "skrtg", "skrth", "skrti", "skrug", "skruh", "skrui", "skrvg", "skrvh", "skrvi",
                                "skstg", "sksth", "sksti", "sksug", "sksuh", "sksui", "sksvg", "sksvh", "sksvi",
                                "slptg", "slpth", "slpti", "slpug", "slpuh", "slpui", "slpvg", "slpvh", "slpvi",
                                "slqtg", "slqth", "slqti", "slqug", "slquh", "slqui", "slqvg", "slqvh", "slqvi",
                                "slrtg", "slrth", "slrti", "slrug", "slruh", "slrui", "slrvg", "slrvh", "slrvi",
                                "slstg", "slsth", "slsti", "slsug", "slsuh", "slsui", "slsvg", "slsvh", "slsvi"
                        )
                )
        );
    }
}