package com.grimolizzi.hogwarts.model;


public enum House {
	GRYFFINDOR("Gryffindor"),
	HUFFLEPUFF("Hufflepuff"),
	RAVENCLAW("Ravenclaw"),
	SLYTHERIN("Slytherin");
	
	private final String name;
	
	House(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
