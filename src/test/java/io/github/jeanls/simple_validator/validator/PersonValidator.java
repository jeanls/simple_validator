package io.github.jeanls.simple_validator.validator;

import io.github.jeanls.simple_validator.Validator;
import io.github.jeanls.simple_validator.dto.Person;
import io.github.jeanls.simple_validator.objectrules.ObjectRule;
import io.github.jeanls.simple_validator.validation.ValidationResult;

public class PersonValidator extends Validator<Person> {

    @Override
    public ValidationResult validate(Person obj) {

        CarValidator carValidator = new CarValidator();

        return addNumberRule(Person::getAge, "age", r -> r.notNull().greaterThan(18))
                .addLocalDateTimeRule(Person::getCreatedAt, "created_at", r -> r.notNull().isPast())
                .addLocalDateRule(Person::getBirthDate, "birth_date", r -> r.notNull().isPast())
                .addNumberRule(Person::getHeight, "height", r -> r.notNull().greaterThan(1.70))
                .addCharSequenceRule(Person::getName, "name", r -> r.notNull().notBlank().greaterThanOrEquals(10))
                .addObjectRule(Person::getCar, "car", ObjectRule::notNull)
                .addCustomRule(Person::getName, "name", CustomRuleEx::new, CustomRuleEx::validate)
                .addValidator(Person::getCar, carValidator)
                .run(obj);
    }
}
