package io.github.jeanls.simplevalidator.numberrules;

import io.github.jeanls.simplevalidator.RulePredicate;
import io.github.jeanls.simplevalidator.commonrules.Rule;
import io.github.jeanls.simplevalidator.utils.Bundle;
import io.github.jeanls.simplevalidator.utils.NumberWrapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberRule<F extends Number> extends Rule<F> {

    private final Map<Class<?>, NumberWrapper<F>> map = new HashMap<>();
    private final Map<Class<?>, NumberWrapper<Number>> map2 = new HashMap<>();

    public NumberRule() {
        map.put(Integer.class, val -> new BigDecimal((Integer) val));
        map.put(Double.class, val -> BigDecimal.valueOf((Double) val));
        map.put(Short.class, val -> BigDecimal.valueOf((Short) val));
        map.put(Long.class, val -> BigDecimal.valueOf((Long) val));
        map.put(BigInteger.class, val -> new BigDecimal((BigInteger) val));
        map.put(BigDecimal.class, BigDecimal.class::cast);
        map.put(Byte.class, val -> new BigDecimal((Byte) val));
        map.put(Float.class, val -> BigDecimal.valueOf((Float) val));

        map2.put(Integer.class, val -> new BigDecimal((Integer) val));
        map2.put(Double.class, val -> BigDecimal.valueOf((Double) val));
        map2.put(Short.class, val -> BigDecimal.valueOf((Short) val));
        map2.put(Long.class, val -> BigDecimal.valueOf((Long) val));
        map2.put(BigInteger.class, val -> new BigDecimal((BigInteger) val));
        map2.put(BigDecimal.class, BigDecimal.class::cast);
        map2.put(Byte.class, val -> new BigDecimal((Byte) val));
        map2.put(Float.class, val -> BigDecimal.valueOf((Float) val));
    }

    public NumberRule<F> lessThan(final F val, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) < 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", message, val)));
        return this;
    }

    public NumberRule<F> lessThan(final F val) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) < 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", null, val)));
        return this;
    }

    public NumberRule<F> lessThanOrEquals(final F val, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) <= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", message, val)));
        return this;
    }

    public NumberRule<F> lessThanOrEquals(final F val) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) <= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", null, val)));
        return this;
    }

    public NumberRule<F> greaterThan(final F val, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) > 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", message, val)));
        return this;
    }

    public NumberRule<F> greaterThan(final F val) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) > 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", null, val)));
        return this;
    }

    public NumberRule<F> greaterThanOrEquals(final F val, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) >= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", message, val)));
        return this;
    }

    public NumberRule<F> greaterThanOrEquals(final F val) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) >= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", null, val)));
        return this;
    }

    public NumberRule<F> notNull(final String message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public NumberRule<F> notNull() {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public NumberRule<F> isNull(final String message) {
        final Predicate<F> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public NumberRule<F> isNull() {
        final Predicate<F> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", null)));
        return this;
    }

    public NumberRule<F> equalsTo(final F val, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) == 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message)));
        return this;
    }

    public NumberRule<F> equalsTo(final F val) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) == 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", null)));
        return this;
    }

    public NumberRule<F> notEqualsTo(final F val, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) != 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message)));
        return this;
    }

    public NumberRule<F> notEqualsTo(final F val) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) != 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", null)));
        return this;
    }

    public NumberRule<F> between(final F start, final F end, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && (getNumber(e).compareTo(getNumberFromParam(start)) >= 0 && getNumber(e).compareTo(getNumberFromParam(end)) <= 0);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("between", message, start, end)));
        return this;
    }

    public NumberRule<F> between(final F start, final F end) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && (getNumber(e).compareTo(getNumberFromParam(start)) >= 0 && getNumber(e).compareTo(getNumberFromParam(end)) <= 0);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("between", null, start, end)));
        return this;
    }

    public NumberRule<F> notBetween(final F start, final F end, final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && (getNumber(e).compareTo(getNumberFromParam(start)) < 0 || getNumber(e).compareTo(getNumberFromParam(end)) > 0);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notBetween", message, start, end)));
        return this;
    }

    public NumberRule<F> notBetween(final F start, final F end) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && (getNumber(e).compareTo(getNumberFromParam(start)) < 0 || getNumber(e).compareTo(getNumberFromParam(end)) > 0);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notBetween", null, start, end)));
        return this;
    }

    public NumberRule<F> inList(final List<F> numberList, final String message) {
        final List<BigDecimal> newNumberList = numberList.stream().map(this::getNumberFromParam).collect(Collectors.toList());
        final Predicate<F> predicate = e -> Objects.nonNull(e) && newNumberList.contains(getNumber(e));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("inList", message)));
        return this;
    }

    public NumberRule<F> inList(final List<F> numberList) {
        final List<BigDecimal> newNumberList = numberList.stream().map(this::getNumberFromParam).collect(Collectors.toList());
        final Predicate<F> predicate = e -> Objects.nonNull(e) && newNumberList.contains(getNumber(e));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("inList", null)));
        return this;
    }

    public NumberRule<F> notInList(final List<F> numberList, final String message) {
        final List<BigDecimal> newNumberList = numberList.stream().map(this::getNumberFromParam).collect(Collectors.toList());
        final Predicate<F> predicate = e -> Objects.nonNull(e) && !newNumberList.contains(getNumber(e));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notInList", message)));
        return this;
    }

    public NumberRule<F> notInList(final List<F> numberList) {
        final List<BigDecimal> newNumberList = numberList.stream().map(this::getNumberFromParam).collect(Collectors.toList());
        final Predicate<F> predicate = e -> Objects.nonNull(e) && !newNumberList.contains(getNumber(e));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notInList", null)));
        return this;
    }

    public NumberRule<F> isPositive(final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) > 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositive", message)));
        return this;
    }

    public NumberRule<F> isPositive() {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) > 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositive", null)));
        return this;
    }

    public NumberRule<F> isPositiveOrZero(final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) >= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositiveOrZero", message)));
        return this;
    }

    public NumberRule<F> isPositiveOrZero() {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) >= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositiveOrZero", null)));
        return this;
    }

    public NumberRule<F> isNegative(final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) < 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegative", message)));
        return this;
    }

    public NumberRule<F> isNegative() {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) < 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegative", null)));
        return this;
    }

    public NumberRule<F> isNegativeOrZero(final String message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) <= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegativeOrZero", message)));
        return this;
    }

    public NumberRule<F> isNegativeOrZero() {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) <= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegativeOrZero", null)));
        return this;
    }

    private BigDecimal getNumber(final F f) {
        return map.get(f.getClass()).accept(f);
    }

    private BigDecimal getNumberFromParam(final Number number) {
        return map2.get(number.getClass()).accept(number);
    }
}
