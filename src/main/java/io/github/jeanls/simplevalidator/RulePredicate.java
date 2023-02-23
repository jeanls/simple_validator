package io.github.jeanls.simplevalidator;

import java.util.function.Predicate;

public class RulePredicate<F> {
    private final Predicate<F> predicate;
    private final String message;

    public RulePredicate(Predicate<F> predicate, String message) {
        this.predicate = predicate;
        this.message = message;
    }

    public Predicate<F> getPredicate() {
        return predicate;
    }

    public String getMessage() {
        return message;
    }
}
