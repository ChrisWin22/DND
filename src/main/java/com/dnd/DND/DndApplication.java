package com.dnd.DND;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import com.dnd.DND.Models.Elements.BoardElement;
import com.dnd.DND.Models.Elements.Character;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DndApplication {

	protected static List<Character> characterList;
	protected static List<List<BoardElement>> grid;

	public static void main(String[] args) {
		characterList = new ArrayList<>();
		grid = new ArrayList<>();
		SpringApplication.run(DndApplication.class, args);
	}

}
