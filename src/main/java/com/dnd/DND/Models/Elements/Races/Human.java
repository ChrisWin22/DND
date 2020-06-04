package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Human extends Race{
    
    public Human(){
        super();
        str = 1;
        wis = 1;
        dex = 1;
        consti = 1;
        intell = 1;
        charisma = 1;
        size = Size.MEDIUM;
        speed = 30;
        vision = Vision.REGULAR;
        languages.addAll(Arrays.asList("Common", "You Choose"));
    }

    @Override
    public String toString(){
        return "Human";
    }
}