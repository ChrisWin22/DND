package com.dnd.DND.Models.DTO;

public class CharacterFormDto{
    private String name;
    private String race;

    public CharacterFormDto(){
        
    }


    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}