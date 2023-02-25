package io.github.jeanls.simplevalidator.numberrules;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberRuleTest {

    private final NumberRule<Number> integerNumberRule = new NumberRule<>();
    private final String MESSAGE = "abcd";

    @Test
    void lessThanOkTest() {
        boolean result = integerNumberRule.lessThan(10).getRules().get(0).getPredicate().test(9);
        assertTrue(result);

        result = integerNumberRule.lessThan(10, MESSAGE).getRules().get(1).getPredicate().test(9);
        assertTrue(result);
    }

    @Test
    void lessThanErrorTest() {
        boolean result = integerNumberRule.lessThan(10).getRules().get(0).getPredicate().test(10);
        assertFalse(result);

        result = integerNumberRule.lessThan(10, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void lessThanNullTest() {
        assertFalse(integerNumberRule.lessThan(10).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.lessThan(10, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void lessThanOrEqualsOkTest() {
        boolean result = integerNumberRule.lessThanOrEquals(10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.lessThanOrEquals(10, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void lessThanOrEqualsErrorTest() {
        boolean result = integerNumberRule.lessThanOrEquals(10).getRules().get(0).getPredicate().test(11);
        assertFalse(result);

        result = integerNumberRule.lessThanOrEquals(10, MESSAGE).getRules().get(1).getPredicate().test(11);
        assertFalse(result);
    }

    @Test
    void lessThanOrEqualsNullTest() {
        assertFalse(integerNumberRule.lessThanOrEquals(10).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.lessThanOrEquals(10, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void greaterThanOkTest() {
        boolean result = integerNumberRule.greaterThan(9).getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.greaterThan(9, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void greaterThanFailTest() {
        boolean result = integerNumberRule.greaterThan(10).getRules().get(0).getPredicate().test(10);
        assertFalse(result);

        result = integerNumberRule.greaterThan(10, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void greaterThanNullTest() {
        assertFalse(integerNumberRule.greaterThan(10).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.greaterThan(10, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void greaterThanOrEqualsOkTest() {
        boolean result = integerNumberRule.greaterThanOrEquals(10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.greaterThanOrEquals(10, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void greaterThanOrEqualsFailTest() {
        boolean result = integerNumberRule.greaterThanOrEquals(11).getRules().get(0).getPredicate().test(10);
        assertFalse(result);

        result = integerNumberRule.greaterThanOrEquals(11, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void greaterThanOrEqualsNullTest() {
        assertFalse(integerNumberRule.greaterThanOrEquals(10).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.greaterThanOrEquals(10, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void notNullOkTest() {
        boolean result = integerNumberRule.notNull().getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = integerNumberRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = integerNumberRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void isNullOkTest() {
        boolean result = integerNumberRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);

        result = integerNumberRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = integerNumberRule.isNull().getRules().get(0).getPredicate().test(10);
        assertFalse(result);

        result = integerNumberRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void equalsToOkTest() {
        boolean result = integerNumberRule.equalsTo(10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.equalsTo(10, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        boolean result = integerNumberRule.equalsTo(10).getRules().get(0).getPredicate().test(20);
        assertFalse(result);

        result = integerNumberRule.equalsTo(10, MESSAGE).getRules().get(1).getPredicate().test(20);
        assertFalse(result);
    }

    @Test
    void equalsToNullTest() {
        assertFalse(integerNumberRule.equalsTo(10).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.equalsTo(10, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void notEqualsToOkTest() {
        boolean result = integerNumberRule.notEqualsTo(10).getRules().get(0).getPredicate().test(11);
        assertTrue(result);

        result = integerNumberRule.notEqualsTo(10, MESSAGE).getRules().get(1).getPredicate().test(11);
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        boolean result = integerNumberRule.notEqualsTo(10).getRules().get(0).getPredicate().test(10);
        assertFalse(result);

        result = integerNumberRule.notEqualsTo(10, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void notEqualsToNullTest() {
        assertFalse(integerNumberRule.notEqualsTo(10).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.notEqualsTo(10, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isPositiveOkTest() {
        boolean result = integerNumberRule.isPositive().getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.isPositive(MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void isPositiveFailTest() {
        boolean result = integerNumberRule.isPositive().getRules().get(0).getPredicate().test(0);
        assertFalse(result);

        result = integerNumberRule.isPositive(MESSAGE).getRules().get(1).getPredicate().test(0);
        assertFalse(result);
    }

    @Test
    void isPositiveNullTest() {
        assertFalse(integerNumberRule.isPositive().getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.isPositive(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isPositiveOrZeroOkTest() {
        boolean result = integerNumberRule.isPositiveOrZero().getRules().get(0).getPredicate().test(0);
        assertTrue(result);

        result = integerNumberRule.isPositiveOrZero(MESSAGE).getRules().get(1).getPredicate().test(0);
        assertTrue(result);
    }

    @Test
    void isPositiveOrZeroFailTest() {
        boolean result = integerNumberRule.isPositiveOrZero().getRules().get(0).getPredicate().test(-1);
        assertFalse(result);

        result = integerNumberRule.isPositiveOrZero(MESSAGE).getRules().get(1).getPredicate().test(-1);
        assertFalse(result);
    }

    @Test
    void isPositiveOrZeroNullTest() {
        assertFalse(integerNumberRule.isPositiveOrZero().getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.isPositiveOrZero(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isNegativeOkTest() {
        boolean result = integerNumberRule.isNegative().getRules().get(0).getPredicate().test(-1);
        assertTrue(result);

        result = integerNumberRule.isNegative(MESSAGE).getRules().get(1).getPredicate().test(-1);
        assertTrue(result);
    }

    @Test
    void isNegativeFailTest() {
        boolean result = integerNumberRule.isNegative().getRules().get(0).getPredicate().test(0);
        assertFalse(result);

        result = integerNumberRule.isNegative(MESSAGE).getRules().get(1).getPredicate().test(0);
        assertFalse(result);
    }

    @Test
    void isNegativeNullTest() {
        assertFalse(integerNumberRule.isNegative().getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.isNegative(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isNegativeOrZeroOkTest() {
        boolean result = integerNumberRule.isNegativeOrZero().getRules().get(0).getPredicate().test(0);
        assertTrue(result);

        result = integerNumberRule.isNegativeOrZero(MESSAGE).getRules().get(1).getPredicate().test(0);
        assertTrue(result);
    }

    @Test
    void isNegativeOrZeroFailTest() {
        boolean result = integerNumberRule.isNegativeOrZero().getRules().get(0).getPredicate().test(1);
        assertFalse(result);

        result = integerNumberRule.isNegativeOrZero(MESSAGE).getRules().get(1).getPredicate().test(1);
        assertFalse(result);
    }

    @Test
    void isNegativeOrZeroNullTest() {
        assertFalse(integerNumberRule.isNegativeOrZero().getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.isNegativeOrZero(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void betweenOkTest() {
        boolean result = integerNumberRule.between(9, 10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.between(9, 10, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void betweenFailTest() {
        boolean result = integerNumberRule.between(8, 9).getRules().get(0).getPredicate().test(10);
        assertFalse(result);

        result = integerNumberRule.between(8, 9, MESSAGE).getRules().get(1).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void betweenNullTest() {
        assertFalse(integerNumberRule.between(1, 2).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.between(1, 2, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void notBetweenOkTest() {
        boolean result = integerNumberRule.notBetween(9, 10).getRules().get(0).getPredicate().test(8);
        assertTrue(result);

        result = integerNumberRule.notBetween(9, 10, MESSAGE).getRules().get(1).getPredicate().test(8);
        assertTrue(result);
    }

    @Test
    void notBetweenFailTest() {
        boolean result = integerNumberRule.notBetween(8, 9).getRules().get(0).getPredicate().test(8);
        assertFalse(result);

        result = integerNumberRule.notBetween(8, 9, MESSAGE).getRules().get(1).getPredicate().test(8);
        assertFalse(result);
    }

    @Test
    void notBetweenNullTest() {
        assertFalse(integerNumberRule.notBetween(1, 2).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.notBetween(1, 2, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void inListOkTest() {
        boolean result = integerNumberRule.inList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(10);
        assertTrue(result);

        result = integerNumberRule.inList(Arrays.asList(10, 20), MESSAGE).getRules().get(1).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void inListFailTest() {
        boolean result = integerNumberRule.inList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(8);
        assertFalse(result);

        result = integerNumberRule.inList(Arrays.asList(10, 20), MESSAGE).getRules().get(1).getPredicate().test(8);
        assertFalse(result);
    }

    @Test
    void inListNullTest() {
        assertFalse(integerNumberRule.inList(Arrays.asList(1, 2)).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.inList(Arrays.asList(1, 2), MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void notInListOkTest() {
        boolean result = integerNumberRule.notInList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(5);
        assertTrue(result);

        result = integerNumberRule.notInList(Arrays.asList(10, 20), MESSAGE).getRules().get(1).getPredicate().test(5);
        assertTrue(result);
    }

    @Test
    void notInListFailTest() {
        boolean result = integerNumberRule.notInList(Arrays.asList(10, 20)).getRules().get(0).getPredicate().test(10);
        assertFalse(result);

        result = integerNumberRule.notInList(Arrays.asList(10, 20), MESSAGE).getRules().get(1).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void notInListNullTest() {
        assertFalse(integerNumberRule.notInList(Arrays.asList(1, 2)).getRules().get(0).getPredicate().test(null));
        assertFalse(integerNumberRule.notInList(Arrays.asList(1, 2), MESSAGE).getRules().get(1).getPredicate().test(null));
    }
}
