package br.com.simplevalidator.dto;

import br.com.simplevalidator.Validator;
import br.com.simplevalidator.validation.ValidationResult;

import java.time.LocalDate;

public class Person extends Validator<Person> {

    private String name;
    private LocalDate birthDate;
    private Double height;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static ValidationResult validate(final Person person) {
        return person.addCharSequenceRule(Person::getName, "name", rule -> rule.notNull()
                        .greaterThanOrEquals(5)
                        .notBlank()
                        .equalsTo("Jean Leal Silva")
                )
                .run(person);
    }
}
