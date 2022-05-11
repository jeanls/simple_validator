package br.com.simplevalidator.validator;

import br.com.simplevalidator.dto.Car;
import br.com.simplevalidator.Validator;
import br.com.simplevalidator.validation.ValidationResult;

import java.math.BigDecimal;

public class CarValidator extends Validator<Car> {
    @Override
    public ValidationResult validate(Car obj) {
        return addCharSequenceRule(Car::getLicensePlate, "person.car.plate", r -> r.isUpperCase().notNull())
                .addNumberRule(Car::getSeatCount, "seat_count", i -> i.notNull().greaterThan(4))
                .addNumberRule(Car::getLifeTime, "life_time", i -> i.notNull().isPositive())
                .addNumberRule(Car::getPrice, "price", i -> i.isPositive().greaterThan(new BigDecimal("30000.00")))
                .addNumberRule(Car::getPriceBg, "price_bg", i -> i.isPositive().lessThan(new BigDecimal("100000.00")))
                .addBooleanRule(Car::isActive, "active", b -> b.notNull().isTrue())
                .run(obj);
    }
}
