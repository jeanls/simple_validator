package io.github.jeanls.simple_validator.stringrules;

import io.github.jeanls.simple_validator.RulePredicate;
import io.github.jeanls.simple_validator.commonrules.Rule;
import io.github.jeanls.simple_validator.utils.Bundle;
import io.github.jeanls.simple_validator.utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

public class CharSequenceRule<F extends CharSequence> extends Rule<F> {

    private static final String HTML_REGEX = ".*<[^>]+>.*";

    public CharSequenceRule<F> isUpperCase(final String message) {
        final Predicate<F> predicate = this::isUpperCase;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isUpperCase", message)));
        return this;
    }

    public CharSequenceRule<F> isUpperCase() {
        final Predicate<F> predicate = this::isUpperCase;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isUpperCase", null)));
        return this;
    }

    public CharSequenceRule<F> isLowerCase(final String message) {
        final Predicate<F> predicate = this::isLowerCase;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isLowerCase", message)));
        return this;
    }

    public CharSequenceRule<F> isLowerCase() {
        final Predicate<F> predicate = this::isLowerCase;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isLowerCase", null)));
        return this;
    }

    public CharSequenceRule<F> startsWith(final CharSequence val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).startsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("startsWith", message, val)));
        return this;
    }

    public CharSequenceRule<F> startsWith(final CharSequence val) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).startsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("startsWith", null, val)));
        return this;
    }

    public CharSequenceRule<F> endsWith(final CharSequence val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).endsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("endsWith", message, val)));
        return this;
    }

    public CharSequenceRule<F> endsWith(final CharSequence val) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).endsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("endsWith", null, val)));
        return this;
    }

    public CharSequenceRule<F> contains(final CharSequence val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).contains(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("contains", message, val)));
        return this;
    }

    public CharSequenceRule<F> contains(final CharSequence val) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).contains(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("contains", null, val)));
        return this;
    }

    public CharSequenceRule<F> lessThan(final int val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() - 1 < val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", message, val)));
        return this;
    }

    public CharSequenceRule<F> lessThan(final int val) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() - 1 < val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", null, val)));
        return this;
    }

    public CharSequenceRule<F> lessThanOrEquals(final int val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() <= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", message, val)));
        return this;
    }

    public CharSequenceRule<F> lessThanOrEquals(final int val) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() <= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", null, val)));
        return this;
    }

    public CharSequenceRule<F> greaterThan(final int val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() > val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", message, val)));
        return this;
    }

    public CharSequenceRule<F> greaterThan(final int val) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() > val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", null, val)));
        return this;
    }

    public CharSequenceRule<F> greaterThanOrEquals(final int val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() >= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", message, val)));
        return this;
    }

    public CharSequenceRule<F> greaterThanOrEquals(final int val) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() >= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", null, val)));
        return this;
    }

    public CharSequenceRule<F> size(final int val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() == val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("size", message, val)));
        return this;
    }

    public CharSequenceRule<F> size(final int val) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() == val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("size", null, val)));
        return this;
    }

    public CharSequenceRule<F> notSize(final int val, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() != val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notSize", message, val)));
        return this;
    }

    public CharSequenceRule<F> notSize(final int val) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() != val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notSize", null, val)));
        return this;
    }

    public CharSequenceRule<F> sizes(final List<Integer> sizes, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && sizes.contains(e.length());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("sizes", message, Utils.listIntToMsg(sizes))));
        return this;
    }

    public CharSequenceRule<F> sizes(final List<Integer> sizes) {
        final Predicate<F> predicate = e -> !isNull(e) && sizes.contains(e.length());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("sizes", null, Utils.listIntToMsg(sizes))));
        return this;
    }

    public CharSequenceRule<F> notSizes(final List<Integer> sizes, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && !sizes.contains(e.length());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notSizes", message, Utils.listIntToMsg(sizes))));
        return this;
    }

    public CharSequenceRule<F> notSizes(final List<Integer> sizes) {
        final Predicate<F> predicate = e -> !isNull(e) && !sizes.contains(e.length());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notSizes", null, Utils.listIntToMsg(sizes))));
        return this;
    }

    public CharSequenceRule<F> in(final List<F> values, final String message) {
        final Predicate<F> predicate = values::contains;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("in", message, Utils.listCharToMsg(values))));
        return this;
    }

    public CharSequenceRule<F> in(final List<F> values) {
        final Predicate<F> predicate = values::contains;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("in", null, Utils.listCharToMsg(values))));
        return this;
    }

    public CharSequenceRule<F> notIn(final List<F> values, final String message) {
        final Predicate<F> predicate = f -> Objects.nonNull(f) && !values.contains(f);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notIn", message, Utils.listCharToMsg(values))));
        return this;
    }

    public CharSequenceRule<F> notIn(final List<F> values) {
        final Predicate<F> predicate = f -> Objects.nonNull(f) && !values.contains(f);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notIn", null, Utils.listCharToMsg(values))));
        return this;
    }

    public CharSequenceRule<F> notBlank(final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && !((String) e).isBlank();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notBlank", message)));
        return this;
    }

    public CharSequenceRule<F> notBlank() {
        final Predicate<F> predicate = e -> !isNull(e) && !((String) e).isBlank();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notBlank", null)));
        return this;
    }

    public CharSequenceRule<F> isBlank(final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).isBlank();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isBlank", message)));
        return this;
    }

    public CharSequenceRule<F> isBlank() {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).isBlank();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isBlank", null)));
        return this;
    }

    public CharSequenceRule<F> email(final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).matches("^(.+)@(.+)$");
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("email", message)));
        return this;
    }

    public CharSequenceRule<F> email() {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).matches("^(.+)@(.+)$");
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("email", null)));
        return this;
    }

    public CharSequenceRule<F> isNumeric(final String message) {
        final Predicate<F> predicate = this::isNumber;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNumeric", message)));
        return this;
    }

    public CharSequenceRule<F> isNumeric() {
        final Predicate<F> predicate = this::isNumber;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNumeric", null)));
        return this;
    }

    public CharSequenceRule<F> notNumeric(final String message) {
        final Predicate<F> predicate = f -> !this.isNumber(f);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNumeric", message)));
        return this;
    }

    public CharSequenceRule<F> notNumeric() {
        final Predicate<F> predicate = f -> !this.isNumber(f);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNumeric", null)));
        return this;
    }

    public CharSequenceRule<F> notNull(final String message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public CharSequenceRule<F> notNull() {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public CharSequenceRule<F> equalsTo(final CharSequence another, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.equals(another);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message, another)));
        return this;
    }

    public CharSequenceRule<F> equalsTo(final CharSequence another) {
        final Predicate<F> predicate = e -> !isNull(e) && e.equals(another);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", null, another)));
        return this;
    }

    public CharSequenceRule<F> notEqualsTo(final CharSequence another, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && !e.equals(another);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message, another)));
        return this;
    }

    public CharSequenceRule<F> notEqualsTo(final CharSequence another) {
        final Predicate<F> predicate = e -> !isNull(e) && !e.equals(another);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", null, another)));
        return this;
    }

    public CharSequenceRule<F> isPositive(final String message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) > 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositive", message)));
        return this;
    }

    public CharSequenceRule<F> isPositive() {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) > 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositive", null)));
        return this;
    }

    public CharSequenceRule<F> isPositiveOrZero(final String message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) >= 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositiveOrZero", message)));
        return this;
    }

    public CharSequenceRule<F> isPositiveOrZero() {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) >= 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositiveOrZero", null)));
        return this;
    }

    public CharSequenceRule<F> isNegative(final String message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) < 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegative", message)));
        return this;
    }

    public CharSequenceRule<F> isNegative() {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) < 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegative", null)));
        return this;
    }

    public CharSequenceRule<F> isNegativeOrZero(final String message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) <= 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegativeOrZero", message)));
        return this;
    }

    public CharSequenceRule<F> isNegativeOrZero() {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) <= 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegativeOrZero", null)));
        return this;
    }

    public CharSequenceRule<F> matchRegex(final String regex, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).matches(regex);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("matchRegex", message, regex)));
        return this;
    }

    public CharSequenceRule<F> matchRegex(final String regex) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).matches(regex);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("matchRegex", null, regex)));
        return this;
    }

    public CharSequenceRule<F> notMatchRegex(final String regex, final String message) {
        final Predicate<F> predicate = e -> !isNull(e) && !((String) e).matches(regex);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notMatchRegex", message, regex)));
        return this;
    }

    public CharSequenceRule<F> notMatchRegex(final String regex) {
        final Predicate<F> predicate = e -> !isNull(e) && !((String) e).matches(regex);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notMatchRegex", null, regex)));
        return this;
    }

    public CharSequenceRule<F> isValidDate(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> validDate(e, datePattern);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isValidDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isValidDate(final String datePattern) {
        final Predicate<F> predicate = e -> validDate(e, datePattern);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isValidDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isValidDateTime(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> validDateTime(e, datePattern);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isValidDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isValidDateTime(final String datePattern) {
        final Predicate<F> predicate = e -> validDateTime(e, datePattern);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isValidDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureDate(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isBefore(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureDate(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isBefore(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureOrPresentDate(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isBefore(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    LocalDate.now().isEqual(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureOrPresentDate(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isBefore(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    LocalDate.now().isEqual(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureDateTime(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isBefore(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureDateTime(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isBefore(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureOrPresentDateTime(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }

            final String nowDateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(datePattern));
            final LocalDateTime now = LocalDateTime.parse(nowDateStr, DateTimeFormatter.ofPattern(datePattern));

            return now.isBefore(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    now.isEqual(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureOrPresentDateTime(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }

            final String nowDateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(datePattern));
            final LocalDateTime now = LocalDateTime.parse(nowDateStr, DateTimeFormatter.ofPattern(datePattern));

            return now.isBefore(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    now.isEqual(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureOrPresentDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastDate(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isAfter(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastDate(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isAfter(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastOrPresentDate(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isAfter(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    LocalDate.now().equals(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastOrPresentDate(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isAfter(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    LocalDate.now().equals(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastDateTime(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isAfter(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastDateTime(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isAfter(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastOrPresentDateTime(final String datePattern, final String message) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isAfter(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    LocalDateTime.now().equals(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastOrPresentDateTime(final String datePattern) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isAfter(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern))) ||
                    LocalDateTime.now().equals(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastOrPresentDate", null, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isDigit(final String message) {
        final Predicate<F> predicate = e -> {
            if (isNull(e)) {
                return false;
            }
            boolean result = true;
            for (char c : ((String) e).toCharArray()) {
                if (!Character.isDigit(c)) {
                    result = false;
                    break;
                }
            }
            return result;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isDigit", message)));
        return this;
    }

    public CharSequenceRule<F> isDigit() {
        final Predicate<F> predicate = e -> {
            if (isNull(e)) {
                return false;
            }
            boolean result = true;
            for (char c : ((String) e).toCharArray()) {
                if (!Character.isDigit(c)) {
                    result = false;
                    break;
                }
            }
            return result;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isDigit", null)));
        return this;
    }

    public CharSequenceRule<F> notDigit(final String message) {
        final Predicate<F> predicate = e -> {
            if (isNull(e)) {
                return false;
            }
            boolean result = true;
            for (char c : ((String) e).toCharArray()) {
                if (Character.isDigit(c)) {
                    result = false;
                    break;
                }
            }
            return result;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notDigit", message)));
        return this;
    }

    public CharSequenceRule<F> notDigit() {
        final Predicate<F> predicate = e -> {
            if (isNull(e)) {
                return false;
            }
            boolean result = true;
            for (char c : ((String) e).toCharArray()) {
                if (Character.isDigit(c)) {
                    result = false;
                    break;
                }
            }
            return result;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notDigit", null)));
        return this;
    }

    public CharSequenceRule<F> containHtml(final String message) {
        final Pattern htmlPattern = Pattern.compile(HTML_REGEX, Pattern.DOTALL);
        final Predicate<F> predicate = e -> !isNull(e) && htmlPattern.matcher(e).matches();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("containHtml", message)));
        return this;
    }

    public CharSequenceRule<F> containHtml() {
        final Pattern htmlPattern = Pattern.compile(HTML_REGEX, Pattern.DOTALL);
        final Predicate<F> predicate = e -> !isNull(e) && htmlPattern.matcher(e).matches();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("containHtml", null)));
        return this;
    }

    public CharSequenceRule<F> notContainHtml(final String message) {
        final Pattern htmlPattern = Pattern.compile(HTML_REGEX, Pattern.DOTALL);
        final Predicate<F> predicate = e -> !isNull(e) && !htmlPattern.matcher(e).matches();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notContainHtml", message)));
        return this;
    }

    public CharSequenceRule<F> notContainHtml() {
        final Pattern htmlPattern = Pattern.compile(HTML_REGEX, Pattern.DOTALL);
        final Predicate<F> predicate = e -> !isNull(e) && !htmlPattern.matcher(e).matches();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notContainHtml", null)));
        return this;
    }

    public CharSequenceRule<F> isAlphaNumeric(final String message) {
        final Predicate<F> predicate = f -> {
            if (f == null) {
                return false;
            }
            boolean isAlphaNumeric = true;
            for (final Character c : ((String) f).toCharArray()){
                if(!Character.isLetterOrDigit(c)) {
                    isAlphaNumeric = false;
                    break;
                }
            }
            return isAlphaNumeric;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isAlphaNumeric", message)));
        return this;
    }

    public CharSequenceRule<F> isAlphaNumeric() {
        final Predicate<F> predicate = f -> {
            if (f == null) {
                return false;
            }
            boolean isAlphaNumeric = true;
            for (final Character c : ((String) f).toCharArray()){
                if(!Character.isLetterOrDigit(c)) {
                    isAlphaNumeric = false;
                    break;
                }
            }
            return isAlphaNumeric;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isAlphaNumeric", null)));
        return this;
    }

    public CharSequenceRule<F> isNotAlphaNumeric(final String message) {
        final Predicate<F> predicate = f -> {
            if (f == null) {
                return false;
            }
            boolean isAlphaNumeric = true;
            for (final Character c : ((String) f).toCharArray()){
                if(Character.isLetterOrDigit(c)) {
                    isAlphaNumeric = false;
                    break;
                }
            }
            return isAlphaNumeric;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNotAlphaNumeric", message)));
        return this;
    }

    public CharSequenceRule<F> isNotAlphaNumeric() {
        final Predicate<F> predicate = f -> {
            if (f == null) {
                return false;
            }
            boolean isAlphaNumeric = true;
            for (final Character c : ((String) f).toCharArray()){
                if(Character.isLetterOrDigit(c)) {
                    isAlphaNumeric = false;
                    break;
                }
            }
            return isAlphaNumeric;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNotAlphaNumeric", null)));
        return this;
    }

    public CharSequenceRule<F> isUUIDV4(final String message) {
        final Predicate<F> predicate = f -> {
            try {
                if (f == null) {
                    return false;
                }
                UUID.fromString((String) f);
                return true;
            } catch (Exception e) {
                return false;
            }
        };

        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isUUIDV4", message)));
        return this;
    }

    public CharSequenceRule<F> isUUIDV4() {
        final Predicate<F> predicate = f -> {
            try {
                if (f == null) {
                    return false;
                }
                UUID.fromString((String) f);
                return true;
            } catch (Exception e) {
                return false;
            }
        };

        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isUUIDV4", null)));
        return this;
    }

    private boolean isNumber(F f) {
        if (isNull(f)) {
            return false;
        }
        try {
            Long.valueOf((String) f);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean validDate(F f, final String pattern) {
        try {
            if (isNull(f)) {
                return false;
            }
            LocalDate.parse(f, DateTimeFormatter.ofPattern(pattern));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean validDateTime(F f, final String pattern) {
        try {
            if (isNull(f)) {
                return false;
            }
            LocalDateTime.parse(f, DateTimeFormatter.ofPattern(pattern));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean isUpperCase(final F f) {
        if (isNull(f)) {
            return false;
        }
        boolean isUpper = true;
        for (final Character c : ((String) f).toCharArray()){
            if(!Character.isDigit(c) && !Character.isUpperCase(c)) {
                isUpper = false;
                break;
            }
        }
        return isUpper;
    }

    private boolean isLowerCase(final F f) {
        if (isNull(f)) {
            return false;
        }
        boolean isLower = true;
        for (final Character c : ((String) f).toCharArray()){
            if(!Character.isDigit(c) && !Character.isLowerCase(c)) {
                isLower = false;
                break;
            }
        }
        return isLower;
    }
}
