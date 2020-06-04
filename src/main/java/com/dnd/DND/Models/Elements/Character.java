package com.dnd.DND.Models.Elements;

import com.dnd.DND.Models.Enums.Class;
import com.dnd.DND.Models.Elements.Races.*;
import com.dnd.DND.Models.Enums.SubRace;

import org.springframework.data.annotation.Id;

public class Character extends BoardElement{
    @Id
    public String id;

    private String name;
    private Race race;
    private Class characterClass;
    private String background;
    private SubRace subrace;
    private String alignment;
    private double xp;
    private int age;
    private int weight;
    private double height; // ex. 5.9
    private String eye;
    private String hair;
    private String deity_religion;

    private int str;
    private int dex;
    private int consti;
    private int intell;
    private int wis;
    private int charisma;
    private int sanity;

    private int acrobatics;
    private int animal;
    private int arcana;
    private int athletics;
    private int deception;
    private int history;
    private int insight;
    private int intimidation;
    private int investigation;
    private int medicine;
    private int nature;
    private int perception;
    private int performance;
    private int persuasion;
    private int religion;
    private int sleight;
    private int stealth;
    private int survival;

    private int passivePerception;

    private int maxHP;
    private int init;
    private int hitPoints;
    private int speed;
    private int AC;

    public Character(){
        
    }
    
    public Class getCharacterClass() {
        return this.characterClass;
    }

    public void setCharacterClass(Class characterClass) {
        this.characterClass = characterClass;
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return this.race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public SubRace getSubrace() {
        return this.subrace;
    }

    public void setSubrace(SubRace subrace) {
        this.subrace = subrace;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public double getXp() {
        return this.xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getEye() {
        return this.eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getHair() {
        return this.hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getDeity_religion() {
        return this.deity_religion;
    }

    public void setDeity_religion(String deity_religion) {
        this.deity_religion = deity_religion;
    }

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

    public int getSanity() {
        return this.sanity;
    }

    public void setSanity(int sanity) {
        this.sanity = sanity;
    }

    public int getAcrobatics() {
        return this.acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public int getAnimal() {
        return this.animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public int getArcana() {
        return this.arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    public int getAthletics() {
        return this.athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getDeception() {
        return this.deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getHistory() {
        return this.history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getInsight() {
        return this.insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public int getIntimidation() {
        return this.intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public int getInvestigation() {
        return this.investigation;
    }

    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }

    public int getMedicine() {
        return this.medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public int getNature() {
        return this.nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public int getPerception() {
        return this.perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getPerformance() {
        return this.performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPersuasion() {
        return this.persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getReligion() {
        return this.religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getSleight() {
        return this.sleight;
    }

    public void setSleight(int sleight) {
        this.sleight = sleight;
    }

    public int getStealth() {
        return this.stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getSurvival() {
        return this.survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getPassivePerception() {
        return this.passivePerception;
    }

    public void setPassivePerception(int passivePerception) {
        this.passivePerception = passivePerception;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getInit() {
        return this.init;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAC() {
        return this.AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }


}