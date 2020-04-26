package com.dnd.DND.Security.Validators;

import com.dnd.DND.Models.DTO.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, UserDto> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context){
        UserDto user = userDto;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
