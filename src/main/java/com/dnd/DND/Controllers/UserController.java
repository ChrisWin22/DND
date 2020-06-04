package com.dnd.DND.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.dnd.DND.Exceptions.EmailExistsException;
import com.dnd.DND.Exceptions.UsernameExistsException;
import com.dnd.DND.Models.Elements.Character;
import com.dnd.DND.Models.Elements.User;
import com.dnd.DND.Models.Elements.Races.*;
import com.dnd.DND.Models.Elements.SubRaces.Drow;
import com.dnd.DND.Models.Elements.SubRaces.Forest_Gnome;
import com.dnd.DND.Models.Elements.SubRaces.High_Elf;
import com.dnd.DND.Models.Elements.SubRaces.Hill_Dwarf;
import com.dnd.DND.Models.Elements.SubRaces.LightFoot;
import com.dnd.DND.Models.Elements.SubRaces.Mountain_Dwarf;
import com.dnd.DND.Models.Elements.SubRaces.Rock_Gnome;
import com.dnd.DND.Models.Elements.SubRaces.Stout;
import com.dnd.DND.Models.Elements.SubRaces.SubRace;
import com.dnd.DND.Models.Elements.SubRaces.Wood_Elf;
import com.dnd.DND.Models.Enums.RaceEnum;
import com.dnd.DND.Models.Enums.SubRaceEnum;
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
        newChar.setRace(getRaceFromEnum(characterFormDto.getRace()));
        newChar.setSubrace(getSubRaceFromEnum(characterFormDto.getSubrace()));
        setAttributeScores(newChar, characterFormDto);
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

    private void setAttributeScores(Character c, CharacterFormDto cfd){
        c.setStr(cfd.getStr() + c.getRace().getStr());
        c.setDex(cfd.getDex() + c.getRace().getDex());
        c.setCharisma(cfd.getCharisma() + c.getRace().getCharisma());
        c.setIntell(cfd.getIntell() + c.getRace().getIntell());
        c.setConsti(cfd.getConsti() + c.getRace().getConsti());
        c.setWis(cfd.getWis() + c.getRace().getWis());

        if(c.getSubrace() != null){
            c.setStr(c.getStr() + c.getSubrace().getStr());
            c.setDex(c.getDex() + c.getSubrace().getDex());
            c.setCharisma(c.getCharisma() + c.getSubrace().getCharisma());
            c.setIntell(c.getIntell() + c.getSubrace().getIntell());
            c.setConsti(c.getConsti() + c.getSubrace().getConsti());
            c.setWis(c.getWis() + c.getSubrace().getWis());
        }
    }

    private Race getRaceFromEnum(RaceEnum r){
        switch(r){
            case DRAGONBORN: return new Dragonborn(); 
            case DWARF: return new Dwarf(); 
            case ELF:return new Elf(); 
            case GNOME:return new Gnome(); 
            case HALFELF:return new Half_Elf(); 
            case HALFORC: return new Half_Orc(); 
            case HALFLING:return new Halfling(); 
            case HUMAN: return new Human(); 
            case TIEFLING: return new Tiefling(); 
            default: return new Race();
        }
    }

    private SubRace getSubRaceFromEnum(SubRaceEnum s){
        if(s != null){
            switch(s){
                case HILLDWARF: return new Hill_Dwarf();
                case MOUNTAINDWARF: return new Mountain_Dwarf();
                case HIGHELF: return new High_Elf();
                case WOODELF: return new Wood_Elf();
                case DROW: return new Drow();
                case LIGHTFOOT: return new LightFoot();
                case STOUT: return new Stout();
                case FORESTGNOME: return new Forest_Gnome();
                case ROCKGNOME: return new Rock_Gnome();
                default: return null;
            }
        }else{
            return null;
        }
    }
}