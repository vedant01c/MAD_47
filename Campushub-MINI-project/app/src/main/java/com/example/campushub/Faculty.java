package com.example.campushub;

public class Faculty {
    private String name;
    private String cabin;
    private String email;

    // Constructor: This is used to create a new Faculty object with data
    public Faculty(String name, String cabin, String email) {
        this.name = name;
        this.cabin = cabin;
        this.email = email;
    }

    // Getters: These are used by the Adapter to "get" the information
    public String getName() {
        return name;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmail() {
        return email;
    }
}
