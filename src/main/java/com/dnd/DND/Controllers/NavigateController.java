package com.dnd.DND.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dnd.DND.Models.User;
import com.dnd.DND.DndApplication;
import com.dnd.DND.Models.Character;
import com.dnd.DND.Models.DTO.CharacterDto;
import com.dnd.DND.Models.DTO.CharacterFormDto;
import com.dnd.DND.Models.DTO.SignInDto;
import com.dnd.DND.Models.DTO.UserDto;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@EnableAutoConfiguration
@Controller
public class NavigateController extends DndApplication{

    @RequestMapping("/signin")
    public String navSignIn(Model model){
        model.addAttribute("userdto", new SignInDto());
        return "SignIn";
    }

    @RequestMapping("/failed_signin")
    public String navFailSignIn(Model model){
        model.addAttribute("error", true);
        model.addAttribute("error_message", "Incorrect Username or Password");
        model.addAttribute("userdto", new SignInDto());
        return "SignIn";
    }

    @RequestMapping("/createuser")
    public String navCreateUser(Model model){
        model.addAttribute("user", new UserDto());
        return "createUser";
    }

    @RequestMapping("/createuser-wrong-match")
    public String createUserWrongMatch(Model model){
        model.addAttribute("error", true);
        model.addAttribute("error_message", "Passwords Do Not Match");
        model.addAttribute("user", new UserDto());
        return "createUser";
    }

    @RequestMapping("/dashboard")
    public String navDashboard(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User temp = (User)session.getAttribute("user");
        model.addAttribute("user", temp);
        model.addAttribute("list", temp.getCharacters());
        model.addAttribute("characterdto", new CharacterDto());
        return "dashboard";
    }

    @RequestMapping("/characterCreation")
    public String navCreateCharacter(Model model, HttpServletRequest request){
        model.addAttribute("characterformdto", new CharacterFormDto());
        return "createCharacter";
    }

    @RequestMapping("/signout")
    public String navSignOut(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        return "redirect:/";
    }

    @RequestMapping("/ingame")
    public String navInGame(@ModelAttribute("char") Character character, Model model, HttpServletRequest request){
        model.addAttribute("name", character.getName());
        return "inGame";
    }

    @PostMapping("/playerInGame")
    public String postInGame(@ModelAttribute("characterdto") CharacterDto characterDto, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User temp = (User)(session.getAttribute("user"));
        Character tempChar = temp.findCharacterById(characterDto.getId());
        characterList.add(tempChar);
        model.addAttribute("char", tempChar);
        return "redirect:/ingame";
    }
}