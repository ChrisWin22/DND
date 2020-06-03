package com.dnd.DND.Repositories;

import com.dnd.DND.Models.Elements.Character;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {
    public Character findByName(String name);
}