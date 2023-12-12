package ru.gorodnyuk.cptlz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CapitalizeUtilsTest {

    @ParameterizedTest
    @MethodSource("personTestData")
    public void shouldEqualsAsExpected(PersonTest actual, PersonTest expected) {
        CapitalizeUtils.capitalize(actual, "name", "address");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void shouldThrowIllegalArgumentExceptionWhenFieldsNotPassed(String... input) {
        assertThrows(IllegalArgumentException.class, () -> CapitalizeUtils.capitalize(getPersonTest("oleg", "address"), input));
    }

    private static Stream<Arguments> personTestData() {
        return Stream.of(
                Arguments.of(
                        getPersonTest("oleg", "address"),
                        getPersonTest("Oleg", "Address")
                ),
                Arguments.of(
                        getPersonTest("oleg", "Address"),
                        getPersonTest("Oleg", "Address")
                ),
                Arguments.of(
                        getPersonTest("Oleg", "address"),
                        getPersonTest("Oleg", "Address")
                )
        );
    }

    private static PersonTest getPersonTest(String name, String address) {
        return new PersonTest(name, address, 35, LocalDate.of(1990, 1, 1));
    }
}