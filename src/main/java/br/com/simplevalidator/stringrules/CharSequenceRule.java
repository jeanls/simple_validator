package br.com.simplevalidator.stringrules;

import br.com.simplevalidator.RulePredicate;
import br.com.simplevalidator.commonrules.Rule;
import br.com.simplevalidator.utils.GetBundle;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class CharSequenceRule<F extends CharSequence> extends Rule<F> {

    public CharSequenceRule<F> startsWith(final CharSequence val) {
        final Predicate<F> predicate = e -> e != null && ((String) e).startsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("startsWith", val)));
        return this;
    }

    public CharSequenceRule<F> endsWith(final CharSequence val) {
        final Predicate<F> predicate = e -> e != null && ((String) e).endsWith(val.toString());
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("endsWith", val)));
        return this;
    }

    public CharSequenceRule<F> contains(final CharSequence val) {
        final Predicate<F> predicate = e -> e != null && ((String) e).contains(val);
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("contains", val)));
        return this;
    }

    public CharSequenceRule<F> lessThan(final int val) {
        final Predicate<F> predicate = e -> e != null && e.length() - 1 < val;
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("lessThan", val)));
        return this;
    }

    public CharSequenceRule<F> lessThanOrEquals(final int val) {
        final Predicate<F> predicate = e -> e != null && e.length() <= val;
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("lessThanOrEquals", val)));
        return this;
    }

    public CharSequenceRule<F> greaterThan(final int val) {
        final Predicate<F> predicate = e -> e != null && e.length() > val;
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("greaterThan", val)));
        return this;
    }

    public CharSequenceRule<F> greaterThanOrEquals(final int val) {
        final Predicate<F> predicate = e -> e != null && e.length() >= val;
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("greaterThanOrEquals", val)));
        return this;
    }

    public CharSequenceRule<F> size(final int val) {
        final Predicate<F> predicate = e -> e != null && e.length() == val;
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("size", val)));
        return this;
    }

    public CharSequenceRule<F> in(final List<CharSequence> values) {
        final Predicate<F> predicate = values::contains;
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("in")));
        return this;
    }

    public CharSequenceRule<F> notBlank() {
        final Predicate<F> predicate = e -> e != null && !((String) e).isBlank();
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("notBlank")));
        return this;
    }

    public CharSequenceRule<F> email() {
        final Predicate<F> predicate = e -> e != null && ((String) e).matches("^(.+)@(.+)$");
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("email")));
        return this;
    }

    public CharSequenceRule<F> isNumeric() {
        final Predicate<F> predicate = e -> {
            if(e == null) {
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
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("isNumeric")));
        return this;
    }

    public CharSequenceRule<F> notNull() {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("notNull")));
        return this;
    }

    public CharSequenceRule<F> equalsTo(final CharSequence another) {
        final Predicate<F> predicate = e -> e != null && e.equals(another);
        this.addPredicate(new RulePredicate<>(predicate, GetBundle.getInstance().get("equalsTo", another)));
        return this;
    }
}
