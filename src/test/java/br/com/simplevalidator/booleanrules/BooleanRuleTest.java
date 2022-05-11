package br.com.simplevalidator.booleanrules;

import br.com.simplevalidator.numberrules.NumberRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleanRuleTest {

    private final BooleanRule<Boolean> booleanRule = new BooleanRule<>();

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
