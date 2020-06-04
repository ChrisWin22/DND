package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Dragonborn extends Race{
    
    public Dragonborn(){
        super();
        str = 2;
        charisma = 1;
        size = Size.MEDIUM;
        speed = 30;
        vision = Vision.REGULAR;
        languages.addAll(Arrays.asList("Common", "Draconic"));
    }

    @Override
    public String toString(){
        return "Dragonborn";
    }
}