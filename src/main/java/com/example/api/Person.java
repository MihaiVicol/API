package com.example.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class Person {
    private String name;
    private String role;
    @JsonIgnore
    private String id;

    public Person() {
    }

    public Person(String name, String role) {
        this.id = UUID.nameUUIDFromBytes(name.getBytes()).toString();
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && role.equals(person.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }
}