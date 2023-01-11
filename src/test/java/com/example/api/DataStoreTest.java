package com.example.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataStoreTest {
    DataStore dataStore;

    @BeforeEach
    void setUp(){
        dataStore=DataStore.getInstance();
    }

    @Test
    void testGetPersonRole(){
        List<Person> personList = new ArrayList<>();
        String role = "foo";
        personList.add(new Person("Ada",role));
        personList.add(new Person("Stanley",role));
        personList.add(new Person("Kevin",role));
        System.out.println(dataStore.getPersonRole(role));
        assertTrue(personList.size() == dataStore.getPersonRole(role).size()
                && personList.containsAll(dataStore.getPersonRole(role))
                && dataStore.getPersonRole(role).containsAll(personList));
    }

    @Test
    void testGetPerson(){
        List<Person> personList = dataStore.getPersonRole("foo");
        String id = null;
        for(Person person: personList){
            if(person.getName().equals("Kevin"))
                id=person.getId();
        }
        assertNotEquals(null, id);
        assertEquals("Kevin", dataStore.getPerson(id).getName());
    }

    @Test
    void testPutPerson(){
        Person person = new Person("Radu", "assistant");
        dataStore.putPerson(person);
        assertEquals(person,dataStore.getPerson(person.getId()));
    }
}
