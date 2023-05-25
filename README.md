# Simple Validator

[![Maven Central](https://img.shields.io/maven-central/v/io.github.jeanls/simple_validator.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.jeanls%22%20AND%20a:%22simple_validator%22)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jeanls_simple_validator&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=jeanls_simple_validator)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=jeanls_simple_validator&metric=coverage)](https://sonarcloud.io/summary/new_code?id=jeanls_simple_validator)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=jeanls_simple_validator&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=jeanls_simple_validator)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=jeanls_simple_validator&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=jeanls_simple_validator)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=jeanls_simple_validator&metric=bugs)](https://sonarcloud.io/summary/new_code?id=jeanls_simple_validator)

A simple validator lambda based for java fields validation.

## 1. Getting started.

pom.xml

````xml
<dependency>
    <groupId>io.github.jeanls</groupId>
    <artifactId>simple_validator</artifactId>
    <version>1.1.9</version>
</dependency>
````

build.gradle

````groovy
implementation 'io.github.jeanls:simple_validator:1.1.9'
````

## 2. Example of usage.

````java
public class Person {

    private String name;
    private LocalDate birthDate;
    private Double height;
    private int age;
    private Car car;
    private LocalDateTime createdAt;

    //GET, SET
}

public class Car {

    private String manufacturer;
    private String licensePlate;
    private double price;
    private BigDecimal tax;
    private long lifeTime;
    private boolean active;

    //GET, SET
}
````

### 2.1. Basic validation.

````java
public class PersonValidator extends Validator<Person> {

    @Override
    public ValidationResult validate(Person obj) {

        return addNumberRule(Person::getAge, "age", r -> r.notNull().greaterThan(18))
                .addLocalDateTimeRule(Person::getCreatedAt, "created_at", r -> r.notNull().isPast())
                .addLocalDateRule(Person::getBirthDate, "birth_date", r -> r.notNull().isPast())
                .addNumberRule(Person::getHeight, "height", r -> r.notNull().greaterThan(1.70))
                .addCharSequenceRule(Person::getName, "name", r -> r.notNull().notBlank().greaterThanOrEquals(10))
                .addObjectRule(Person::getCar, "car", ObjectRule::notNull)
                .addListRule(Person::getCars, "cars", r -> r.notNull().lessThan(10))
                .run(obj);
    }
}
````

### 2.2. Sub class validation.

Validation for class `Car` inside `Person`.

````java
public class PersonValidator extends Validator<Person> {

    @Override
    public ValidationResult validate(Person obj) {

        CarValidator carValidator = new CarValidator();

        return addNumberRule(Person::getAge, "age", r -> r.notNull().greaterThan(18))
                .addValidator(Person::getCar, carValidator)
                .run(obj);
    }
}
````

Validation for ``Car``.

````java
public class CarValidator extends Validator<Car> {

    @Override
    public ValidationResult validate(Car obj) {
        return addCharSequenceRule(Car::getLicensePlate, "person.car.plate", r -> r.isUpperCase().notNull())
                .addNumberRule(Car::getSeatCount, "seat_count", i -> i.notNull().greaterThan(4))
                .addNumberRule(Car::getLifeTime, "life_time", i -> i.notNull().isPositive())
                .addNumberRule(Car::getPrice, "price", i -> i.isPositive().greaterThan(new BigDecimal("30000.00")))
                .addNumberRule(Car::getTax, "tax", i -> i.isPositive().lessThan(new BigDecimal("100000.00")))
                .addBooleanRule(Car::isActive, "active", b -> b.notNull().isTrue())
                .run(obj);
    }
}
````

### 2.3. Validation results

````java
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
        person.getCar().setTax(new BigDecimal("69990.00"));
        person.getCar().setManufacturer("vw");
        person.getCar().setLicensePlate("PKY8899");
        person.getCar().setSeatCount(5);

        final ValidationResult validationResult = personValidator.validate(person);
        List<ValidationError> errors = validationResult.getErrors();
        assertTrue(validationResult.isValid());
        assertEquals(0, errors.size());
    }
}
````

### 2.4. Validation for items in lists.

#### You can create a validator for the items in a list.

````java
public class PersonValidator extends Validator<Person> {

    @Override
    public ValidationResult validate(Person obj) {

        CarValidator carValidator = new CarValidator();

        return addItemListValidator(Person::getCars, carValidator)
                .run(obj);
    }
}

````

### 3. Custom rules.

You can create a custom rules for validate yours fields.

````java
public class CustomRuleEx extends Rule<String> {

    public CustomRuleEx isNameEqualsJean() {
        this.addPredicate(new RulePredicate<>(s -> s.equals("Jean Leal Silva"), "O nome deve ser igual a Jean Leal Silva."));
        return this;
    }
}


````

````java
public class PersonValidator extends Validator<Person> {

    @Override
    public ValidationResult validate(Person obj) {

        CarValidator carValidator = new CarValidator();

        return addNumberRule(Person::getAge, "age", r -> r.notNull().greaterThan(18))
                .addCustomRule(Person::getName, "name", CustomRuleEx::new, CustomRuleEx::validate)
                .run(obj);
    }
}
````

### 4. Add custom messages for rules.

Every constraint has a message parameter.

````java
public class PersonValidator extends Validator<Person> {

    @Override
    public ValidationResult validate(Person obj) {

        CarValidator carValidator = new CarValidator();

        return addNumberRule(Person::getAge, "age", r -> r.notNull("Cannot be null").greaterThan(18, "The age must be greater than 18."))
                .run(obj);
    }
}
````

### 5. Main classes.

``ValidationResult``

| **Method**                                          | **Returns**            | **Description**                                                                                      |
|-----------------------------------------------------|------------------------|------------------------------------------------------------------------------------------------------|
| isValid()                                           | boolean                | indicates if validation is ok                                                                        |
| getErrors()                                         | List\<ValidationError> | List of validation errors                                                                            |
| onErrorThrow(Class\<T extends ValidationException>) | throw exception        | Throw exception with ValidationResult, the extension must extend from the class ValidationException  |

``ValidationError``

| **Method**          | **Returns**                    |
|---------------------|--------------------------------|
| getFieldName()      | Field name of validation.      |
| getAttemptedValue() | Attempted value of validation. |
| getMessage()        | Error message of validation.   |
