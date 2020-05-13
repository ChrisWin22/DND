package com.dnd.DND.Services;

import com.dnd.DND.Exceptions.EmailExistsException;
import com.dnd.DND.Exceptions.UsernameExistsException;
import com.dnd.DND.Models.DTO.UserDto;
import com.dnd.DND.Models.User;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto) throws UsernameExistsException, EmailExistsException;
}
