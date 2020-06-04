package com.dnd.DND.Models.Elements.Races;

import java.util.ArrayList;
import java.util.List;

import com.dnd.DND.Models.Enums.Size;
import com.dnd.DND.Models.Enums.Vision;

public class Race {

    //Ability Score Modifiers
    int str;
    int dex;
    int wis;
    int charisma;
    int consti;
    int intell;

    int speed;
    List<String> languages;
    Vision vision;
    Size size;

    public Race(){
        str = 0;
        dex = 0;
        wis = 0;
        charisma = 0;
        consti = 0;
        intell = 0;
        speed = 0;
        vision = Vision.REGULAR;
        languages = new ArrayList<>();
        size = Size.MEDIUM;
    }

    @Override
    public String toString(){
        return "";
    }
}