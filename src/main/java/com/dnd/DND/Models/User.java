package com.dnd.DND.Models;

public class User{
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public User(){

    }

    public User(String fName, String lName, String em, String uName, String pass){
        firstName = fName;
        lastName = lName;
        email = em;
        username = uName;
        password = pass;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
		this.password = password;
	}
}