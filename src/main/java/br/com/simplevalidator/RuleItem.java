package br.com.simplevalidator;

import java.util.List;
import java.util.function.Function;

public class RuleItem<K, V> {
    private List<RulePredicate<V>> predicates;
    private String fieldName;
    private Function<K, V> field;

    public RuleItem(List<RulePredicate<V>> predicates, String fieldName, Function<K, V> field) {
        this.predicates = predicates;
        this.fieldName = fieldName;
        this.field = field;
    }

    public List<RulePredicate<V>> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<RulePredicate<V>> predicates) {
        this.predicates = predicates;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Function<K, V> getField() {
        return field;
    }

    public void setField(Function<K, V> field) {
        this.field = field;
    }
}
