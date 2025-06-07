package com.sqli.isc.iut.courses.cucumber;

public class Client {
    private String name;
    public boolean isSeated = false;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
