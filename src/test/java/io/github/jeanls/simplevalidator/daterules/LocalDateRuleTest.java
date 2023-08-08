package io.github.jeanls.simplevalidator.daterules;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocalDateRuleTest {

    private final LocalDateRule localDateRule = new LocalDateRule();
    private final String MESSAGE = "abc";

    @Test
    void isAfterOkTest() {
        boolean result = localDateRule.isAfter(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1));
        assertTrue(result);

        result = localDateRule.isAfter(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1));
        assertTrue(result);
    }

    @Test
    void isAfterFailTest() {
        boolean result = localDateRule.isAfter(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1));
        assertFalse(result);

        result = localDateRule.isAfter(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1));
        assertFalse(result);
    }


    @Test
    void isAfterOrEqualsOkTest() {
        boolean result = localDateRule.isAfterOrEquals(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now());
        assertTrue(result);

        result = localDateRule.isAfterOrEquals(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now());
        assertTrue(result);
    }

    @Test
    void isAfterOrEqualsFailTest() {
        boolean result = localDateRule.isAfterOrEquals(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1));
        assertFalse(result);

        result = localDateRule.isAfterOrEquals(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1));
        assertFalse(result);
    }

    @Test
    void isBeforeOrEqualsOkTest() {
        boolean result = localDateRule.isBeforeOrEquals(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now());
        assertTrue(result);

        result = localDateRule.isBeforeOrEquals(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now());
        assertTrue(result);
    }

    @Test
    void isBeforeOrEqualsFailTest() {
        boolean result = localDateRule.isBeforeOrEquals(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1));
        assertFalse(result);

        result = localDateRule.isBeforeOrEquals(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1));
        assertFalse(result);
    }


    @Test
    void isBeforeOkTest() {
        boolean result = localDateRule.isBefore(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1));
        assertTrue(result);

        result = localDateRule.isBefore(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now().minusDays(1));
        assertTrue(result);
    }

    @Test
    void isBeforeFailTest() {
        boolean result = localDateRule.isBefore(LocalDate.now()).getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1));
        assertFalse(result);

        result = localDateRule.isBefore(LocalDate.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDate.now().plusDays(1));
        assertFalse(result);
    }

    @Test
    void isNullOkTest() {
        boolean result = localDateRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);

        result = localDateRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = localDateRule.isNull().getRules().get(0).getPredicate().test(LocalDate.now());
        assertFalse(result);

        result = localDateRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now());
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = localDateRule.notNull().getRules().get(0).getPredicate().test(LocalDate.now());
        assertTrue(result);

        result = localDateRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(LocalDate.now());
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = localDateRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = localDateRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void equalsToOkTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.equalsTo(now).getRules().get(0).getPredicate().test(now);
        assertTrue(result);

        result = localDateRule.equalsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.equalsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertFalse(result);

        result = localDateRule.equalsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now.plusDays(1));
        assertFalse(result);
    }

    @Test
    void equalsToNullTest() {
        LocalDate now = LocalDate.now();
        assertFalse(localDateRule.equalsTo(now).getRules().get(0).getPredicate().test(null));
        assertFalse(localDateRule.equalsTo(now, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void notEqualsToOkTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertTrue(result);

        result = localDateRule.notEqualsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now.plusDays(1));
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        LocalDate now = LocalDate.now();
        boolean result = localDateRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now);
        assertFalse(result);

        result = localDateRule.notEqualsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now);
        assertFalse(result);
    }

    @Test
    void notEqualsToNullTest() {
        LocalDate now = LocalDate.now();
        assertFalse(localDateRule.notEqualsTo(now).getRules().get(0).getPredicate().test(null));
        assertFalse(localDateRule.notEqualsTo(now, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isFutureOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFuture().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertTrue(result);

        result = localDateRule.isFuture(MESSAGE).getRules().get(1).getPredicate().test(localDate.plusDays(1));
        assertTrue(result);
    }

    @Test
    void isFutureFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFuture().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);

        result = localDateRule.isFuture(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isFutureNullTest() {
        assertFalse(localDateRule.isFuture().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateRule.isFuture(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isPastOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPast().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertTrue(result);

        result = localDateRule.isPast(MESSAGE).getRules().get(1).getPredicate().test(localDate.minusDays(1));
        assertTrue(result);
    }

    @Test
    void isPastFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPast().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);

        result = localDateRule.isPast(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isPastNullTest() {
        assertFalse(localDateRule.isPast().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateRule.isPast(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isFutureOrPresentOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);

        result = localDateRule.isFutureOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertFalse(result);

        result = localDateRule.isFutureOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate.minusDays(1));
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentNullTest() {
        assertFalse(localDateRule.isFutureOrPresent().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateRule.isFutureOrPresent(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isPastOrPresentOkTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);

        result = localDateRule.isPastOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isPastOrPresentFailTest() {
        LocalDate localDate = LocalDate.now();
        boolean result = localDateRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertFalse(result);

        result = localDateRule.isPastOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate.plusDays(1));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentNullTest() {
        assertFalse(localDateRule.isPastOrPresent().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateRule.isPastOrPresent(MESSAGE).getRules().get(1).getPredicate().test(null));
    }
}
