package io.github.jeanls.simple_validator.numberrules;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberRuleTest {

    private final NumberRule<Number> integerNumberRule = new NumberRule<>();

    @Test
    void lessThanOkTest() {
        boolean result = integerNumberRule.lessThan(10).getRules().get(0).getPredicate().test(9);
        assertTrue(result);
    }

    @Test
    void lessThanErrorTest() {
        boolean result = integerNumberRule.lessThan(10).getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void lessThanOrEqualsOkTest() {
        boolean result = integerNumberRule.lessThanOrEquals(10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void lessThanOrEqualsErrorTest() {
        boolean result = integerNumberRule.lessThanOrEquals(10).getRules().get(0).getPredicate().test(11);
        assertFalse(result);
    }

    @Test
    void greaterThanOkTest() {
        boolean result = integerNumberRule.greaterThan(9).getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void greaterThanFailTest() {
        boolean result = integerNumberRule.greaterThan(10).getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void greaterThanOrEqualsOkTest() {
        boolean result = integerNumberRule.greaterThanOrEquals(10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void greaterThanOrEqualsFailTest() {
        boolean result = integerNumberRule.greaterThanOrEquals(11).getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = integerNumberRule.notNull().getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = integerNumberRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isNullOkTest() {
        boolean result = integerNumberRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = integerNumberRule.isNull().getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void equalsToOkTest() {
        boolean result = integerNumberRule.equalsTo(10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        boolean result = integerNumberRule.equalsTo(10).getRules().get(0).getPredicate().test(20);
        assertFalse(result);
    }

    @Test
    void notEqualsToOkTest() {
        boolean result = integerNumberRule.notEqualsTo(10).getRules().get(0).getPredicate().test(11);
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        boolean result = integerNumberRule.notEqualsTo(10).getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void isPositiveOkTest() {
        boolean result = integerNumberRule.isPositive().getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void isPositiveFailTest() {
        boolean result = integerNumberRule.isPositive().getRules().get(0).getPredicate().test(0);
        assertFalse(result);
    }

    @Test
    void isPositiveOrZeroOkTest() {
        boolean result = integerNumberRule.isPositiveOrZero().getRules().get(0).getPredicate().test(0);
        assertTrue(result);
    }

    @Test
    void isPositiveOrZeroFailTest() {
        boolean result = integerNumberRule.isPositiveOrZero().getRules().get(0).getPredicate().test(-1);
        assertFalse(result);
    }

    @Test
    void isNegativeOkTest() {
        boolean result = integerNumberRule.isNegative().getRules().get(0).getPredicate().test(-1);
        assertTrue(result);
    }

    @Test
    void isNegativeFailTest() {
        boolean result = integerNumberRule.isNegative().getRules().get(0).getPredicate().test(0);
        assertFalse(result);
    }

    @Test
    void isNegativeOrZeroOkTest() {
        boolean result = integerNumberRule.isNegativeOrZero().getRules().get(0).getPredicate().test(0);
        assertTrue(result);
    }

    @Test
    void isNegativeOrZeroFailTest() {
        boolean result = integerNumberRule.isNegativeOrZero().getRules().get(0).getPredicate().test(1);
        assertFalse(result);
    }

    @Test
    void betweenOkTest() {
        boolean result = integerNumberRule.between(9, 10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void betweenFailTest() {
        boolean result = integerNumberRule.between(8, 9).getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void notBetweenOkTest() {
        boolean result = integerNumberRule.notBetween(9, 10).getRules().get(0).getPredicate().test(8);
        assertTrue(result);
    }

    @Test
    void notBetweenFailTest() {
        boolean result = integerNumberRule.notBetween(8, 9).getRules().get(0).getPredicate().test(8);
        assertFalse(result);
    }

    @Test
    void inListOkTest() {
        boolean result = integerNumberRule.inList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void inListFailTest() {
        boolean result = integerNumberRule.inList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(8);
        assertFalse(result);
    }

    @Test
    void notInListOkTest() {
        boolean result = integerNumberRule.notInList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(5);
        assertTrue(result);
    }

    @Test
    void notInListFailTest() {
        boolean result = integerNumberRule.notInList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }
}
