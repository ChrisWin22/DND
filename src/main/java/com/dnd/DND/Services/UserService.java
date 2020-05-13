package com.dnd.DND.Services;

import com.dnd.DND.Exceptions.EmailExistsException;
import com.dnd.DND.Exceptions.UsernameExistsException;
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
    public User registerNewUserAccount(UserDto userdto) throws UsernameExistsException,EmailExistsException {
        if (usernameExists(userdto.getUsername())){
            throw new UsernameExistsException("there was an account with this username: " + userdto.getUsername());
        }
        if (emailExists(userdto.getEmail())){
            throw new EmailExistsException("There was an account with the email: " + userdto.getEmail());
        }
        User register=new User();
        register.setFirstName(userdto.getFirstName());
        register.setLastName(userdto.getLastName());
        register.setEmail(userdto.getEmail());
        register.setUsername(userdto.getUsername());
        register.setPassword(passwordEncoder.encode(userdto.getPassword()));
        register.addRole("user");
        return userRepository.save(register);

    }
    private boolean usernameExists(String username){
        User user=userRepository.findByUsername(username);
        if (user==null){
            return false;
        } else {
            return true;
        }
    }
    private boolean emailExists(String email){
        User user=userRepository.findByEmail(email);
        if (user==null){
            return false;
        } else {
            return true;
        }
    }
}
