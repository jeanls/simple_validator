package br.com.simplevalidator;

import java.util.List;
import java.util.function.Function;

public class RuleItem<K, V> {
    private final List<RulePredicate<V>> predicates;
    private final String fieldName;
    private final Function<K, V> field;

    public RuleItem(List<RulePredicate<V>> predicates, String fieldName, Function<K, V> field) {
        this.predicates = predicates;
        this.fieldName = fieldName;
        this.field = field;
    }

    public List<RulePredicate<V>> getPredicates() {
        return predicates;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Function<K, V> getField() {
        return field;
    }
}
