package br.com.simplevalidator.validator;

import br.com.simplevalidator.Car;
import br.com.simplevalidator.Validator;
import br.com.simplevalidator.validation.ValidationResult;

import java.math.BigDecimal;

public class CarValidator extends Validator<Car> {
    @Override
    public ValidationResult validate(Car obj) {
        return addCharSequenceRule(Car::getLicensePlate, "person.car.plate", r -> r.equalsTo("pky2j17"))
                .addNumberRule(Car::getSeatCount, "seat_count", i -> i.isNegative().lessThan(new BigDecimal("10.00")))
                .addNumberRule(Car::getLifeTime, "seat_count", i -> i.isNegative().lessThan(-10))
                .addNumberRule(Car::getPrice, "seat_count", i -> i.isNegative().lessThan(-10))
                .addNumberRule(Car::getPriceBg, "seat_count", i -> i.isNegative().lessThan(-10))
                .addBooleanRule(Car::isActive, "active", b -> b.notNull().isTrue())
                .run(obj);
    }
}
