package com.dnd.DND.Controllers;

import com.dnd.DND.Models.User;
import com.dnd.DND.Models.DTO.UserDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


@Controller
public class NavigateController{

    @RequestMapping("/signin")
    public String navSignIn(){
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
    public String navDashboard(User user, Model model){

        return "dashboard";
    }
}