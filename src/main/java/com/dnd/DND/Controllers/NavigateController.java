package com.dnd.DND.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dnd.DND.Models.User;
import com.dnd.DND.DndApplication;
import com.dnd.DND.Models.Character;
import com.dnd.DND.Models.DTO.CharacterDto;
import com.dnd.DND.Models.DTO.CharacterFormDto;
import com.dnd.DND.Models.DTO.UserDto;

import com.dnd.DND.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.security.Principal;

@EnableAutoConfiguration
@Controller
public class NavigateController extends DndApplication{
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String navSignIn(Model model){
        return "login";
    }

    @GetMapping("/createuser")
    public String navCreateUser(Model model){
        model.addAttribute("user", new UserDto());
        return "createUser";
    }

    @GetMapping("/dashboard")
    public String navDashboard(Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User temp=userRepository.findByUsername(userDetails.getUsername());
        model.addAttribute("user", temp);
        model.addAttribute("list", temp.getCharacters());
        model.addAttribute("characterdto", new CharacterDto());
        return "dashboard";
    }

    @RequestMapping("/characterCreation")
    public String navCreateCharacter(Model model){
        model.addAttribute("characterformdto", new CharacterFormDto());
        return "createCharacter";
    }

    @RequestMapping("/ingame")
    public String navInGame(@ModelAttribute("char") Character character, Model model){
        model.addAttribute("name", character.getName());
        return "inGame";
    }

    @PostMapping("/playerInGame")
    public String postInGame(@ModelAttribute("characterdto") CharacterDto characterDto, Model model,Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User temp = userRepository.findByUsername(userDetails.getUsername());
        Character tempChar = temp.findCharacterById(characterDto.getId());
        characterList.add(tempChar);
        model.addAttribute("char", tempChar);
        return "redirect:/ingame";
    }
}