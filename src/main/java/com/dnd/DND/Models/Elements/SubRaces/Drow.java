package com.dnd.DND.Models.Elements.SubRaces;

import com.dnd.DND.Models.Enums.Vision;

public class Drow extends SubRace{
    
    public Drow(){
        super();
        charisma += 1;
        vision = Vision.SUPERIOR;
    }


    @Override
    public String toString(){
        return "Drow/Dark";
    }
}