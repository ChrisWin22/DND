package com.dnd.DND.Models.Elements.SubRaces;

public class High_Elf extends SubRace{
    
    public High_Elf(){
        super();
        intell += 1;
        languages.add("Your Choice");
    }

    @Override
    public String toString(){
        return "High";
    }
}