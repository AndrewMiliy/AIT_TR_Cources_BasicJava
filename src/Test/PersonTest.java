package Test;

import L_35.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class PersonTest {

    Person person;

    String name = "John";
    int age = 42;

    @BeforeEach
    void setUp() {
        person = new Person(name, age);
    }

    @BeforeAll
    void beforeAll() {

    }

    @org.junit.jupiter.api.Test
    void getName() {
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

}