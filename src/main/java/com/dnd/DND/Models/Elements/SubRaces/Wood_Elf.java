package com.dnd.DND.Models.Elements.SubRaces;

public class Wood_Elf extends SubRace{
    
    public Wood_Elf(){
        super();
        wis += 1;
        speed = 35;
    }

    @Override
    public String toString(){
        return "Wood";
    }
}