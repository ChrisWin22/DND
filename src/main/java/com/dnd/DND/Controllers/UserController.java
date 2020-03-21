package com.dnd.DND.Controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dnd.DND.Models.Character;
import com.dnd.DND.Models.User;
import com.dnd.DND.Models.DTO.CharacterFormDto;
import com.dnd.DND.Models.DTO.SignInDto;
import com.dnd.DND.Models.DTO.UserDto;
import com.dnd.DND.Repositories.CharacterRepository;
import com.dnd.DND.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CharacterRepository charRepo;

    @PostMapping("/user")
    public String addUser(@ModelAttribute("user") UserDto userdto, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (userdto.getPassword().compareTo(userdto.getConfirmPassword()) != 0) {
            return "redirect:/createuser-wrong-match";
        }
        User register = new User();
        register.setFirstName(userdto.getFirstName());
        register.setLastName(userdto.getLastName());
        register.setEmail(userdto.getEmail());
        register.setUsername(userdto.getUsername());
        register.setPassword(userdto.getPassword());
        userRepository.save(register);
        session.setAttribute("user", register);
        return "redirect:/dashboard";
    }

    @PostMapping("/user/signin")
    public String signIn(@ModelAttribute("userdto") SignInDto SignInDto, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User temp = userRepository.findByUsername(SignInDto.getUsername());
        if (temp.getPassword().compareTo(SignInDto.getPassword()) != 0) {
            return "redirect:/failed_signin";
        }
        session.setAttribute("user", temp);
        return "redirect:/dashboard";
    }

    @PostMapping("/user/createCharacter")
    public String createNew(@ModelAttribute("character") CharacterFormDto characterFormDto, HttpServletRequest request, Model model) {
        Character newChar = new Character();
        newChar.setName(characterFormDto.getName());
        HttpSession session = request.getSession();
        String username = ((User) session.getAttribute("user")).getUsername();
        User temp = (User)userRepository.findByUsername(username);
        charRepo.save(newChar);
        temp.addCharacters(newChar);
        session.setAttribute("user", temp);
        userRepository.save(temp);
        return "redirect:/dashboard";
    }

}