package io.github.jeanls.simplevalidator.objectrules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObjectRuleTest {

    private final ObjectRule<String> objectRule = new ObjectRule<>();

    @Test
    void notNullOkTest() {
        boolean result = objectRule.notNull().getRules().get(0).getPredicate().test("!642");
        assertTrue(result);

        result = objectRule.notNull("abc").getRules().get(0).getPredicate().test("4d5a4");
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = objectRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = objectRule.notNull("abc").getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }
}
