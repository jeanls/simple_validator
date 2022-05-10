package br.com.simplevalidator.validator;

import br.com.simplevalidator.IsOkRule;
import br.com.simplevalidator.Validator;
import br.com.simplevalidator.dto.Person;
import br.com.simplevalidator.objectrules.ObjectRule;
import br.com.simplevalidator.validation.ValidationResult;

public class PersonValidator extends Validator<Person> {

    @Override
    public ValidationResult validate(Person obj) {

        CarValidator carValidator = new CarValidator();

        return addCharSequenceRule(Person::getName, "name", rule -> rule.notNull()
                        .greaterThanOrEquals(5)
                        .notBlank()
                        .equalsTo("Jean Leal Silva")
                ).addIntegerRule(Person::getAge, "age", rule -> rule.notNull().isPositiveOrZero())
                .addObjectRule(Person::getCar, "car", ObjectRule::notNull)
//                .addCustomRule(Person::getName, "", IsOkRule::new, IsOkRule::validate)
                .addValidator(carValidator, obj.getCar())
                .run(obj);
    }
}
