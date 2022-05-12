package br.com.simple_validator.stringrules;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharSequenceRuleTest {

    private final CharSequenceRule<String> charSequenceRule = new CharSequenceRule<>();
    private static final String STR_TO_TEST = "validator";

    @Test
    void isUpperCaseOk() {
        boolean result = charSequenceRule.isUpperCase().getRules().get(0).getPredicate().test("ABC");
        assertTrue(result);
    }

    @Test
    void isUpperCaseFail() {
        boolean result = charSequenceRule.isUpperCase().getRules().get(0).getPredicate().test("abc");
        assertFalse(result);
    }

    @Test
    void isUpperCaseNull() {
        boolean result = charSequenceRule.isUpperCase().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isLowerCaseOk() {
        boolean result = charSequenceRule.isLowerCase().getRules().get(0).getPredicate().test("xpo");
        assertTrue(result);
    }

    @Test
    void isLowerCaseFail() {
        boolean result = charSequenceRule.isLowerCase().getRules().get(0).getPredicate().test("XPO");
        assertFalse(result);
    }

    @Test
    void isLowerCaseNull() {
        boolean result = charSequenceRule.isLowerCase().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void startsWithOk() {
        boolean result = charSequenceRule.startsWith("va").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void startsWithFail() {
        boolean result = charSequenceRule.startsWith("or").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void endsWithOk() {
        boolean result = charSequenceRule.endsWith("or").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void endsWithFail() {
        boolean result = charSequenceRule.endsWith("va").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void containsOk() {
        boolean result = charSequenceRule.contains("dat").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void containsFail() {
        boolean result = charSequenceRule.contains("kkk").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void lessThanOk() {
        boolean result = charSequenceRule.lessThan(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void lessThanOkFail() {
        boolean result = charSequenceRule.lessThan(8).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void lessThanOrEqualsOk() {
        boolean result = charSequenceRule.lessThanOrEquals(9).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void lessThanOrEqualsFail() {
        boolean result = charSequenceRule.lessThanOrEquals(8).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void greaterThanOk() {
        boolean result = charSequenceRule.greaterThan(8).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void greaterThanFail() {
        boolean result = charSequenceRule.greaterThan(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void greaterThanOrEqualsOk() {
        boolean result = charSequenceRule.greaterThanOrEquals(9).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void greaterThanOrEqualsFail() {
        boolean result = charSequenceRule.greaterThan(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void sizeOk() {
        boolean result = charSequenceRule.size(9).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void sizeFail() {
        boolean result = charSequenceRule.size(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void inOk() {
        boolean result = charSequenceRule.in(Arrays.asList(STR_TO_TEST, "another")).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void inFail() {
        boolean result = charSequenceRule.in(Arrays.asList("one", "two")).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void notBlankOk() {
        boolean result = charSequenceRule.notBlank().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void notBlankFail() {
        boolean result = charSequenceRule.notBlank().getRules().get(0).getPredicate().test("  ");
        assertFalse(result);
    }

    @Test
    void isBlankOk() {
        boolean result = charSequenceRule.isBlank().getRules().get(0).getPredicate().test(" ");
        assertTrue(result);
    }

    @Test
    void isBlankFail() {
        boolean result = charSequenceRule.isBlank().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void emailOk() {
        boolean result = charSequenceRule.email().getRules().get(0).getPredicate().test("val@validator.com");
        assertTrue(result);
    }

    @Test
    void emailFail() {
        boolean result = charSequenceRule.email().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void isNumericOk() {
        boolean result = charSequenceRule.isNumeric().getRules().get(0).getPredicate().test("12356");
        assertTrue(result);
    }

    @Test
    void isNumericFalse() {
        boolean result = charSequenceRule.isNumeric().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void isNumericNull() {
        boolean result = charSequenceRule.isNumeric().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void notNullOk() {
        boolean result = charSequenceRule.notNull().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void notNullFalse() {
        boolean result = charSequenceRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void equalsToOk() {
        boolean result = charSequenceRule.equalsTo(STR_TO_TEST).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void equalsToFalse() {
        boolean result = charSequenceRule.equalsTo("another").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void notEqualsToOk() {
        boolean result = charSequenceRule.notEqualsTo(STR_TO_TEST).getRules().get(0).getPredicate().test("abc");
        assertTrue(result);
    }

    @Test
    void notEqualsToFalse() {
        boolean result = charSequenceRule.notEqualsTo(STR_TO_TEST).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void isPositiveOk() {
        boolean result = charSequenceRule.isPositive().getRules().get(0).getPredicate().test("1");
        assertTrue(result);
    }

    @Test
    void isPositiveOrZeroOk() {
        boolean result = charSequenceRule.isPositiveOrZero().getRules().get(0).getPredicate().test("0");
        assertTrue(result);
    }

    @Test
    void isPositiveOrZeroFail() {
        boolean result = charSequenceRule.isPositiveOrZero().getRules().get(0).getPredicate().test("-1");
        assertFalse(result);
    }

    @Test
    void isPositiveOrZeroNotANumber() {
        boolean result = charSequenceRule.isPositiveOrZero().getRules().get(0).getPredicate().test("O");
        assertFalse(result);
    }

    @Test
    void isPositiveFalse() {
        boolean result = charSequenceRule.isPositive().getRules().get(0).getPredicate().test("0");
        assertFalse(result);
    }

    @Test
    void isPositiveNotANumber() {
        boolean result = charSequenceRule.isPositive().getRules().get(0).getPredicate().test("a");
        assertFalse(result);
    }

    @Test
    void isNegativeOk() {
        boolean result = charSequenceRule.isNegative().getRules().get(0).getPredicate().test("-1");
        assertTrue(result);
    }

    @Test
    void isNegativeOrZeroOk() {
        boolean result = charSequenceRule.isNegativeOrZero().getRules().get(0).getPredicate().test("0");
        assertTrue(result);
    }

    @Test
    void isNegativeOrZeroFail() {
        boolean result = charSequenceRule.isNegativeOrZero().getRules().get(0).getPredicate().test("1");
        assertFalse(result);
    }

    @Test
    void isNegativeOrZeroNotANumber() {
        boolean result = charSequenceRule.isNegativeOrZero().getRules().get(0).getPredicate().test("X");
        assertFalse(result);
    }

    @Test
    void isNegativeFalse() {
        boolean result = charSequenceRule.isNegative().getRules().get(0).getPredicate().test("1");
        assertFalse(result);
    }

    @Test
    void isNegativeNotANumber() {
        boolean result = charSequenceRule.isNegative().getRules().get(0).getPredicate().test("a");
        assertFalse(result);
    }

    @Test
    void matchRegexOk() {
        boolean result = charSequenceRule.matchRegex("^(.+)@(.+)$").getRules().get(0).getPredicate().test("val@validator.com");
        assertTrue(result);
    }

    @Test
    void matchRegexFail() {
        boolean result = charSequenceRule.matchRegex("^(.+)@(.+)$").getRules().get(0).getPredicate().test("abc");
        assertFalse(result);
    }

    @Test
    void isValidDateOk() {
        boolean result = charSequenceRule.isValidDate("yyyy/MM/dd").getRules().get(0).getPredicate().test("1993/05/22");
        assertTrue(result);
    }

    @Test
    void isValidDateFail() {
        boolean result = charSequenceRule.isValidDate("yyyy/MM/dd").getRules().get(0).getPredicate().test("22/05/1993");
        assertFalse(result);
    }

    @Test
    void isValidDateInvalid() {
        boolean result = charSequenceRule.isValidDate("yyyy/MM/dd").getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isValidDateTimeOk() {
        boolean result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm").getRules().get(0).getPredicate().test("1993/05/22 05:00");
        assertTrue(result);
    }

    @Test
    void isValidDateTimeFail() {
        boolean result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm").getRules().get(0).getPredicate().test("22/05/1993");
        assertFalse(result);
    }

    @Test
    void isValidDateTimeInvalid() {
        boolean result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm").getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isFutureDateOk() {
        boolean result = charSequenceRule.isFutureDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentDateOk() {
        boolean result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentDateFail() {
        boolean result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentDateInvalid() {
        boolean result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("lpo");
        assertFalse(result);
    }

    @Test
    void isFutureDateFail() {
        boolean result = charSequenceRule.isFutureDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isFutureDateInvalid() {
        boolean result = charSequenceRule.isFutureDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("ABC");
        assertFalse(result);
    }

    @Test
    void isFutureDateTimeOk() {
        boolean result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isFutureDateTimeFail() {
        boolean result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isFutureDateTimeInvalid() {
        boolean result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("xp");
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentDateTimeOk() {
        boolean result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentDateTimeFail() {
        boolean result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentDateTimeInvalid() {
        boolean result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("wasd");
        assertFalse(result);
    }

    @Test
    void isPastDateOk() {
        boolean result = charSequenceRule.isPastDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isPastDateFail() {
        boolean result = charSequenceRule.isPastDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isPastDateInvalid() {
        boolean result = charSequenceRule.isPastDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("ads");
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateOk() {
        boolean result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isPastOrPresentDateFail() {
        boolean result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateInvalid() {
        boolean result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("lk");
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateTimeOk() {
        boolean result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isPastOrPresentDateTimeFail() {
        boolean result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateTimeInvalid() {
        boolean result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("lk");
        assertFalse(result);
    }

    @Test
    void isPastDateTimeOk() {
        boolean result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isPastDateTimeFail() {
        boolean result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isPastDateTimeInvalid() {
        boolean result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("lk");
        assertFalse(result);
    }

    @Test
    void isDigitOk() {
        boolean result = charSequenceRule.isDigit().getRules().get(0).getPredicate().test("1234");
        assertTrue(result);
    }

    @Test
    void isDigitFail() {
        boolean result = charSequenceRule.isDigit().getRules().get(0).getPredicate().test("1234A");
        assertFalse(result);
    }

    @Test
    void isDigitInvalid() {
        boolean result = charSequenceRule.isDigit().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }
}
