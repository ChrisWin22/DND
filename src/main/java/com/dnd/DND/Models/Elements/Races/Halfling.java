package com.dnd.DND.Models.Elements.Races;

import java.util.Arrays;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Halfling extends Race{
    
    public Halfling(){
        super();
        dex = 2;
        size = Size.SMALL;
        speed = 25;
        vision = Vision.REGULAR;
        languages.addAll(Arrays.asList("Common", "Halfling"));
    }
}