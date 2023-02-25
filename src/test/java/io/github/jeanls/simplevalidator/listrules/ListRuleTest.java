package io.github.jeanls.simplevalidator.listrules;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListRuleTest {

    private final ListRule<List<String>, String> listRule = new ListRule<>();
    private final String MESSAGE = "abc";

    @Test
    void notNullOkTest() {
        assertTrue(listRule.notNull().getRules().get(0).getPredicate().test(new ArrayList<>()));
        assertTrue(listRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(new ArrayList<>()));
    }

    @Test
    void notNullFailTest() {
        assertFalse(listRule.notNull().getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isNullOkTest() {
        assertTrue(listRule.isNull().getRules().get(0).getPredicate().test(null));
        assertTrue(listRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isNullFailTest() {
        assertFalse(listRule.isNull().getRules().get(0).getPredicate().test(new ArrayList<>()));
        assertFalse(listRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(new ArrayList<>()));
    }

    @Test
    void hasSizeOkTest() {
        assertTrue(listRule.hasSize(1).getRules().get(0).getPredicate().test(Collections.singletonList("abc")));
        assertTrue(listRule.hasSize(1, MESSAGE).getRules().get(1).getPredicate().test(Collections.singletonList("abc")));
    }

    @Test
    void hasSizeFailTest() {
        assertFalse(listRule.hasSize(2).getRules().get(0).getPredicate().test(Collections.singletonList("lll")));
        assertFalse(listRule.hasSize(2, MESSAGE).getRules().get(1).getPredicate().test(Collections.singletonList("lll")));
    }

    @Test
    void hasSizeNullTest() {
        assertFalse(listRule.hasSize(1).getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.hasSize(1, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void hasNotSizeOkTest() {
        assertTrue(listRule.hasNotSize(1).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
        assertTrue(listRule.hasNotSize(1, MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void hasNotSizeFailTest() {
        assertFalse(listRule.hasNotSize(2).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
        assertFalse(listRule.hasNotSize(2, MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void hasNotSizeNullTest() {
        assertFalse(listRule.hasNotSize(1).getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.hasNotSize(1, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void greaterThanOkTest() {
        assertTrue(listRule.greaterThan(1).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
        assertTrue(listRule.greaterThan(1, MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void greaterThanFailTest() {
        assertFalse(listRule.greaterThan(3).getRules().get(0).getPredicate().test(Arrays.asList("1", "2")));
        assertFalse(listRule.greaterThan(3, MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2")));
    }

    @Test
    void greaterThanNullTest() {
        assertFalse(listRule.greaterThan(1).getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.greaterThan(1, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void greaterThanOrEqualsOkTest() {
        assertTrue(listRule.greaterThanOrEquals(1).getRules().get(0).getPredicate().test(List.of("A")));
        assertTrue(listRule.greaterThanOrEquals(1, MESSAGE).getRules().get(1).getPredicate().test(List.of("A")));
    }

    @Test
    void greaterThanOrEqualsFailTest() {
        assertFalse(listRule.greaterThanOrEquals(1).getRules().get(0).getPredicate().test(new ArrayList<>()));
        assertFalse(listRule.greaterThanOrEquals(1, MESSAGE).getRules().get(1).getPredicate().test(new ArrayList<>()));
    }

    @Test
    void greaterThanOrEqualsNullTest() {
        assertFalse(listRule.greaterThanOrEquals(1).getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.greaterThanOrEquals(1, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void lessThanOkTest() {
        assertTrue(listRule.lessThan(2).getRules().get(0).getPredicate().test(List.of("A")));
        assertTrue(listRule.lessThan(2, MESSAGE).getRules().get(1).getPredicate().test(List.of("A")));
    }

    @Test
    void lessThanFailTest() {
        assertFalse(listRule.lessThan(2).getRules().get(0).getPredicate().test(Arrays.asList("1", "2", "3")));
        assertFalse(listRule.lessThan(2, MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2", "3")));
    }

    @Test
    void lessThanNullTest() {
        assertFalse(listRule.lessThan(1).getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.lessThan(1, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void lessThanOrEqualsOkTest() {
        assertTrue(listRule.lessThanOrEquals(2).getRules().get(0).getPredicate().test(List.of("A", "B")));
        assertTrue(listRule.lessThanOrEquals(2, MESSAGE).getRules().get(1).getPredicate().test(List.of("A", "B")));
    }

    @Test
    void lessThanOrEqualsFailTest() {
        assertFalse(listRule.lessThanOrEquals(2).getRules().get(0).getPredicate().test(Arrays.asList("1", "2", "3")));
        assertFalse(listRule.lessThanOrEquals(2, MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2", "3")));
    }

    @Test
    void lessThanOrEqualsNullTest() {
        assertFalse(listRule.lessThanOrEquals(1).getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.lessThanOrEquals(1, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void notContainsItemOkTest() {
        assertTrue(listRule.notContainsItem("C").getRules().get(0).getPredicate().test(List.of("A", "B")));
        assertTrue(listRule.notContainsItem("C", MESSAGE).getRules().get(1).getPredicate().test(List.of("A", "B")));
    }

    @Test
    void notContainsItemFailTest() {
        assertFalse(listRule.notContainsItem("1").getRules().get(0).getPredicate().test(Arrays.asList("1", "2", "3")));
        assertFalse(listRule.notContainsItem("1", MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2", "3")));
    }

    @Test
    void notContainsItemNullTest() {
        assertFalse(listRule.notContainsItem("1").getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.notContainsItem("1", MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void containsItemOkTest() {
        assertTrue(listRule.containsItem("A").getRules().get(0).getPredicate().test(List.of("A", "B")));
        assertTrue(listRule.containsItem("A", MESSAGE).getRules().get(1).getPredicate().test(List.of("A", "B")));
    }

    @Test
    void containsItemFailTest() {
        assertFalse(listRule.containsItem("4").getRules().get(0).getPredicate().test(Arrays.asList("1", "2", "3")));
        assertFalse(listRule.containsItem("4", MESSAGE).getRules().get(1).getPredicate().test(Arrays.asList("1", "2", "3")));
    }

    @Test
    void containsItemNullTest() {
        assertFalse(listRule.containsItem("4").getRules().get(0).getPredicate().test(null));
        assertFalse(listRule.containsItem("3", MESSAGE).getRules().get(1).getPredicate().test(null));
    }
}
