package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Half_Orc extends Race{

    public Half_Orc(){
        super();
        str = 2;
        consti = 1;
        size = Size.MEDIUM;
        speed = 30;
        vision = Vision.DARK;
        languages.addAll(Arrays.asList("Common", "Orc"));
    }

    @Override
    public String toString(){
        return "Half-Orc";
    }
    
}