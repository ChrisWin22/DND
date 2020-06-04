package com.dnd.DND.Models.Elements.SubRaces;

public class Hill_Dwarf extends SubRace{
    
    public Hill_Dwarf(){
        super();
        wis += 1;
    }

    @Override
    public String toString(){
        return "Hill";
    }
}