package br.com.simple_validator.numberrules;

import br.com.simple_validator.RulePredicate;
import br.com.simple_validator.commonrules.Rule;
import br.com.simple_validator.utils.NumberWrapper;
import br.com.simple_validator.utils.Bundle;

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

    public NumberRule<F> lessThan(final Number val, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) < 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", message, val)));
        return this;
    }

    public NumberRule<F> lessThanOrEquals(final Number val, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) <= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", message, val)));
        return this;
    }

    public NumberRule<F> greaterThan(final Number val, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) > 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", message, val)));
        return this;
    }

    public NumberRule<F> greaterThanOrEquals(final Number val, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) >= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", message, val)));
        return this;
    }

    public NumberRule<F> notNull(final String... message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public NumberRule<F> isNull(final String... message) {
        final Predicate<F> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public NumberRule<F> equalsTo(final Number val, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) == 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message)));
        return this;
    }

    public NumberRule<F> notEqualsTo(final Number val, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(getNumberFromParam(val)) != 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message)));
        return this;
    }

    public NumberRule<F> between(final Number start, final Number end, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && (getNumber(e).compareTo(getNumberFromParam(start)) >= 0 && getNumber(e).compareTo(getNumberFromParam(end)) <= 0);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("between", message, start, end)));
        return this;
    }

    public NumberRule<F> notBetween(final Number start, final Number end, final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && (getNumber(e).compareTo(getNumberFromParam(start)) < 0 || getNumber(e).compareTo(getNumberFromParam(end)) > 0);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notBetween", message, start, end)));
        return this;
    }

    public NumberRule<F> inList(final List<Number> numberList, final String... message) {
        final List<BigDecimal> newNumberList = numberList.stream().map(this::getNumberFromParam).collect(Collectors.toList());
        final Predicate<F> predicate = e -> Objects.nonNull(e) && newNumberList.contains(getNumber(e));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("inList", message)));
        return this;
    }

    public NumberRule<F> notInList(final List<Number> numberList, final String... message) {
        final List<BigDecimal> newNumberList = numberList.stream().map(this::getNumberFromParam).collect(Collectors.toList());
        final Predicate<F> predicate = e -> Objects.nonNull(e) && !newNumberList.contains(getNumber(e));
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notInList", message)));
        return this;
    }

    public NumberRule<F> isPositive(final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) > 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositive", message)));
        return this;
    }

    public NumberRule<F> isPositiveOrZero(final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) >= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositiveOrZero", message)));
        return this;
    }

    public NumberRule<F> isNegative(final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) < 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegative", message)));
        return this;
    }

    public NumberRule<F> isNegativeOrZero(final String... message) {
        final Predicate<F> predicate = e -> Objects.nonNull(e) && getNumber(e).compareTo(new BigDecimal(0)) <= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegativeOrZero", message)));
        return this;
    }

    private BigDecimal getNumber(F f) {
        return map.get(f.getClass()).accept(f);
    }

    private BigDecimal getNumberFromParam(final Number number) {
        return map2.get(number.getClass()).accept(number);
    }
}
