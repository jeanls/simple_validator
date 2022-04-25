package br.com.simplevalidator.stringrules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharSequenceRuleTest {

    private final CharSequenceRule<String> charSequenceRule = new CharSequenceRule<>();

    @Test
    void startsWithOk() {
        boolean result = charSequenceRule.startsWith("va").getRules().get(0).getPredicate().test("validator");
        assertTrue(result);
    }

    @Test
    void startsWithFail() {
        boolean result = charSequenceRule.startsWith("or").getRules().get(0).getPredicate().test("validator");
        assertFalse(result);
    }

    @Test
    void endsWithOk() {
        boolean result = charSequenceRule.endsWith("or").getRules().get(0).getPredicate().test("validator");
        assertTrue(result);
    }

    @Test
    void endsWithFail() {
        boolean result = charSequenceRule.endsWith("va").getRules().get(0).getPredicate().test("validator");
        assertFalse(result);
    }

    @Test
    void containsOk() {
        boolean result = charSequenceRule.contains("dat").getRules().get(0).getPredicate().test("validator");
        assertTrue(result);
    }

    @Test
    void containsFail() {
        boolean result = charSequenceRule.contains("kkk").getRules().get(0).getPredicate().test("validator");
        assertFalse(result);
    }

    @Test
    void lessThanOk() {
        boolean result = charSequenceRule.lessThan(10).getRules().get(0).getPredicate().test("validator");
        assertTrue(result);
    }

    @Test
    void lessThanOkFail() {
        boolean result = charSequenceRule.lessThan(8).getRules().get(0).getPredicate().test("validator");
        assertFalse(result);
    }

    @Test
    void lessThanOrEqualsOk() {
        boolean result = charSequenceRule.lessThanOrEquals(9).getRules().get(0).getPredicate().test("validator");
        assertTrue(result);
    }

    @Test
    void lessThanOrEqualsFail() {
        boolean result = charSequenceRule.lessThanOrEquals(8).getRules().get(0).getPredicate().test("validator");
        assertFalse(result);
    }

    @Test
    void greaterThanOk() {
        boolean result = charSequenceRule.greaterThan(8).getRules().get(0).getPredicate().test("validator");
        assertTrue(result);
    }

    @Test
    void greaterThanFail() {
        boolean result = charSequenceRule.greaterThan(10).getRules().get(0).getPredicate().test("validator");
        assertFalse(result);
    }

    @Test
    void greaterThanOrEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void in() {
    }

    @Test
    void notBlank() {
    }

    @Test
    void email() {
    }

    @Test
    void isNumeric() {
    }

    @Test
    void notNull() {
    }

    @Test
    void equalsTo() {
    }
}
