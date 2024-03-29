package io.github.jeanls.simplevalidator.stringrules;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharSequenceRuleTest {

    private final CharSequenceRule<String> charSequenceRule = new CharSequenceRule<>();
    private static final String STR_TO_TEST = "validator";
    private static final String MESSAGE = "msg";

    @Test
    void isBooleanTrueOkTest() {
        boolean result = charSequenceRule.isBoolean().getRules().get(0).getPredicate().test("true");
        assertTrue(result);
        result = charSequenceRule.isBoolean(MESSAGE).getRules().get(0).getPredicate().test("true");
        assertTrue(result);
    }

    @Test
    void isBooleanFalseOkTest() {
        boolean result = charSequenceRule.isBoolean().getRules().get(0).getPredicate().test("false");
        assertTrue(result);
        result = charSequenceRule.isBoolean(MESSAGE).getRules().get(0).getPredicate().test("false");
        assertTrue(result);
    }

    @Test
    void isBooleanFailTest() {
        boolean result = charSequenceRule.isBoolean().getRules().get(0).getPredicate().test("kkk");
        assertFalse(result);
        result = charSequenceRule.isBoolean(MESSAGE).getRules().get(0).getPredicate().test("kkk");
        assertFalse(result);
    }

    @Test
    void isBooleanNullTest() {
        boolean result = charSequenceRule.isBoolean().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
        result = charSequenceRule.isBoolean(MESSAGE).getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isAfterOkTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isAfterDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertTrue(result);

        result = charSequenceRule.isAfterDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertTrue(result);
    }

    @Test
    void isAfterFailTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isAfterDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertFalse(result);

        result = charSequenceRule.isAfterDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertFalse(result);
    }

    @Test
    void isAfterNullTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        boolean result = charSequenceRule.isAfterDate(actualDate, pattern).getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isAfterDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isAfterOrEqualsOkTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isAfterOrEqualsDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertTrue(result);

        result = charSequenceRule.isAfterOrEqualsDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertTrue(result);
    }

    @Test
    void isAfterOrEqualsFailTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isAfterOrEqualsDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertFalse(result);

        result = charSequenceRule.isAfterOrEqualsDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertFalse(result);
    }

    @Test
    void isAfterOrEqualsNullTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        boolean result = charSequenceRule.isAfterOrEqualsDate(actualDate, pattern).getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isAfterOrEqualsDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isBeforeOkTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isBeforeDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertTrue(result);

        result = charSequenceRule.isBeforeDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertTrue(result);
    }

    @Test
    void isBeforeFailTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isBeforeDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertFalse(result);

        result = charSequenceRule.isBeforeDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertFalse(result);
    }

    @Test
    void isBeforeNullTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        boolean result = charSequenceRule.isBeforeDate(actualDate, pattern).getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isBeforeDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isBeforeOrEqualsOkTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isBeforeOrEqualsDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertTrue(result);

        result = charSequenceRule.isBeforeOrEqualsDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertTrue(result);
    }

    @Test
    void isBeforeOrEqualsFailTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        String testDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);

        boolean result = charSequenceRule.isBeforeOrEqualsDate(actualDate, pattern).getRules().get(0).getPredicate().test(testDate);
        assertFalse(result);

        result = charSequenceRule.isBeforeOrEqualsDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(testDate);
        assertFalse(result);
    }

    @Test
    void isBeforeOrEqualsNullTest() {
        String actualDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String pattern = "yyyy-MM-dd";

        boolean result = charSequenceRule.isBeforeOrEqualsDate(actualDate, pattern).getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isBeforeOrEqualsDate(actualDate, pattern, MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isUpperCaseOk() {
        boolean result = charSequenceRule.isUpperCase().getRules().get(0).getPredicate().test("ABC");
        assertTrue(result);

        result = charSequenceRule.isUpperCase(MESSAGE).getRules().get(1).getPredicate().test("ABC");
        assertTrue(result);
    }

    @Test
    void isUpperCaseFail() {
        boolean result = charSequenceRule.isUpperCase().getRules().get(0).getPredicate().test("abc");
        assertFalse(result);

        result = charSequenceRule.isUpperCase(MESSAGE).getRules().get(1).getPredicate().test("abc");
        assertFalse(result);
    }

    @Test
    void isUpperCaseNull() {
        boolean result = charSequenceRule.isUpperCase().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isUpperCase(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isLowerCaseOk() {
        boolean result = charSequenceRule.isLowerCase().getRules().get(0).getPredicate().test("xpo");
        assertTrue(result);

        result = charSequenceRule.isLowerCase(MESSAGE).getRules().get(1).getPredicate().test("xpo");
        assertTrue(result);
    }

    @Test
    void isLowerCaseFail() {
        boolean result = charSequenceRule.isLowerCase().getRules().get(0).getPredicate().test("XPO");
        assertFalse(result);

        result = charSequenceRule.isLowerCase(MESSAGE).getRules().get(1).getPredicate().test("XPO");
        assertFalse(result);
    }

    @Test
    void isLowerCaseNull() {
        boolean result = charSequenceRule.isLowerCase().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isLowerCase(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void startsWithOk() {
        boolean result = charSequenceRule.startsWith("va").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.startsWith("va", MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void startsWithFail() {
        boolean result = charSequenceRule.startsWith("or").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.startsWith("or", MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void endsWithOk() {
        boolean result = charSequenceRule.endsWith("or").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.endsWith("or", MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void endsWithFail() {
        boolean result = charSequenceRule.endsWith("va").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.endsWith("va", MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void containsOk() {
        boolean result = charSequenceRule.contains("dat").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.contains("dat", MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void containsFail() {
        boolean result = charSequenceRule.contains("kkk").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.contains("kkk", MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void lessThanOk() {
        boolean result = charSequenceRule.lessThan(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.lessThan(10, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void lessThanOkFail() {
        boolean result = charSequenceRule.lessThan(8).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.lessThan(8, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void lessThanOrEqualsOk() {
        boolean result = charSequenceRule.lessThanOrEquals(9).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.lessThanOrEquals(9, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void lessThanOrEqualsFail() {
        boolean result = charSequenceRule.lessThanOrEquals(8).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.lessThanOrEquals(8, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void greaterThanOk() {
        boolean result = charSequenceRule.greaterThan(8).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.greaterThan(8, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void greaterThanFail() {
        boolean result = charSequenceRule.greaterThan(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.greaterThan(10, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void greaterThanOrEqualsOk() {
        boolean result = charSequenceRule.greaterThanOrEquals(9).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.greaterThanOrEquals(9, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void greaterThanOrEqualsFail() {
        boolean result = charSequenceRule.greaterThan(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.greaterThan(10, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void sizeOk() {
        boolean result = charSequenceRule.size(9).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.size(9, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void sizeFail() {
        boolean result = charSequenceRule.size(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.size(10, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void notSizeOk() {
        boolean result = charSequenceRule.notSize(10).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.notSize(10, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void notSizeFail() {
        boolean result = charSequenceRule.notSize(9).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.notSize(9, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void sizesOk() {
        boolean result = charSequenceRule.sizes(Arrays.asList(10, 9)).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.sizes(Arrays.asList(10, 9), MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void sizesFail() {
        boolean result = charSequenceRule.sizes(Arrays.asList(10, 11)).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.sizes(Arrays.asList(10, 11), MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void notSizesOk() {
        boolean result = charSequenceRule.notSizes(Arrays.asList(10, 11)).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.notSizes(Arrays.asList(10, 11), MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void notSizesFail() {
        boolean result = charSequenceRule.notSizes(Arrays.asList(9, 10)).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.notSizes(Arrays.asList(9, 10), MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void inOk() {
        boolean result = charSequenceRule.in(Arrays.asList(STR_TO_TEST, "another")).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.in(Arrays.asList(STR_TO_TEST, "another"), MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void inFail() {
        boolean result = charSequenceRule.in(Arrays.asList("one", "two")).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.in(Arrays.asList("one", "two"), MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void notInOk() {
        boolean result = charSequenceRule.notIn(Arrays.asList("1", "2")).getRules().get(0).getPredicate().test("3");
        assertTrue(result);

        result = charSequenceRule.notIn(Arrays.asList("1", "2"), MESSAGE).getRules().get(1).getPredicate().test("3");
        assertTrue(result);
    }

    @Test
    void notInFail() {
        boolean result = charSequenceRule.notIn(Arrays.asList("1", "2")).getRules().get(0).getPredicate().test("1");
        assertFalse(result);

        result = charSequenceRule.notIn(Arrays.asList("1", "2"), MESSAGE).getRules().get(1).getPredicate().test("1");
        assertFalse(result);
    }

    @Test
    void notBlankOk() {
        boolean result = charSequenceRule.notBlank().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.notBlank(MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void notBlankFail() {
        boolean result = charSequenceRule.notBlank().getRules().get(0).getPredicate().test("  ");
        assertFalse(result);

        result = charSequenceRule.notBlank(MESSAGE).getRules().get(1).getPredicate().test("  ");
        assertFalse(result);
    }

    @Test
    void notNumericOk() {
        boolean result = charSequenceRule.notNumeric().getRules().get(0).getPredicate().test("anc");
        assertTrue(result);

        result = charSequenceRule.notNumeric(MESSAGE).getRules().get(1).getPredicate().test("anc");
        assertTrue(result);
    }

    @Test
    void notNumericFail() {
        boolean result = charSequenceRule.notNumeric().getRules().get(0).getPredicate().test("123");
        assertFalse(result);

        result = charSequenceRule.notNumeric(MESSAGE).getRules().get(1).getPredicate().test("123");
        assertFalse(result);
    }

    @Test
    void isBlankOk() {
        boolean result = charSequenceRule.isBlank().getRules().get(0).getPredicate().test(" ");
        assertTrue(result);

        result = charSequenceRule.isBlank(MESSAGE).getRules().get(1).getPredicate().test(" ");
        assertTrue(result);
    }

    @Test
    void isBlankFail() {
        boolean result = charSequenceRule.isBlank().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.isBlank(MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void emailOk() {
        boolean result = charSequenceRule.email().getRules().get(0).getPredicate().test("val@validator.com");
        assertTrue(result);

        result = charSequenceRule.email(MESSAGE).getRules().get(1).getPredicate().test("val@validator.com");
        assertTrue(result);
    }

    @Test
    void emailFail() {
        boolean result = charSequenceRule.email().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.email(MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void isNumericOk() {
        boolean result = charSequenceRule.isNumeric().getRules().get(0).getPredicate().test("12356");
        assertTrue(result);

        result = charSequenceRule.isNumeric(MESSAGE).getRules().get(1).getPredicate().test("12356");
        assertTrue(result);

        result = charSequenceRule.isNumeric(MESSAGE).getRules().get(2).getPredicate().test("75.5");
        assertTrue(result);
    }

    @Test
    void isNumericFalse() {
        boolean result = charSequenceRule.isNumeric().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.isNumeric(MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void isNumericNull() {
        boolean result = charSequenceRule.isNumeric().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isNumeric(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void notNullOk() {
        boolean result = charSequenceRule.notNull().getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void notNullFalse() {
        boolean result = charSequenceRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void equalsToOk() {
        boolean result = charSequenceRule.equalsTo(STR_TO_TEST).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertTrue(result);

        result = charSequenceRule.equalsTo(STR_TO_TEST, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertTrue(result);
    }

    @Test
    void equalsToFalse() {
        boolean result = charSequenceRule.equalsTo("another").getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.equalsTo("another", MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void notEqualsToOk() {
        boolean result = charSequenceRule.notEqualsTo(STR_TO_TEST).getRules().get(0).getPredicate().test("abc");
        assertTrue(result);

        result = charSequenceRule.notEqualsTo(STR_TO_TEST, MESSAGE).getRules().get(1).getPredicate().test("abc");
        assertTrue(result);
    }

    @Test
    void notEqualsToFalse() {
        boolean result = charSequenceRule.notEqualsTo(STR_TO_TEST).getRules().get(0).getPredicate().test(STR_TO_TEST);
        assertFalse(result);

        result = charSequenceRule.notEqualsTo(STR_TO_TEST, MESSAGE).getRules().get(1).getPredicate().test(STR_TO_TEST);
        assertFalse(result);
    }

    @Test
    void isPositiveOk() {
        boolean result = charSequenceRule.isPositive().getRules().get(0).getPredicate().test("1");
        assertTrue(result);

        result = charSequenceRule.isPositive(MESSAGE).getRules().get(1).getPredicate().test("1");
        assertTrue(result);
    }

    @Test
    void isPositiveOrZeroOk() {
        boolean result = charSequenceRule.isPositiveOrZero().getRules().get(0).getPredicate().test("0");
        assertTrue(result);

        result = charSequenceRule.isPositiveOrZero(MESSAGE).getRules().get(1).getPredicate().test("0");
        assertTrue(result);
    }

    @Test
    void isPositiveOrZeroFail() {
        boolean result = charSequenceRule.isPositiveOrZero().getRules().get(0).getPredicate().test("-1");
        assertFalse(result);

        result = charSequenceRule.isPositiveOrZero(MESSAGE).getRules().get(1).getPredicate().test("-1");
        assertFalse(result);
    }

    @Test
    void isPositiveOrZeroNotANumber() {
        boolean result = charSequenceRule.isPositiveOrZero().getRules().get(0).getPredicate().test("O");
        assertFalse(result);

        result = charSequenceRule.isPositiveOrZero(MESSAGE).getRules().get(1).getPredicate().test("O");
        assertFalse(result);
    }

    @Test
    void isPositiveFalse() {
        boolean result = charSequenceRule.isPositive().getRules().get(0).getPredicate().test("0");
        assertFalse(result);

        result = charSequenceRule.isPositive(MESSAGE).getRules().get(1).getPredicate().test("0");
        assertFalse(result);
    }

    @Test
    void isPositiveNotANumber() {
        boolean result = charSequenceRule.isPositive().getRules().get(0).getPredicate().test("a");
        assertFalse(result);

        result = charSequenceRule.isPositive(MESSAGE).getRules().get(1).getPredicate().test("a");
        assertFalse(result);
    }

    @Test
    void isNegativeOk() {
        boolean result = charSequenceRule.isNegative().getRules().get(0).getPredicate().test("-1");
        assertTrue(result);

        result = charSequenceRule.isNegative(MESSAGE).getRules().get(1).getPredicate().test("-1");
        assertTrue(result);
    }

    @Test
    void isNegativeOrZeroOk() {
        boolean result = charSequenceRule.isNegativeOrZero().getRules().get(0).getPredicate().test("0");
        assertTrue(result);

        result = charSequenceRule.isNegativeOrZero(MESSAGE).getRules().get(1).getPredicate().test("0");
        assertTrue(result);
    }

    @Test
    void isNegativeOrZeroFail() {
        boolean result = charSequenceRule.isNegativeOrZero().getRules().get(0).getPredicate().test("1");
        assertFalse(result);

        result = charSequenceRule.isNegativeOrZero(MESSAGE).getRules().get(1).getPredicate().test("1");
        assertFalse(result);
    }

    @Test
    void isNegativeOrZeroNotANumber() {
        boolean result = charSequenceRule.isNegativeOrZero().getRules().get(0).getPredicate().test("X");
        assertFalse(result);

        result = charSequenceRule.isNegativeOrZero(MESSAGE).getRules().get(1).getPredicate().test("X");
        assertFalse(result);
    }

    @Test
    void isNegativeFalse() {
        boolean result = charSequenceRule.isNegative().getRules().get(0).getPredicate().test("1");
        assertFalse(result);

        result = charSequenceRule.isNegative(MESSAGE).getRules().get(1).getPredicate().test("1");
        assertFalse(result);
    }

    @Test
    void isNegativeNotANumber() {
        boolean result = charSequenceRule.isNegative().getRules().get(0).getPredicate().test("a");
        assertFalse(result);

        result = charSequenceRule.isNegative(MESSAGE).getRules().get(1).getPredicate().test("a");
        assertFalse(result);
    }

    @Test
    void matchRegexOk() {
        boolean result = charSequenceRule.matchRegex("^(.+)@(.+)$").getRules().get(0).getPredicate().test("val@validator.com");
        assertTrue(result);

        result = charSequenceRule.matchRegex("^(.+)@(.+)$", MESSAGE).getRules().get(1).getPredicate().test("val@validator.com");
        assertTrue(result);
    }

    @Test
    void matchRegexFail() {
        boolean result = charSequenceRule.matchRegex("^(.+)@(.+)$").getRules().get(0).getPredicate().test("abc");
        assertFalse(result);

        result = charSequenceRule.matchRegex("^(.+)@(.+)$", MESSAGE).getRules().get(1).getPredicate().test("abc");
        assertFalse(result);
    }

    @Test
    void notMatchRegexOk() {
        boolean result = charSequenceRule.notMatchRegex("^(.+)@(.+)$").getRules().get(0).getPredicate().test("asss");
        assertTrue(result);

        result = charSequenceRule.notMatchRegex("^(.+)@(.+)$", MESSAGE).getRules().get(1).getPredicate().test("asss");
        assertTrue(result);
    }

    @Test
    void notMatchRegexFail() {
        boolean result = charSequenceRule.notMatchRegex("^(.+)@(.+)$").getRules().get(0).getPredicate().test("val@validator.com");
        assertFalse(result);

        result = charSequenceRule.notMatchRegex("^(.+)@(.+)$", MESSAGE).getRules().get(1).getPredicate().test("val@validator.com");
        assertFalse(result);
    }

    @Test
    void isValidDateOk() {
        boolean result = charSequenceRule.isValidDate("yyyy/MM/dd").getRules().get(0).getPredicate().test("1993/05/22");
        assertTrue(result);

        result = charSequenceRule.isValidDate("yyyy/MM/dd", MESSAGE).getRules().get(1).getPredicate().test("1993/05/22");
        assertTrue(result);
    }

    @Test
    void isValidDateFail() {
        boolean result = charSequenceRule.isValidDate("yyyy/MM/dd").getRules().get(0).getPredicate().test("22/05/1993");
        assertFalse(result);

        result = charSequenceRule.isValidDate("yyyy/MM/dd", MESSAGE).getRules().get(1).getPredicate().test("22/05/1993");
        assertFalse(result);
    }

    @Test
    void isValidDateInvalid() {
        boolean result = charSequenceRule.isValidDate("yyyy/MM/dd").getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isValidDate("yyyy/MM/dd", MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isValidDateTimeOk() {
        boolean result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm").getRules().get(0).getPredicate().test("1993/05/22 05:00");
        assertTrue(result);

        result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test("1993/05/22 05:00");
        assertTrue(result);
    }

    @Test
    void isValidDateTimeFail() {
        boolean result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm").getRules().get(0).getPredicate().test("22/05/1993");
        assertFalse(result);

        result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test("22/05/1993");
        assertFalse(result);
    }

    @Test
    void isValidDateTimeInvalid() {
        boolean result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm").getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isValidDateTime("yyyy/MM/dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isFutureDateOk() {
        boolean result = charSequenceRule.isFutureDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);

        result = charSequenceRule.isFutureDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentDateOk() {
        boolean result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);

        result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentDateFail() {
        boolean result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);

        result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentDateInvalid() {
        boolean result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("lpo");
        assertFalse(result);

        result = charSequenceRule.isFutureOrPresentDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test("lpo");
        assertFalse(result);
    }

    @Test
    void isFutureDateFail() {
        boolean result = charSequenceRule.isFutureDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);

        result = charSequenceRule.isFutureDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isFutureDateInvalid() {
        boolean result = charSequenceRule.isFutureDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("ABC");
        assertFalse(result);

        result = charSequenceRule.isFutureDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test("ABC");
        assertFalse(result);
    }

    @Test
    void isFutureDateTimeOk() {
        boolean result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);

        result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isFutureDateTimeFail() {
        boolean result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);

        result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isFutureDateTimeInvalid() {
        boolean result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("xp");
        assertFalse(result);

        result = charSequenceRule.isFutureDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test("xp");
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentDateTimeOk() {
        boolean result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);

        result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentDateTimeFail() {
        boolean result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);

        result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentDateTimeInvalid() {
        boolean result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("wasd");
        assertFalse(result);

        result = charSequenceRule.isFutureOrPresentDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test("wasd");
        assertFalse(result);
    }

    @Test
    void isPastDateOk() {
        boolean result = charSequenceRule.isPastDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);

        result = charSequenceRule.isPastDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isPastDateFail() {
        boolean result = charSequenceRule.isPastDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);

        result = charSequenceRule.isPastDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isPastDateInvalid() {
        boolean result = charSequenceRule.isPastDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("ads");
        assertFalse(result);

        result = charSequenceRule.isPastDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test("ads");
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateOk() {
        boolean result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);

        result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertTrue(result);
    }

    @Test
    void isPastOrPresentDateFail() {
        boolean result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);

        result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateInvalid() {
        boolean result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd").getRules().get(0).getPredicate().test("lk");
        assertFalse(result);

        result = charSequenceRule.isPastOrPresentDate("yyyy-MM-dd", MESSAGE).getRules().get(1).getPredicate().test("lk");
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateTimeOk() {
        boolean result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);

        result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isPastOrPresentDateTimeFail() {
        boolean result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);

        result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentDateTimeInvalid() {
        boolean result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("lk");
        assertFalse(result);

        result = charSequenceRule.isPastOrPresentDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test("lk");
        assertFalse(result);
    }

    @Test
    void isPastDateTimeOk() {
        boolean result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);

        result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertTrue(result);
    }

    @Test
    void isPastDateTimeFail() {
        boolean result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);

        result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertFalse(result);
    }

    @Test
    void isPastDateTimeInvalid() {
        boolean result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm").getRules().get(0).getPredicate().test("lk");
        assertFalse(result);

        result = charSequenceRule.isPastDateTime("yyyy-MM-dd HH:mm", MESSAGE).getRules().get(1).getPredicate().test("lk");
        assertFalse(result);
    }

    @Test
    void isDigitOk() {
        boolean result = charSequenceRule.isDigit().getRules().get(0).getPredicate().test("1234");
        assertTrue(result);

        result = charSequenceRule.isDigit(MESSAGE).getRules().get(1).getPredicate().test("1234");
        assertTrue(result);
    }

    @Test
    void isDigitFail() {
        boolean result = charSequenceRule.isDigit().getRules().get(0).getPredicate().test("1234A");
        assertFalse(result);

        result = charSequenceRule.isDigit(MESSAGE).getRules().get(1).getPredicate().test("1234A");
        assertFalse(result);
    }

    @Test
    void notDigitOk() {
        boolean result = charSequenceRule.notDigit().getRules().get(0).getPredicate().test("aaa");
        assertTrue(result);

        result = charSequenceRule.notDigit(MESSAGE).getRules().get(1).getPredicate().test("aaa");
        assertTrue(result);
    }

    @Test
    void notDigitFail() {
        boolean result = charSequenceRule.notDigit().getRules().get(0).getPredicate().test("1234");
        assertFalse(result);

        result = charSequenceRule.notDigit(MESSAGE).getRules().get(1).getPredicate().test("1234");
        assertFalse(result);
    }

    @Test
    void notDigitNull() {
        boolean result = charSequenceRule.notDigit().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.notDigit(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isDigitInvalid() {
        boolean result = charSequenceRule.isDigit().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isDigit(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void containHtmlSuccessTest() {
        boolean result = charSequenceRule.containHtml().getRules().get(0).getPredicate().test("<script>const a = 10</script>");
        assertTrue(result);

        result = charSequenceRule.containHtml(MESSAGE).getRules().get(1).getPredicate().test("<script>const a = 10</script>");
        assertTrue(result);
    }

    @Test
    void containHtmlInvalidTest() {
        boolean result = charSequenceRule.containHtml().getRules().get(0).getPredicate().test("qwerty");
        assertFalse(result);

        result = charSequenceRule.containHtml(MESSAGE).getRules().get(1).getPredicate().test("qwerty");
        assertFalse(result);
    }

    @Test
    void containHtmlWithNullValueTest() {
        boolean result = charSequenceRule.containHtml().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.containHtml(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void containHtmlWithEmptyValueTest() {
        boolean result = charSequenceRule.containHtml().getRules().get(0).getPredicate().test("");
        assertFalse(result);

        result = charSequenceRule.containHtml(MESSAGE).getRules().get(1).getPredicate().test("");
        assertFalse(result);
    }

    @Test
    void notContainHtmlSuccessTest() {
        boolean result = charSequenceRule.notContainHtml().getRules().get(0).getPredicate().test("<script>const a = 10</script>");
        assertFalse(result);

        result = charSequenceRule.notContainHtml(MESSAGE).getRules().get(1).getPredicate().test("<script>const a = 10</script>");
        assertFalse(result);
    }

    @Test
    void notContainHtmlWithNullValueTest() {
        boolean result = charSequenceRule.notContainHtml().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.notContainHtml(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void notContainHtmlWithEmptyValueTest() {
        boolean result = charSequenceRule.notContainHtml().getRules().get(0).getPredicate().test("");
        assertFalse(result);

        result = charSequenceRule.notContainHtml(MESSAGE).getRules().get(1).getPredicate().test("");
        assertFalse(result);
    }

    @Test
    void notContainHtmlInvalidTest() {
        boolean result = charSequenceRule.notContainHtml().getRules().get(0).getPredicate().test("qwerty");
        assertTrue(result);

        result = charSequenceRule.notContainHtml(MESSAGE).getRules().get(1).getPredicate().test("qwerty");
        assertTrue(result);
    }

    @Test
    void isAlphaNumericSuccessTest() {
        boolean result = charSequenceRule.isAlphaNumeric().getRules().get(0).getPredicate().test("ABV12Caah8");
        assertTrue(result);

        result = charSequenceRule.isAlphaNumeric(MESSAGE).getRules().get(1).getPredicate().test("ABV12Caah8");
        assertTrue(result);
    }

    @Test
    void isAlphaNumericInvalidTest() {
        boolean result = charSequenceRule.isAlphaNumeric().getRules().get(0).getPredicate().test("ABV12C@8");
        assertFalse(result);

        result = charSequenceRule.isAlphaNumeric(MESSAGE).getRules().get(1).getPredicate().test("ABV12C@8");
        assertFalse(result);
    }

    @Test
    void isAlphaNumericNullTest() {
        boolean result = charSequenceRule.isAlphaNumeric().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isAlphaNumeric(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isNotAlphaNumericSuccessTest() {
        boolean result = charSequenceRule.isNotAlphaNumeric().getRules().get(0).getPredicate().test("@$%&&***");
        assertTrue(result);

        result = charSequenceRule.isNotAlphaNumeric(MESSAGE).getRules().get(1).getPredicate().test("@$%&&***");
        assertTrue(result);
    }

    @Test
    void isNotAlphaNumericInvalidTest() {
        boolean result = charSequenceRule.isNotAlphaNumeric().getRules().get(0).getPredicate().test("ABC5454Ss");
        assertFalse(result);

        result = charSequenceRule.isNotAlphaNumeric(MESSAGE).getRules().get(1).getPredicate().test("ABC5454Ss");
        assertFalse(result);
    }

    @Test
    void isNotAlphaNumericNullTest() {
        boolean result = charSequenceRule.isNotAlphaNumeric().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isNotAlphaNumeric(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isUUIDV4OkTest() {
        boolean result = charSequenceRule.isUUIDV4().getRules().get(0).getPredicate().test(UUID.randomUUID().toString());
        assertTrue(result);

        result = charSequenceRule.isUUIDV4(MESSAGE).getRules().get(1).getPredicate().test(UUID.randomUUID().toString());
        assertTrue(result);
    }

    @Test
    void isUUIDV4FailTest() {
        boolean result = charSequenceRule.isUUIDV4().getRules().get(0).getPredicate().test("ABC");
        assertFalse(result);

        result = charSequenceRule.isUUIDV4(MESSAGE).getRules().get(1).getPredicate().test("ABC");
        assertFalse(result);
    }

    @Test
    void isUUIDV4NullTest() {
        boolean result = charSequenceRule.isUUIDV4().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = charSequenceRule.isUUIDV4(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }
}
