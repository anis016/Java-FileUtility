package com.starter.pojo;

import java.io.Serializable;

public class Person implements Serializable {

    private static int nextId;
    private final Integer id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Person{id=%d, firstName='%s', lastName='%s'}", id, firstName, lastName);
    }
}
