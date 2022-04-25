package br.com.simplevalidator;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.Constraint;
import br.com.simplevalidator.validation.ValidationResult;

public class Car extends Validator<Car> {
    private final String manufacturer;

    private final String licensePlate;

    private final int seatCount;

    public static final am.ik.yavi.core.Validator<Car> validator = ValidatorBuilder.<Car>of()
            .constraint(Car::getManufacturer, "manufacturer", Constraint::notNull)
            .constraint(Car::getLicensePlate, "licensePlate", c -> c.notNull().greaterThanOrEqual(2).lessThanOrEqual(14))
            .constraint(Car::getSeatCount, "seatCount", c -> c.greaterThanOrEqual(2))
            .build();

    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public static ValidationResult validate(final Car car) {
        return car.addCharSequenceRule(Car::getManufacturer, "manufacturer", c -> c.greaterThanOrEquals(10)
                        .isNumeric()
                        .notBlank()
                        .notNull())

//                .addCustomRule(Car::getLicensePlate, "licence_plate", IsOkRule::new, IsOkRule::validate)
//                .addIntegerRule(Car::getSeatCount, "seatCount", carIntegerIntegerRules -> carIntegerIntegerRules.greaterThan(10))
                .run(car);
    }
}
