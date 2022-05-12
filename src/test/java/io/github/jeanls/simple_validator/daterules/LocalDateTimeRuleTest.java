package io.github.jeanls.simple_validator.daterules;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocalDateTimeRuleTest {
    private final LocalDateTimeRule<LocalDateTime> localDateTimeRule = new LocalDateTimeRule<>();

    @Test
    void isNullOkTest() {
        boolean result = localDateTimeRule.isNull().getRules().get(0).getPredicate().test(null);
        assertTrue(result);
    }

    @Test
    void isNullFailTest() {
        boolean result = localDateTimeRule.isNull().getRules().get(0).getPredicate().test(LocalDateTime.now());
        assertFalse(result);
    }

    @Test
    void notNullOkTest() {
        boolean result = localDateTimeRule.notNull().getRules().get(0).getPredicate().test(LocalDateTime.now());
        assertTrue(result);
    }

    @Test
    void notNullFailTest() {
        boolean result = localDateTimeRule.notNull().getRules().get(0).getPredicate().test(null);
        assertFalse(result);
    }

    @Test
    void equalsToOkTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.equalsTo(now).getRules().get(0).getPredicate().test(now);
        assertTrue(result);
    }

    @Test
    void equalsToFailTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.equalsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertFalse(result);
    }

    @Test
    void notEqualsToOkTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now.plusDays(1));
        assertTrue(result);
    }

    @Test
    void notEqualsToFailTest() {
        LocalDateTime now = LocalDateTime.now();
        boolean result = localDateTimeRule.notEqualsTo(now).getRules().get(0).getPredicate().test(now);
        assertFalse(result);
    }

    @Test
    void isFutureOkTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isFuture().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertTrue(result);
    }

    @Test
    void isFutureFailTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isFuture().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isPastOkTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isPast().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertTrue(result);
    }

    @Test
    void isPastFailTest() {
        LocalDateTime localDate = LocalDateTime.now().plusSeconds(1);
        boolean result = localDateTimeRule.isPast().getRules().get(0).getPredicate().test(localDate);
        assertFalse(result);
    }

    @Test
    void isFutureOrPresentOkTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isFutureOrPresentFailTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isFutureOrPresent().getRules().get(0).getPredicate().test(localDate.minusDays(1));
        assertFalse(result);
    }

    @Test
    void isPastOrPresentOkTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate);
        assertTrue(result);
    }

    @Test
    void isPastOrPresentFailTest() {
        LocalDateTime localDate = LocalDateTime.now();
        boolean result = localDateTimeRule.isPastOrPresent().getRules().get(0).getPredicate().test(localDate.plusDays(1));
        assertFalse(result);
    }
}
