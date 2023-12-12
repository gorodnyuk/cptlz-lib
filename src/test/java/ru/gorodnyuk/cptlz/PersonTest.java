package ru.gorodnyuk.cptlz;

import java.time.LocalDate;

public class PersonTest {

    private final String name;

    private final String address;

    private final Integer age;

    private final LocalDate birthDate;

    public PersonTest(String name, String address, Integer age, LocalDate birthDate) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.birthDate = birthDate;
    }
}
