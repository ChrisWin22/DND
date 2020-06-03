package com.dnd.DND.Models.Elements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class User {
    @Id 
    public String id;
    
    public String firstName;
    public String lastName;
    public String email;
    public String username;
    public String password;
    public List<Character> characters;
    private List<String> roles;


    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role){
        roles.add(role);
    }

    public User(){
        characters = new ArrayList<>();
        roles = new ArrayList<>();
    }

    public User(String fName, String lName, String em, String uName, String pass){
        firstName = fName;
        lastName = lName;
        email = em;
        username = uName;
        password = pass;
        characters = new ArrayList<Character>();
    }

    public Character findCharacterById(String id){
        for(Character c : characters){
            if(c.getId().compareTo(id) == 0){
                return c;
            }
        }
        System.out.println("ERROR: Can't find character");
        return null;
    }

    public void deleteCharacterByID(String id){
        Character toRemove = findCharacterById(id);
        characters.remove(toRemove);
    }



    //Getters and Setters

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Character> getCharacters() {
        return this.characters;
    }

    public void setCharacters(ArrayList<Character> c){
        characters = c;
    }

    public void addCharacters(Character character) {
        characters.add(character);
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