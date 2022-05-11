package br.com.simplevalidator.validator;

import br.com.simplevalidator.Validator;
import br.com.simplevalidator.dto.Person;
import br.com.simplevalidator.objectrules.ObjectRule;
import br.com.simplevalidator.validation.ValidationResult;

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
