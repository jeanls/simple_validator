package io.github.jeanls.simple_validator.listrules;

import io.github.jeanls.simple_validator.RulePredicate;
import io.github.jeanls.simple_validator.commonrules.Rule;
import io.github.jeanls.simple_validator.utils.Bundle;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ListRule<F extends List<I>, I> extends Rule<F> {

    public ListRule<F, I> notNull(final String... message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public ListRule<F, I> isNull(final String... message) {
        final Predicate<F> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public ListRule<F, I> hasSize(final int size, final String... message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() == size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasSize", message, size)));
        return this;
    }

    public ListRule<F, I> hasNotSize(final int size, final String... message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() != size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("hasNotSize", message, size)));
        return this;
    }

    public ListRule<F, I> greaterThan(final int size, final String... message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() > size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", message, size)));
        return this;
    }

    public ListRule<F, I> greaterThanOrEquals(final int size, final String... message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() >= size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", message, size)));
        return this;
    }

    public ListRule<F, I> lessThan(final int size, final String... message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() < size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", message, size)));
        return this;
    }

    public ListRule<F, I> lessThanOrEquals(final int size, final String... message) {
        final Predicate<F> predicate = list -> Objects.nonNull(list) && list.size() <= size;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", message, size)));
        return this;
    }
}
