package com.dnd.DND.Models.DTO;

public class SignInDto{
    private String username;
    private String password;

    public SignInDto(){
        
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