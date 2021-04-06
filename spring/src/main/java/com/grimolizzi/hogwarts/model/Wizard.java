package com.grimolizzi.hogwarts.model;

public class Wizard {
	private String id;
	private String name;
	private String surname;
	private House house;
	
	public Wizard(String id, String name, String surname, House house) {
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setHouse(house);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "Wizard [name=" + name + ", surname=" + surname + ", house=" + house.getName() + "]";
	}
	@Override
	public boolean equals(Object o) {

		if (o == null)
			return false;

		if (this.getClass() != o.getClass())
			return false;
		
		Wizard wizard = (Wizard) o;

		return this.id.equals(wizard.getId())
				&& this.name.equals(wizard.getName())
				&& this.surname.equals(wizard.getSurname());
	}
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
