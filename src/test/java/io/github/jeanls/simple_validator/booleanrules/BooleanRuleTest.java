package io.github.jeanls.simple_validator.booleanrules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BooleanRuleTest {

    private final BooleanRule<Boolean> booleanRule = new BooleanRule<>();

    @Test
    void equalsToOkTest() {
        boolean result = booleanRule.equalsTo(true).getRules().get(0).getPredicate().test(true);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        boolean result = booleanRule.equalsTo(true).getRules().get(0).getPredicate().test(false);
        assertFalse(result);
    }

    @Test
    void notEqualsToOkTest() {
        boolean result = booleanRule.notEqualsTo(true).getRules().get(0).getPredicate().test(false);
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        boolean result = booleanRule.notEqualsTo(true).getRules().get(0).getPredicate().test(true);
        assertFalse(result);
    }

    @Test
    void isNullOkTest() {
        boolean result = booleanRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = booleanRule.isNull().getRules().get(0).getPredicate().test(true);
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = booleanRule.notNull().getRules().get(0).getPredicate().test(false);
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = booleanRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isTrueOkTest() {
        boolean result = booleanRule.isTrue().getRules().get(0).getPredicate().test(true);
        assertTrue(result);
    }

    @Test
    void isTrueFailTest() {
        boolean result = booleanRule.isTrue().getRules().get(0).getPredicate().test(false);
        assertFalse(result);
    }

    @Test
    void isFalseOkTest() {
        boolean result = booleanRule.isFalse().getRules().get(0).getPredicate().test(false);
        assertTrue(result);
    }

    @Test
    void isFalseFailTest() {
        boolean result = booleanRule.isFalse().getRules().get(0).getPredicate().test(true);
        assertFalse(result);
    }
}
