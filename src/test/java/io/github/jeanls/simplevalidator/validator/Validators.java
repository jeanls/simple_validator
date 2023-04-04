package io.github.jeanls.simplevalidator.validator;

import io.github.jeanls.simplevalidator.Validator;
import io.github.jeanls.simplevalidator.dto.Person;
import io.github.jeanls.simplevalidator.validation.ValidationResult;

public class Validators {

    public static class PersonValidatorWithPayloadAndFieldName extends Validator<Person> {

        @Override
        public ValidationResult validate(Person obj) {

            CarValidator carValidator = new CarValidator();

            return addNumberRule(Person::getAge, "age", r -> r.notNull().greaterThan(18))
                    .addLocalDateTimeRule(Person::getCreatedAt, "created_at", r -> r.notNull().isPast())
                    .addLocalDateRule(Person::getBirthDate, "birth_date", r -> r.notNull().isPast())
                    .addNumberRule(Person::getHeight, "height", r -> r.notNull().greaterThan(1.70))
                    .addCharSequenceRule(Person::getName, "name", r -> r.notNull().notBlank().greaterThanOrEquals(10))
                    .addCustomRule(Person::getName, "name", CustomRuleEx::new, CustomRuleEx::validate)
                    .addValidator(Person::getCar, carValidator)
                    .addItemListValidator(Person::getCars, carValidator)
                    .addListRule(Person::getCars, "cars", r -> r.notNull().lessThan(10))
                    .run(obj, "person");
        }
    }

    public static class PersonValidatorWithPayloadAndValidateIfNull extends Validator<Person> {

        @Override
        public ValidationResult validate(Person obj) {

            CarValidator carValidator = new CarValidator();

            return addNumberRule(Person::getAge, "age", r -> r.notNull().greaterThan(18))
                    .addLocalDateTimeRule(Person::getCreatedAt, "created_at", r -> r.notNull().isPast())
                    .addLocalDateRule(Person::getBirthDate, "birth_date", r -> r.notNull().isPast())
                    .addNumberRule(Person::getHeight, "height", r -> r.notNull().greaterThan(1.70))
                    .addCharSequenceRule(Person::getName, "name", r -> r.notNull().notBlank().greaterThanOrEquals(10))
                    .addCustomRule(Person::getName, "name", CustomRuleEx::new, CustomRuleEx::validate)
                    .addValidator(Person::getCar, carValidator)
                    .addItemListValidator(Person::getCars, carValidator)
                    .addListRule(Person::getCars, "cars", r -> r.notNull().lessThan(10))
                    .run(obj, true);
        }
    }

    public static class PersonValidator extends Validator<Person> {

        @Override
        public ValidationResult validate(Person obj) {

            CarValidator carValidator = new CarValidator();

            return addNumberRule(Person::getAge, "age", r -> r.notNull().greaterThan(18))
                    .addLocalDateTimeRule(Person::getCreatedAt, "created_at", r -> r.notNull().isPast())
                    .addLocalDateRule(Person::getBirthDate, "birth_date", r -> r.notNull().isPast())
                    .addNumberRule(Person::getHeight, "height", r -> r.notNull().greaterThan(1.70))
                    .addCharSequenceRule(Person::getName, "name", r -> r.notNull().notBlank().greaterThanOrEquals(10))
                    .addCustomRule(Person::getName, "name", CustomRuleEx::new, CustomRuleEx::validate)
                    .addValidator(Person::getCar, carValidator)
                    .addItemListValidator(Person::getCars, carValidator)
                    .addListRule(Person::getCars, "cars", r -> r.notNull().lessThan(10))
                    .run(obj);
        }
    }
}
