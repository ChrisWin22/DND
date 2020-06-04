package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Half_Elf extends Race{
    
    public Half_Elf(){
        super();
        charisma = 2;
        //TODO 2 scores of players choice +1
        size = Size.MEDIUM;
        speed = 30;
        vision = Vision.DARK;
        languages.addAll(Arrays.asList("Common", "Elvish", "Your Choice"));
    }

    @Override
    public String toString(){
        return "Half-Elf";
    }
}