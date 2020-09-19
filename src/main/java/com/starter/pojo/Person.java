package com.starter.pojo;

import java.io.Serializable;
import java.text.MessageFormat;

public class Person implements Serializable {

    static int nextId;
    private Integer id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
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
        return MessageFormat.format("Person'{'id={0}, firstName=''{1}'', lastName=''{2}'''}'", id, firstName, lastName);
    }
}
