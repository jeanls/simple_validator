package br.com.simplevalidator.dto;

import br.com.simplevalidator.Car;
import br.com.simplevalidator.Validator;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate birthDate;
    private Double height;
    private int age;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public ValidationResult validate() {
//        return
//    }
}
