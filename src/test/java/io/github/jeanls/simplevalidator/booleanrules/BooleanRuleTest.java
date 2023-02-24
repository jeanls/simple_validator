package io.github.jeanls.simplevalidator.booleanrules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BooleanRuleTest {

    private final BooleanRule booleanRule = new BooleanRule();
    private final String MESSAGE = "abc";

    @Test
    void equalsToOkTest() {
        boolean result = booleanRule.equalsTo(true).getRules().get(0).getPredicate().test(true);
        assertTrue(result);

        result = booleanRule.equalsTo(true, MESSAGE).getRules().get(1).getPredicate().test(true);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        boolean result = booleanRule.equalsTo(true).getRules().get(0).getPredicate().test(false);
        assertFalse(result);

        result = booleanRule.equalsTo(true, MESSAGE).getRules().get(1).getPredicate().test(false);
        assertFalse(result);
    }

    @Test
    void notEqualsToOkTest() {
        boolean result = booleanRule.notEqualsTo(true).getRules().get(0).getPredicate().test(false);
        assertTrue(result);

        result = booleanRule.notEqualsTo(true, MESSAGE).getRules().get(1).getPredicate().test(false);
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        boolean result = booleanRule.notEqualsTo(true).getRules().get(0).getPredicate().test(true);
        assertFalse(result);

        result = booleanRule.notEqualsTo(true, MESSAGE).getRules().get(1).getPredicate().test(true);
        assertFalse(result);
    }

    @Test
    void isNullOkTest() {
        boolean result = booleanRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);

        result = booleanRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = booleanRule.isNull().getRules().get(0).getPredicate().test(true);
        assertFalse(result);

        result = booleanRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(true);
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = booleanRule.notNull().getRules().get(0).getPredicate().test(false);
        assertTrue(result);

        result = booleanRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(false);
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = booleanRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = booleanRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isTrueOkTest() {
        boolean result = booleanRule.isTrue().getRules().get(0).getPredicate().test(true);
        assertTrue(result);

        result = booleanRule.isTrue(MESSAGE).getRules().get(1).getPredicate().test(true);
        assertTrue(result);
    }

    @Test
    void isTrueFailTest() {
        boolean result = booleanRule.isTrue().getRules().get(0).getPredicate().test(false);
        assertFalse(result);

        result = booleanRule.isTrue(MESSAGE).getRules().get(1).getPredicate().test(false);
        assertFalse(result);
    }

    @Test
    void isFalseOkTest() {
        boolean result = booleanRule.isFalse().getRules().get(0).getPredicate().test(false);
        assertTrue(result);

        result = booleanRule.isFalse(MESSAGE).getRules().get(1).getPredicate().test(false);
        assertTrue(result);
    }

    @Test
    void isFalseFailTest() {
        boolean result = booleanRule.isFalse().getRules().get(0).getPredicate().test(true);
        assertFalse(result);

        result = booleanRule.isFalse(MESSAGE).getRules().get(1).getPredicate().test(true);
        assertFalse(result);
    }
}
