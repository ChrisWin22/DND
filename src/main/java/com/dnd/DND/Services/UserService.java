package com.dnd.DND.Services;

import com.dnd.DND.Models.DTO.UserDto;
import com.dnd.DND.Models.User;
import com.dnd.DND.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userdto){
        User register=new User();
        register.setFirstName(userdto.getFirstName());
        register.setLastName(userdto.getLastName());
        register.setEmail(userdto.getEmail());
        register.setUsername(userdto.getUsername());
        register.setPassword(passwordEncoder.encode(userdto.getPassword()));
        register.addRole("user");
        return userRepository.save(register);

    }
}
