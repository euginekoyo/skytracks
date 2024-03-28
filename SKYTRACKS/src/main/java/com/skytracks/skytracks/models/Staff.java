package com.skytracks.skytracks.models;

public class Staff {
    private String email;
    private String name;
    private String address;
    private String role;
    private String password; // Be cautious with password handling in real applications

    // Constructor
    public Staff(String email, String name, String address, String role, String password) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
