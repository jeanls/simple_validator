package br.com.simplevalidator.validator;

import br.com.simplevalidator.Car;
import br.com.simplevalidator.Validator;
import br.com.simplevalidator.validation.ValidationResult;

public class CarValidator extends Validator<Car> {
    @Override
    public ValidationResult validate(Car obj) {
        return addCharSequenceRule(Car::getLicensePlate, "person.car.plate", r -> r.equalsTo("pky2j17"))
                .run(obj);
    }
}
