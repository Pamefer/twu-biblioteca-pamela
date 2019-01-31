package com.twu.biblioteca;

public class Resource {
    private String name;
    private Boolean available;

    public Resource(String name, Boolean available) {
        this.name = name;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
