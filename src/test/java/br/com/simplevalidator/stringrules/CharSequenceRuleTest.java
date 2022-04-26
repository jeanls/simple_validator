package br.com.simplevalidator.stringrules;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharSequenceRuleTest {

    private final CharSequenceRule<String> charSequenceRule = new CharSequenceRule<>();
    private static final String STR_TO_TEST = "validator";

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
}
