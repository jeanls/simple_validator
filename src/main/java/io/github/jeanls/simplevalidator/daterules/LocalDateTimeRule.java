package io.github.jeanls.simplevalidator.daterules;

import io.github.jeanls.simplevalidator.RulePredicate;
import io.github.jeanls.simplevalidator.commonrules.Rule;
import io.github.jeanls.simplevalidator.utils.Bundle;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

public class LocalDateTimeRule extends Rule<LocalDateTime> {

    public LocalDateTimeRule isAfter(final LocalDateTime actual, final String message) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && localDate.isAfter(actual);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isAfter", message)));
        return this;
    }

    public LocalDateTimeRule isAfter(final LocalDateTime actual) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && localDate.isAfter(actual);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isAfter", null)));
        return this;
    }

    public LocalDateTimeRule isAfterOrEquals(final LocalDateTime actual, final String message) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && (localDate.isAfter(actual) || localDate.equals(actual));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isAfterOrEquals", message)));
        return this;
    }

    public LocalDateTimeRule isAfterOrEquals(final LocalDateTime actual) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && (localDate.isAfter(actual) || localDate.equals(actual));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isAfterOrEquals", null)));
        return this;
    }

    public LocalDateTimeRule isBefore(final LocalDateTime actual, final String message) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && localDate.isBefore(actual);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isBefore", message)));
        return this;
    }

    public LocalDateTimeRule isBefore(final LocalDateTime actual) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && localDate.isBefore(actual);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isBefore", null)));
        return this;
    }

    public LocalDateTimeRule isBeforeOrEquals(final LocalDateTime actual, final String message) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && (localDate.isBefore(actual) || localDate.equals(actual));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isBeforeOrEquals", message)));
        return this;
    }

    public LocalDateTimeRule isBeforeOrEquals(final LocalDateTime actual) {
        final Predicate<LocalDateTime> predicate =  localDate -> Objects.nonNull(localDate) && (localDate.isBefore(actual) || localDate.equals(actual));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isBeforeOrEquals", null)));
        return this;
    }

    public LocalDateTimeRule isNull(final String message) {
        final Predicate<LocalDateTime> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public LocalDateTimeRule isNull() {
        final Predicate<LocalDateTime> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", null)));
        return this;
    }

    public LocalDateTimeRule notNull(final String message) {
        final Predicate<LocalDateTime> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public LocalDateTimeRule notNull() {
        final Predicate<LocalDateTime> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public LocalDateTimeRule equalsTo(final LocalDateTime val, final String message) {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message)));
        return this;
    }

    public LocalDateTimeRule equalsTo(final LocalDateTime val) {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", null)));
        return this;
    }

    public LocalDateTimeRule notEqualsTo(final LocalDateTime val, final String message) {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && !t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message)));
        return this;
    }

    public LocalDateTimeRule notEqualsTo(final LocalDateTime val) {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && !t.equals(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", null)));
        return this;
    }

    public LocalDateTimeRule isFuture(final String message) {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && t.isAfter(LocalDateTime.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", message)));
        return this;
    }

    public LocalDateTimeRule isFuture() {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && t.isAfter(LocalDateTime.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", null)));
        return this;
    }

    public LocalDateTimeRule isPast(final String message) {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && t.isBefore(LocalDateTime.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", message)));
        return this;
    }

    public LocalDateTimeRule isPast() {
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && t.isBefore(LocalDateTime.now());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", null)));
        return this;
    }

    public LocalDateTimeRule isFutureOrPresent(final String message) {
        final LocalDateTime now = LocalDateTime.now();
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && (t.isAfter(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", message)));
        return this;
    }

    public LocalDateTimeRule isFutureOrPresent() {
        final LocalDateTime now = LocalDateTime.now();
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && (t.isAfter(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", null)));
        return this;
    }

    public LocalDateTimeRule isPastOrPresent(final String message) {
        final LocalDateTime now = LocalDateTime.now();
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && (t.isBefore(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", message)));
        return this;
    }

    public LocalDateTimeRule isPastOrPresent() {
        final LocalDateTime now = LocalDateTime.now();
        final Predicate<LocalDateTime> predicate = t -> Objects.nonNull(t) && (t.isBefore(now) || t.equals(now));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", null)));
        return this;
    }
}
