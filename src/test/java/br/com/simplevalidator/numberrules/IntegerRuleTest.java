package br.com.simplevalidator.numberrules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerRuleTest {

    private final IntegerRule<Integer> integerIntegerRule = new IntegerRule<>();

    @Test
    void lessThanOkTest() {
        boolean result = integerIntegerRule.lessThan(10).getRules().get(0).getPredicate().test(9);
        assertTrue(result);
    }

    @Test
    void lessThanErrorTest() {
        boolean result = integerIntegerRule.lessThan(10).getRules().get(0).getPredicate().test(10);
        assertFalse(result);
    }

    @Test
    void lessThanOrEqualsOkTest() {
        boolean result = integerIntegerRule.lessThanOrEquals(10).getRules().get(0).getPredicate().test(10);
        assertTrue(result);
    }

    @Test
    void lessThanOrEqualsErrorTest() {
        boolean result = integerIntegerRule.lessThanOrEquals(10).getRules().get(0).getPredicate().test(11);
        assertFalse(result);
    }
}
