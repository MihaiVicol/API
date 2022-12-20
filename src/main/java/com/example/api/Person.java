package com.example.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


}