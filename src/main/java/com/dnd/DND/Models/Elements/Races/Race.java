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

    //Getters and Setters

    public int getStr() {
        return this.str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return this.dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getWis() {
        return this.wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getConsti() {
        return this.consti;
    }

    public void setConsti(int consti) {
        this.consti = consti;
    }

    public int getIntell() {
        return this.intell;
    }

    public void setIntell(int intell) {
        this.intell = intell;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<String> getLanguages() {
        return this.languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Vision getVision() {
        return this.vision;
    }

    public void setVision(Vision vision) {
        this.vision = vision;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}