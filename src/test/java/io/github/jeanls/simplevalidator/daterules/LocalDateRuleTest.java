package io.github.jeanls.simplevalidator.daterules;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocalDateRuleTest {

    private final LocalDateRule<LocalDate> localDateRule = new LocalDateRule<>();

    @Test
    void isNullOkTest() {
        boolean result = localDateRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = localDateRule.isNull().getRules().get(0).getPredicate().test(LocalDate.now());
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = localDateRule.notNull().getRules().get(0).getPredicate().test(LocalDate.now());
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = localDateRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void equalsToOkTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.equalsTo(now).getRules().get(0).getPredicate().test(now);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.equalsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertFalse(result);
    }

    @Test
    void notEqualsToOkTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now);
        assertFalse(result);
    }

    @Test
    void isFutureOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFuture().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertTrue(result);
    }

    @Test
    void isFutureFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFuture().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isPastOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPast().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertTrue(result);
    }

    @Test
    void isPastFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPast().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isPastOrPresentFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertFalse(result);
    }
}
