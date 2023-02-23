package io.github.jeanls.simplevalidator.listrules;

import io.github.jeanls.simplevalidator.RulePredicate;
import io.github.jeanls.simplevalidator.commonrules.Rule;
import io.github.jeanls.simplevalidator.utils.Bundle;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ListRule<F extends List<I>, I> extends Rule<F> {

    public ListRule<F, I> notNull(final String message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public ListRule<F, I> notNull() {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public ListRule<F, I> isNull(final String message) {
        final Predicate<F> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public ListRule<F, I> isNull() {
        final Predicate<F> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", null)));
        return this;
    }

    public ListRule<F, I> hasSize(final int size, final String message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() == size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasSize", message, size)));
        return this;
    }

    public ListRule<F, I> hasSize(final int size) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() == size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasSize", null, size)));
        return this;
    }

    public ListRule<F, I> hasNotSize(final int size, final String message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() != size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasNotSize", message, size)));
        return this;
    }

    public ListRule<F, I> hasNotSize(final int size) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() != size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasNotSize", null, size)));
        return this;
    }

    public ListRule<F, I> greaterThan(final int size, final String message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() > size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", message, size)));
        return this;
    }

    public ListRule<F, I> greaterThan(final int size) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() > size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", null, size)));
        return this;
    }

    public ListRule<F, I> greaterThanOrEquals(final int size, final String message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() >= size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", message, size)));
        return this;
    }

    public ListRule<F, I> greaterThanOrEquals(final int size) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() >= size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", null, size)));
        return this;
    }

    public ListRule<F, I> lessThan(final int size, final String message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() < size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", message, size)));
        return this;
    }

    public ListRule<F, I> lessThan(final int size) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() < size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", null, size)));
        return this;
    }

    public ListRule<F, I> lessThanOrEquals(final int size, final String message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() <= size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", message, size)));
        return this;
    }

    public ListRule<F, I> lessThanOrEquals(final int size) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() <= size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", null, size)));
        return this;
    }

    public ListRule<F, I> notContainsItem(final I i, final String message) {
        final Predicate<F> predicate = list ->  Objects.nonNull(list) && !list.contains(i);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notContainsItem", message, i)));
        return this;
    }

    public ListRule<F, I> notContainsItem(final I i) {
        final Predicate<F> predicate = list ->  Objects.nonNull(list) && !list.contains(i);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notContainsItem", null, i)));
        return this;
    }

    public ListRule<F, I> containsItem(final I i, final String message) {
        final Predicate<F> predicate = list ->  Objects.nonNull(list) && list.contains(i);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("containsItem", message, i)));
        return this;
    }

    public ListRule<F, I> containsItem(final I i) {
        final Predicate<F> predicate = list ->  Objects.nonNull(list) && list.contains(i);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("containsItem", null, i)));
        return this;
    }
}
