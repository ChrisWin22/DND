package com.dnd.DND.Controllers;

import com.dnd.DND.Models.User;
import com.dnd.DND.Models.DTO.UserDto;
import com.dnd.DND.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController{

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public String addUser(@ModelAttribute("user") UserDto userdto, Model model){
        if(userdto.getPassword().compareTo(userdto.getConfirmPassword()) != 0){
            return "redirect:/createuser-wrong-match";
        }
        User register = new User();
        register.setFirstName(userdto.getFirstName());
        register.setLastName(userdto.getLastName());
        register.setEmail(userdto.getEmail());
        register.setUsername(userdto.getUsername());
        register.setPassword(userdto.getPassword());
        userRepository.save(register);
        return "redirect:/dashboard";
    }
}