package com.co.intrasoft.fixedassets.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Area {

    @Id
    private String id;
    private String name;
    private String city;

    public Area() {
    }

    public Area(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) &&
                Objects.equals(name, area.name) &&
                Objects.equals(city, area.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, city);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
