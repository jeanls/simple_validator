package br.com.simplevalidator;

import java.util.function.Predicate;

public class RulePredicate<F> {
    private Predicate<F> predicate;
    private String message;

    public RulePredicate() {
    }

    public RulePredicate(Predicate<F> predicate, String message) {
        this.predicate = predicate;
        this.message = message;
    }

    public Predicate<F> getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate<F> predicate) {
        this.predicate = predicate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
