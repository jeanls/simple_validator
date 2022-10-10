package io.github.jeanls.simple_validator.listrules;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListRuleTest {

    private final ListRule<List<String>, String> listRule = new ListRule<>();

    @Test
    void notNullOkTest() {
        assertTrue(listRule.notNull().getRules().get(0).getPredicate().test(new ArrayList<>()));
    }

    @Test
    void notNullFailTest() {
        assertFalse(listRule.notNull().getRules().get(0).getPredicate().test(null));
    }

    @Test
    void isNullOkTest() {
        assertTrue(listRule.isNull().getRules().get(0).getPredicate().test(null));
    }

    @Test
    void isNullFailTest() {
        assertFalse(listRule.isNull().getRules().get(0).getPredicate().test(new ArrayList<>()));
    }

    @Test
    void hasSizeOkTest() {
        assertTrue(listRule.hasSize(1).getRules().get(0).getPredicate().test(Collections.singletonList("abc")));
    }

    @Test
    void hasSizeFailTest() {
        assertFalse(listRule.hasSize(2).getRules().get(0).getPredicate().test(Collections.singletonList("lll")));
    }

    @Test
    void hasNotSizeOkTest() {
        assertTrue(listRule.hasNotSize(1).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void hasNotSizeFailTest() {
        assertFalse(listRule.hasNotSize(2).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void greaterThanOkTest() {
        assertTrue(listRule.greaterThan(1).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void greaterThanFailTest() {
        assertFalse(listRule.greaterThan(3).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void greaterThanOrEqualsOkTest() {
        assertTrue(listRule.greaterThanOrEquals(1).getRules().get(0).getPredicate().test(List.of("A")));
    }

    @Test
    void greaterThanOrEqualsFailTest() {
        assertFalse(listRule.greaterThanOrEquals(1).getRules().get(0).getPredicate().test(new ArrayList<>()));
    }

    @Test
    void lessThanOkTest() {
        assertTrue(listRule.lessThan(2).getRules().get(0).getPredicate().test(List.of("A")));
    }

    @Test
    void lessThanFailTest() {
        assertFalse(listRule.lessThan(2).getRules().get(0).getPredicate().test(Arrays.asList("1", "2", "3")));
    }

    @Test
    void lessThanOrEqualsOkTest() {
        assertTrue(listRule.lessThanOrEquals(2).getRules().get(0).getPredicate().test(List.of("A", "B")));
    }

    @Test
    void lessThanOrEqualsFailTest() {
        assertFalse(listRule.lessThanOrEquals(2).getRules().get(0).getPredicate().test(Arrays.asList("1", "2", "3")));
    }
}
