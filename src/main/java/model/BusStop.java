package com.example.dsaproject.model;

public class BusStop {
    private String id;
    private String name;
    private String location;

    public BusStop(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return name;
    }
}
