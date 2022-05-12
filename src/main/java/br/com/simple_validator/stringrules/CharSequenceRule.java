package br.com.simple_validator.stringrules;

import br.com.simple_validator.RulePredicate;
import br.com.simple_validator.commonrules.Rule;
import br.com.simple_validator.utils.Bundle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class CharSequenceRule<F extends CharSequence> extends Rule<F> {

    public CharSequenceRule<F> isUpperCase(final String... message) {
        final Predicate<F> predicate = this::isUpperCase;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isUpperCase", message)));
        return this;
    }

    public CharSequenceRule<F> isLowerCase(final String... message) {
        final Predicate<F> predicate = this::isLowerCase;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isLowerCase", message)));
        return this;
    }

    public CharSequenceRule<F> startsWith(final CharSequence val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).startsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("startsWith", message, val)));
        return this;
    }

    public CharSequenceRule<F> endsWith(final CharSequence val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).endsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("endsWith", message, val)));
        return this;
    }

    public CharSequenceRule<F> contains(final CharSequence val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).contains(val);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("contains", message, val)));
        return this;
    }

    public CharSequenceRule<F> lessThan(final int val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() - 1 < val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", message, val)));
        return this;
    }

    public CharSequenceRule<F> lessThanOrEquals(final int val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() <= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", message, val)));
        return this;
    }

    public CharSequenceRule<F> greaterThan(final int val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() > val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", message, val)));
        return this;
    }

    public CharSequenceRule<F> greaterThanOrEquals(final int val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() >= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", message, val)));
        return this;
    }

    public CharSequenceRule<F> size(final int val, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.length() == val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("size", message, val)));
        return this;
    }

    public CharSequenceRule<F> in(final List<CharSequence> values, final String... message) {
        final Predicate<F> predicate = values::contains;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("in", message)));
        return this;
    }

    public CharSequenceRule<F> notBlank(final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && !((String) e).isBlank();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notBlank", message)));
        return this;
    }

    public CharSequenceRule<F> isBlank(final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).isBlank();
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isBlank", message)));
        return this;
    }

    public CharSequenceRule<F> email(final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).matches("^(.+)@(.+)$");
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("email", message)));
        return this;
    }

    public CharSequenceRule<F> isNumeric(final String... message) {
        final Predicate<F> predicate = this::isNumber;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNumeric", message)));
        return this;
    }

    public CharSequenceRule<F> notNull(final String... message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public CharSequenceRule<F> equalsTo(final CharSequence another, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && e.equals(another);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message, another)));
        return this;
    }

    public CharSequenceRule<F> notEqualsTo(final CharSequence another, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && !e.equals(another);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message, another)));
        return this;
    }

    public CharSequenceRule<F> isPositive(final String... message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) > 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositive", message)));
        return this;
    }

    public CharSequenceRule<F> isPositiveOrZero(final String... message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) >= 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositiveOrZero", message)));
        return this;
    }

    public CharSequenceRule<F> isNegative(final String... message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) < 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegative", message)));
        return this;
    }

    public CharSequenceRule<F> isNegativeOrZero(final String... message) {
        final Predicate<F> predicate = e -> {
            if (!isNumber(e)) {
                return false;
            }
            return new BigDecimal((String) e).compareTo(new BigDecimal(0)) <= 0;
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegativeOrZero", message)));
        return this;
    }

    public CharSequenceRule<F> matchRegex(final String regex, final String... message) {
        final Predicate<F> predicate = e -> !isNull(e) && ((String) e).matches(regex);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("matchRegex", message, regex)));
        return this;
    }

    public CharSequenceRule<F> isValidDate(final String datePattern, final String... message) {
        final Predicate<F> predicate = e -> validDate(e, datePattern);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isValidDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isValidDateTime(final String datePattern, final String... message) {
        final Predicate<F> predicate = e -> validDateTime(e, datePattern);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isValidDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureDate(final String datePattern, final String... message) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isBefore(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureOrPresentDate(final String datePattern, final String... message) {
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

    public CharSequenceRule<F> isFutureDateTime(final String datePattern, final String... message) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isBefore(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFutureDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isFutureOrPresentDateTime(final String datePattern, final String... message) {
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

    public CharSequenceRule<F> isPastDate(final String datePattern, final String... message) {
        final Predicate<F> predicate = e -> {
            if (!validDate(e, datePattern)) {
                return false;
            }
            return LocalDate.now().isAfter(LocalDate.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastOrPresentDate(final String datePattern, final String... message) {
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

    public CharSequenceRule<F> isPastDateTime(final String datePattern, final String... message) {
        final Predicate<F> predicate = e -> {
            if (!validDateTime(e, datePattern)) {
                return false;
            }
            return LocalDateTime.now().isAfter(LocalDateTime.parse(e, DateTimeFormatter.ofPattern(datePattern)));
        };
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPastDate", message, datePattern)));
        return this;
    }

    public CharSequenceRule<F> isPastOrPresentDateTime(final String datePattern, final String... message) {
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

    public CharSequenceRule<F> isDigit(final String... message) {
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

    private boolean isNull(F f) {
        return f == null;
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
