package io.github.jeanls.simple_validator.validator;

import io.github.jeanls.simple_validator.dto.Car;
import io.github.jeanls.simple_validator.dto.Person;
import io.github.jeanls.simple_validator.validation.ValidationResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void successTest() {
        PersonValidator personValidator = new PersonValidator();

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

        final ValidationResult validationResult = personValidator.validate(person);
        assertTrue(validationResult.isValid());
    }

    @Test
    void failTest() {
        PersonValidator personValidator = new PersonValidator();

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

        final ValidationResult validationResult = personValidator.validate(person);
        assertFalse(validationResult.isValid());
        assertEquals(1, validationResult.getErrors().size());
    }

    @Test
    void failTestWithObjNull() {
        PersonValidator personValidator = new PersonValidator();
        final ValidationResult validationResult = personValidator.validate(null);
        assertFalse(validationResult.isValid());
        assertEquals(0, validationResult.getErrors().size());
    }
}
