package com.example.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

    Person person;

    @BeforeEach
    void setUp(){
        person = new Person("Alex", "assistant");
    }

    @Test
    void testGetName(){
        assertEquals("Alex", person.getName());
    }

    @Test
    void testGetRole(){
        assertEquals("assistant", person.getRole());
    }

    @Test
    void testGetId(){
        assertNotEquals(null, person.getId());
    }
}
