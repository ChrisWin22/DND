package com.dnd.DND.Models.DTO;

import com.dnd.DND.Security.Validators.PasswordMatches;

import javax.validation.constraints.*;

@PasswordMatches
public class UserDto{
    @NotNull
    @NotEmpty
    @Size(min=3,message="{Size.userDto.firstName}")
    @Pattern(regexp = "[a-zA-Z0-9.-_]*",message = "{Pattern.userDto.firstName}")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min=3,message="{Size.userDto.lastName}")
    @Pattern(regexp = "[a-zA-Z0-9.-_]*", message = "{Pattern.userDto.lastName}")
    private String lastName;

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotNull
    @Size(min=3,message = "{Size.userDto.username}")
    @Pattern(regexp = "[a-zA-Z0-9.-_]*", message = "{Pattern.userDto.username}")
    private String username;

    @NotEmpty
    @NotNull
    @Size(min=4,message="{Size.userDto.password}")
    @Pattern(regexp = "[a-zA-Z0-9!@#$%^&*}{;:/?.><,|+=]*",message = "{Pattern.userDto.password}")
    private String password;
    private String confirmPassword;

    public UserDto(){

    }


    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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