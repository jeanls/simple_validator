package io.github.jeanls.simplevalidator.validator;

import io.github.jeanls.simplevalidator.dto.Car;
import io.github.jeanls.simplevalidator.dto.Person;
import io.github.jeanls.simplevalidator.util.CustomValidationException;
import io.github.jeanls.simplevalidator.validation.ValidationError;
import io.github.jeanls.simplevalidator.validation.ValidationResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void successTest() {
        Validators.PersonValidator personValidator = new Validators.PersonValidator();

        Person person = new Person();
        person.setAge(28);
        person.setCreatedAt(LocalDateTime.now().minusDays(1));
        person.setHeight(1.72);
        person.setName("Jean Leal Silva");
        person.setBirthDate(LocalDate.parse("1993-05-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        person.setCar(new Car());
        person.getCar().setActive(true);
        person.getCar().setLifeTime(400);
        person.getCar().setPrice(69990.00);
        person.getCar().setPriceBg(new BigDecimal("69990.00"));
        person.getCar().setManufacturer("vw");
        person.getCar().setLicensePlate("PKY8899");
        person.getCar().setSeatCount(5);
        person.setCars(Collections.singletonList(person.getCar()));

        final ValidationResult validationResult = personValidator.validate(person);
        assertTrue(validationResult.isValid());
        assertDoesNotThrow(() -> personValidator.validate(person).onErrorThrow(CustomValidationException.class));
    }

    @Test
    void successWhenPayloadAndFieldNameIsPresentTest() {
        Validators.PersonValidatorWithPayloadAndFieldName personValidator = new Validators.PersonValidatorWithPayloadAndFieldName();

        Person person = new Person();
        person.setAge(28);
        person.setCreatedAt(LocalDateTime.now().minusDays(1));
        person.setHeight(1.72);
        person.setName("Jean Leal Silva");
        person.setBirthDate(LocalDate.parse("1993-05-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        person.setCar(new Car());
        person.getCar().setActive(true);
        person.getCar().setLifeTime(400);
        person.getCar().setPrice(69990.00);
        person.getCar().setPriceBg(new BigDecimal("69990.00"));
        person.getCar().setManufacturer("vw");
        person.getCar().setLicensePlate("PKY8899");
        person.getCar().setSeatCount(5);
        person.setCars(Collections.singletonList(person.getCar()));

        final ValidationResult validationResult = personValidator.validate(person);
        assertTrue(validationResult.isValid());
        assertDoesNotThrow(() -> personValidator.validate(person).onErrorThrow(CustomValidationException.class));
    }

    @Test
    void errorWhenPayloadAndFieldNameIsPresentTest() {
        Validators.PersonValidatorWithPayloadAndFieldName personValidator = new Validators.PersonValidatorWithPayloadAndFieldName();

        final ValidationResult validationResult = personValidator.validate(null);

        assertFalse(validationResult.isValid());
        ValidationError validationError = validationResult.getErrors().get(0);
        assertEquals("person", validationError.getFieldName());
        assertNull(validationError.getAttemptedValue());
    }

    @Test
    void errorWhenPayloadAndValidateIfNullIsPresentTest() {
        Validators.PersonValidatorWithPayloadAndValidateIfNull personValidator = new Validators.PersonValidatorWithPayloadAndValidateIfNull();

        final ValidationResult validationResult = personValidator.validate(null);

        assertFalse(validationResult.isValid());
        ValidationError validationError = validationResult.getErrors().get(0);
        assertEquals("Person", validationError.getFieldName());
        assertNull(validationError.getAttemptedValue());
    }

    @Test
    void successWhenCarIsNullTest() {
        Validators.PersonValidator personValidator = new Validators.PersonValidator();

        Person person = new Person();
        person.setAge(28);
        person.setCreatedAt(LocalDateTime.now().minusDays(1));
        person.setHeight(1.72);
        person.setName("Jean Leal Silva");
        person.setBirthDate(LocalDate.parse("1993-05-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        person.setCar(null);

        final ValidationResult validationResult = personValidator.validate(person);
        assertTrue(validationResult.isValid());
        assertDoesNotThrow(() -> personValidator.validate(person).onErrorThrow(CustomValidationException.class));
    }

    @Test
    void failTest() {
        Validators.PersonValidator personValidator = new Validators.PersonValidator();

        Person person = new Person();
        person.setAge(28);
        person.setCreatedAt(LocalDateTime.now().minusDays(1));
        person.setHeight(1.72);
        person.setName("Jean Leal S");
        person.setBirthDate(LocalDate.parse("1993-05-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        person.setCar(new Car());
        person.getCar().setActive(true);
        person.getCar().setLifeTime(400);
        person.getCar().setPrice(69990.00);
        person.getCar().setPriceBg(new BigDecimal("69990.00"));
        person.getCar().setManufacturer("vw");
        person.getCar().setLicensePlate("PKY8899");
        person.getCar().setSeatCount(5);
        person.setCars(Arrays.asList(
                person.getCar(),
                new Car()
        ));

        final ValidationResult validationResult = personValidator.validate(person);
        assertFalse(validationResult.isValid());
        assertEquals(10, validationResult.getErrors().size());
    }

    @Test
    void failWithExceptionTest() {
        Validators.PersonValidator personValidator = new Validators.PersonValidator();

        Person person = new Person();
        person.setAge(28);
        person.setCreatedAt(LocalDateTime.now().minusDays(1));
        person.setHeight(1.72);
        person.setName("Jean Leal S");
        person.setBirthDate(LocalDate.parse("1993-05-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        person.setCar(new Car());
        person.getCar().setActive(true);
        person.getCar().setLifeTime(400);
        person.getCar().setPrice(69990.00);
        person.getCar().setPriceBg(new BigDecimal("69990.00"));
        person.getCar().setManufacturer("vw");
        person.getCar().setLicensePlate("PKY8899");
        person.getCar().setSeatCount(5);
        person.setCars(Arrays.asList(
                person.getCar(),
                new Car()
        ));

        ValidationResult validationResult = personValidator.validate(person);
        assertThrows(CustomValidationException.class, () -> validationResult.onErrorThrow(CustomValidationException.class));
    }

    @Test
    void failTestWithObjNull() {
        Validators.PersonValidator personValidator = new Validators.PersonValidator();
        final ValidationResult validationResult = personValidator.validate(null);
        assertFalse(validationResult.isValid());
        assertEquals(1, validationResult.getErrors().size());

        ValidationError validationError = validationResult.getErrors().get(0);
        assertEquals("Person", validationError.getFieldName());
        assertNull(validationError.getAttemptedValue());
    }
}
