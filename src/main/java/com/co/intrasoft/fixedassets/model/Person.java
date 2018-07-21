package com.co.intrasoft.fixedassets.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Person implements AssignableResource {

    @Id
    private String id;
    private String name;
    private String lastname;
    private String position;

    public Person() {
    }

    public Person(String id, String name, String lastname, String position) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, lastname, position);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
