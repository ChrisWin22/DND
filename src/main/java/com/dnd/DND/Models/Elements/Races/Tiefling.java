package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Tiefling extends Race{
    
    public Tiefling(){
        super();
        intell = 1;
        charisma = 2;
        size = Size.MEDIUM;
        speed = 30;
        vision = Vision.DARK;
        languages.addAll(Arrays.asList("Common", "Infernal"));
    }

    @Override
    public String toString(){
        return "Tiefling";
    }
}