package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Gnome extends Race{

    public Gnome(){
        super();
        intell = 2;
        size = Size.SMALL;
        speed = 25;
        vision = Vision.DARK;
        languages.addAll(Arrays.asList("Common", "Gnomish"));
    }
    

    @Override
    public String toString(){
        return "Gnome";
    }
}