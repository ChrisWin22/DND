package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Dwarf extends Race{
    
    public Dwarf(){
        super();
        consti = 2;
        vision = Vision.DARK;
        speed = 25;
        size = Size.MEDIUM;
        languages.addAll(Arrays.asList("Common", "Dwarvish"));
    }

    @Override
    public String toString(){
        return "Dwarf";
    }
}