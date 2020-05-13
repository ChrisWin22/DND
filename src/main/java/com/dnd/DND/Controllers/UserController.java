package com.dnd.DND.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.dnd.DND.Exceptions.EmailExistsException;
import com.dnd.DND.Exceptions.UsernameExistsException;
import com.dnd.DND.Models.Character;
import com.dnd.DND.Models.User;
import com.dnd.DND.Models.DTO.CharacterDto;
import com.dnd.DND.Models.DTO.CharacterFormDto;
import com.dnd.DND.Models.DTO.UserDto;
import com.dnd.DND.Repositories.CharacterRepository;
import com.dnd.DND.Repositories.UserRepository;

import com.dnd.DND.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SuppressWarnings("unused")
@Controller
@Validated
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository charRepo;

    @PostMapping("/createuser")
    public String addUser(@ModelAttribute("user") @Valid UserDto userdto, BindingResult result, Model model, HttpServletRequest request) {
        return createNewUserAccount(userdto,result);
    }

    @PostMapping("/user/createCharacter")
    public String createNew(@ModelAttribute("character") CharacterFormDto characterFormDto, Authentication authentication, Model model) {
        Character newChar = new Character();
        newChar.setName(characterFormDto.getName());
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        User temp = userRepository.findByUsername(userDetails.getUsername());
        charRepo.save(newChar);
        temp.addCharacters(newChar);
        userRepository.save(temp);
        return "redirect:/dashboard";
    }

    @PostMapping("/user/deleteCharacter")
    public String deleteChar(@ModelAttribute("character") CharacterDto characterDto, Authentication authentication, Model model){
        String id = characterDto.getId();
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        User temp = userRepository.findByUsername(userDetails.getUsername());
        temp.deleteCharacterByID(id);
        charRepo.deleteById(id);
        userRepository.save(temp);
        return "redirect:/dashboard";
    }

    private String createNewUserAccount(UserDto user, BindingResult result) {
        try {
            User register = userService.registerNewUserAccount(user);
            userRepository.save(register);
        } catch (EmailExistsException e) {
            return "redirect:/createuser?error=duplicateemail";
        } catch (UsernameExistsException e) {
            return "redirect:/createuser?error=duplicateusername";
        }
        return "redirect:/dashboard";
    }
}