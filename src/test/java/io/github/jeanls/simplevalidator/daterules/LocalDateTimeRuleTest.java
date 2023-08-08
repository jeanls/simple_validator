package io.github.jeanls.simplevalidator.daterules;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocalDateTimeRuleTest {

    private final LocalDateTimeRule localDateTimeRule = new LocalDateTimeRule();
    private final String MESSAGE = "sad";


    @Test
    void isAfterOkTest() {
        boolean result = localDateTimeRule.isAfter(LocalDateTime.now()).getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1));
        assertTrue(result);

        result = localDateTimeRule.isAfter(LocalDateTime.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1));
        assertTrue(result);
    }

    @Test
    void isAfterFailTest() {
        boolean result = localDateTimeRule.isAfter(LocalDateTime.now()).getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1));
        assertFalse(result);

        result = localDateTimeRule.isAfter(LocalDateTime.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1));
        assertFalse(result);
    }


    @Test
    void isAfterOrEqualsOkTest() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        boolean result = localDateTimeRule.isAfterOrEquals(localDateTimeNow).getRules().get(0).getPredicate().test(localDateTimeNow);
        assertTrue(result);

        result = localDateTimeRule.isAfterOrEquals(localDateTimeNow, MESSAGE).getRules().get(0).getPredicate().test(localDateTimeNow);
        assertTrue(result);
    }

    @Test
    void isAfterOrEqualsFailTest() {
        boolean result = localDateTimeRule.isAfterOrEquals(LocalDateTime.now()).getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1));
        assertFalse(result);

        result = localDateTimeRule.isAfterOrEquals(LocalDateTime.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1));
        assertFalse(result);
    }

    @Test
    void isBeforeOrEqualsOkTest() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();

        boolean result = localDateTimeRule.isBeforeOrEquals(localDateTimeNow).getRules().get(0).getPredicate().test(localDateTimeNow);
        assertTrue(result);

        result = localDateTimeRule.isBeforeOrEquals(localDateTimeNow, MESSAGE).getRules().get(0).getPredicate().test(localDateTimeNow);
        assertTrue(result);
    }

    @Test
    void isBeforeOrEqualsFailTest() {
        boolean result = localDateTimeRule.isBeforeOrEquals(LocalDateTime.now()).getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1));
        assertFalse(result);

        result = localDateTimeRule.isBeforeOrEquals(LocalDateTime.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1));
        assertFalse(result);
    }


    @Test
    void isBeforeOkTest() {
        boolean result = localDateTimeRule.isBefore(LocalDateTime.now()).getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1));
        assertTrue(result);

        result = localDateTimeRule.isBefore(LocalDateTime.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDateTime.now().minusDays(1));
        assertTrue(result);
    }

    @Test
    void isBeforeFailTest() {
        boolean result = localDateTimeRule.isBefore(LocalDateTime.now()).getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1));
        assertFalse(result);

        result = localDateTimeRule.isBefore(LocalDateTime.now(), MESSAGE).getRules().get(0).getPredicate().test(LocalDateTime.now().plusDays(1));
        assertFalse(result);
    }

    @Test
    void isNullOkTest() {
        boolean result = localDateTimeRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);

        result = localDateTimeRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = localDateTimeRule.isNull().getRules().get(0).getPredicate().test(LocalDateTime.now());
        assertFalse(result);

        result = localDateTimeRule.isNull(MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now());
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = localDateTimeRule.notNull().getRules().get(0).getPredicate().test(LocalDateTime.now());
        assertTrue(result);

        result = localDateTimeRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(LocalDateTime.now());
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = localDateTimeRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);

        result = localDateTimeRule.notNull(MESSAGE).getRules().get(1).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void equalsToOkTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.equalsTo(now).getRules().get(0).getPredicate().test(now);
        assertTrue(result);

        result = localDateTimeRule.equalsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.equalsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertFalse(result);

        result = localDateTimeRule.equalsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now.plusDays(1));
        assertFalse(result);
    }

    @Test
    void equalsToNullTest() {
        LocalDateTime now = LocalDateTime.now();
        assertFalse(localDateTimeRule.equalsTo(now).getRules().get(0).getPredicate().test(null));
        assertFalse(localDateTimeRule.equalsTo(now, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void notEqualsToOkTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertTrue(result);

        result = localDateTimeRule.notEqualsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now.plusDays(1));
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now);
        assertFalse(result);

        result = localDateTimeRule.notEqualsTo(now, MESSAGE).getRules().get(1).getPredicate().test(now);
        assertFalse(result);
    }

    @Test
    void notEqualsToNullTest() {
        LocalDateTime now = LocalDateTime.now();
        assertFalse(localDateTimeRule.notEqualsTo(now).getRules().get(0).getPredicate().test(null));
        assertFalse(localDateTimeRule.notEqualsTo(now, MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isFutureOkTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isFuture().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertTrue(result);

        result = localDateTimeRule.isFuture(MESSAGE).getRules().get(1).getPredicate().test(localDate.plusDays(1));
        assertTrue(result);
    }

    @Test
    void isFutureFailTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isFuture().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);

        result = localDateTimeRule.isFuture(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isFutureNullTest() {
        assertFalse(localDateTimeRule.isFuture().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateTimeRule.isFuture(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isPastOkTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isPast().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertTrue(result);

        result = localDateTimeRule.isPast(MESSAGE).getRules().get(1).getPredicate().test(localDate.minusDays(1));
        assertTrue(result);
    }

    @Test
    void isPastFailTest() {
        LocalDateTime localDate = LocalDateTime.now().plusSeconds(1);
        boolean result = localDateTimeRule.isPast().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);

        result = localDateTimeRule.isPast(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isPastNullTest() {
        assertFalse(localDateTimeRule.isPast().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateTimeRule.isPast(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isFutureOrPresentOkTest() {
        LocalDateTime localDate = LocalDateTime.now().plusSeconds(1);
        boolean result = localDateTimeRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);

        result = localDateTimeRule.isFutureOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentFailTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertFalse(result);

        result = localDateTimeRule.isFutureOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate.minusDays(1));
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentNullTest() {
        assertFalse(localDateTimeRule.isFutureOrPresent().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateTimeRule.isFutureOrPresent(MESSAGE).getRules().get(1).getPredicate().test(null));
    }

    @Test
    void isPastOrPresentOkTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);

        result = localDateTimeRule.isPastOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isPastOrPresentFailTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertFalse(result);

        result = localDateTimeRule.isPastOrPresent(MESSAGE).getRules().get(1).getPredicate().test(localDate.plusDays(1));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentNullTest() {
        assertFalse(localDateTimeRule.isPastOrPresent().getRules().get(0).getPredicate().test(null));
        assertFalse(localDateTimeRule.isPastOrPresent(MESSAGE).getRules().get(1).getPredicate().test(null));
    }
}
