package io.github.jeanls.simplevalidator.daterules;

import io.github.jeanls.simplevalidator.RulePredicate;
import io.github.jeanls.simplevalidator.commonrules.Rule;
import io.github.jeanls.simplevalidator.utils.Bundle;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Predicate;

public class LocalDateRule<T extends LocalDate> extends Rule<T> {

    public LocalDateRule<T> isNull(final String message) {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public LocalDateRule<T> isNull() {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", null)));
        return this;
    }

    public LocalDateRule<T> notNull(final String message) {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public LocalDateRule<T> notNull() {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public LocalDateRule<T> equalsTo(final LocalDate val, final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message)));
        return this;
    }

    public LocalDateRule<T> equalsTo(final LocalDate val) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", null)));
        return this;
    }

    public LocalDateRule<T> notEqualsTo(final LocalDate val, final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && !t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message)));
        return this;
    }

    public LocalDateRule<T> notEqualsTo(final LocalDate val) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && !t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", null)));
        return this;
    }

    public LocalDateRule<T> isFuture(final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.isAfter(LocalDate.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", message)));
        return this;
    }

    public LocalDateRule<T> isFuture() {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.isAfter(LocalDate.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", null)));
        return this;
    }

    public LocalDateRule<T> isPast(final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.isBefore(LocalDate.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", message)));
        return this;
    }

    public LocalDateRule<T> isPast() {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && t.isBefore(LocalDate.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", null)));
        return this;
    }

    public LocalDateRule<T> isFutureOrPresent(final String message) {
        final LocalDate now = LocalDate.now();
        final Predicate<T> predicate = t -> Objects.nonNull(t) && (t.isAfter(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", message)));
        return this;
    }

    public LocalDateRule<T> isFutureOrPresent() {
        final LocalDate now = LocalDate.now();
        final Predicate<T> predicate = t -> Objects.nonNull(t) && (t.isAfter(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", null)));
        return this;
    }

    public LocalDateRule<T> isPastOrPresent(final String message) {
        final LocalDate now = LocalDate.now();
        final Predicate<T> predicate = t -> Objects.nonNull(t) && (t.isBefore(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", message)));
        return this;
    }

    public LocalDateRule<T> isPastOrPresent() {
        final LocalDate now = LocalDate.now();
        final Predicate<T> predicate = t -> Objects.nonNull(t) && (t.isBefore(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", null)));
        return this;
    }
}
