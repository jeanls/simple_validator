package br.com.simplevalidator;

import am.ik.yavi.core.ConstraintViolations;
import br.com.simplevalidator.validation.ValidationResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CarTest {

    @Test
    void test() {
        Car car = new Car("VW", "PKY2J17", 5);
        final ValidationResult validationResult = Car.validate(car);
        assertNotNull(validationResult);
    }


//    @Test
//    void manufacturerIsNull() {
//        final Car car = new Car(null, "DD-AB-123", 4);
//        final ConstraintViolations violations = Car.validator.validate(car);
//
//        assertThat(violations.isValid()).isFalse();
//        assertThat(violations).hasSize(1);
//        assertThat(violations.get(0).message()).isEqualTo("\"manufacturer\" must not be null");
//    }

//    @Test
//    void licensePlateTooShort() {
//        final Car car = new Car("Morris", "D", 4);
//        final ConstraintViolations violations = Car.validator.validate(car);
//
//        assertThat(violations.isValid()).isFalse();
//        assertThat(violations).hasSize(1);
//        assertThat(violations.get(0).message()).isEqualTo("The size of \"licensePlate\" must be greater than or equal to 2. The given size is 1");
//    }
//
//    @Test
//    void seatCountTooLow() {
//        final Car car = new Car("Morris", "DD-AB-123", 1);
//        final ConstraintViolations violations = Car.validator.validate(car);
//
//        assertThat(violations.isValid()).isFalse();
//        assertThat(violations).hasSize(1);
//        assertThat(violations.get(0).message()).isEqualTo("\"seatCount\" must be greater than or equal to 2");
//    }
//
//    @Test
//    void carIsValid() {
//        final Car car = new Car("Morris", "DD-AB-123", 2);
//        final ConstraintViolations violations = Car.validator.validate(car);
//
//        assertThat(violations.isValid()).isTrue();
//        assertThat(violations).hasSize(0);
//    }
}
