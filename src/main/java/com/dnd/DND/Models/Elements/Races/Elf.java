package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Elf extends Race{
    
    public Elf(){
        super();
        dex = 2;
        size = Size.MEDIUM;
        speed = 30;
        vision = Vision.DARK;
        languages.addAll(Arrays.asList("Common", "Elvish"));
    }

    @Override
    public String toString(){
        return "Elf";
    }
}