package com.example.api;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private List<Person> persons = new ArrayList<>();
    private static DataStore instance = new DataStore();

    public static DataStore getInstance() {
        return instance;
    }

    private DataStore() {
        persons.add(new Person("Ada", "foo"));
        persons.add(new Person("Kevin", "foo"));
        persons.add(new Person("Stanley", "foo"));
    }

    public List<Person> getPersonRole(String role) {
        List<Person> res = new ArrayList<>();
        for (Person p : persons)
            if (p.getRole().equals(role)) res.add(p);
        return res;
    }

    public Person getPerson(String id) {
        for (Person p : persons)
            if (p.getId().equals(id)) return p;
        return null;
    }

    public void putPerson(Person person) {
        persons.add(person);
    }
}