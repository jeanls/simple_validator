package br.com.simplevalidator;

public class Car {
    private final String manufacturer;

    private final String licensePlate;

    private final int seatCount;

//    public static final am.ik.yavi.core.Validator<Car> validator = ValidatorBuilder.<Car>of()
//            .constraint(Car::getManufacturer, "manufacturer", Constraint::notNull)
//            .constraint(Car::getLicensePlate, "licensePlate", c -> c.notNull().greaterThanOrEqual(2).lessThanOrEqual(14))
//            .constraint(Car::getSeatCount, "seatCount", c -> c.greaterThanOrEqual(2))
//            .build();

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
}
