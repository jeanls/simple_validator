package io.github.jeanls.simple_validator.daterules;

import io.github.jeanls.simple_validator.RulePredicate;
import io.github.jeanls.simple_validator.commonrules.Rule;
import io.github.jeanls.simple_validator.utils.Bundle;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

public class LocalDateTimeRule<T extends LocalDateTime> extends Rule<T> {

    public LocalDateTimeRule<T> isNull(final String... message) {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public LocalDateTimeRule<T> notNull(final String... message) {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public LocalDateTimeRule<T> equalsTo(final LocalDateTime val, final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message)));
        return this;
    }

    public LocalDateTimeRule<T> notEqualsTo(final LocalDateTime val, final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && !t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message)));
        return this;
    }

    public LocalDateTimeRule<T> isFuture(final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.isAfter(LocalDateTime.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", message)));
        return this;
    }

    public LocalDateTimeRule<T> isPast(final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.isBefore(LocalDateTime.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", message)));
        return this;
    }

    public LocalDateTimeRule<T> isFutureOrPresent(final String... message) {
        final LocalDateTime now = LocalDateTime.now();
        final Predicate<T> predicate = t -> Objects.nonNull(t) && (t.isAfter(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", message)));
        return this;
    }

    public LocalDateTimeRule<T> isPastOrPresent(final String... message) {
        final LocalDateTime now = LocalDateTime.now();
        final Predicate<T> predicate = t -> Objects.nonNull(t) && (t.isBefore(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", message)));
        return this;
    }
}
