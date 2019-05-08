package com.json;

public class Dog {
	private String id;
	private String name;
	private String owner;
	private String notes;
	
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	// Empty constructor for Jackson API
	public Dog () {
	}
	
	public Dog(String _id, String _name, String _owner, String _notes) {
		id = _id;
		name = _name;
		owner = _owner;
		notes = _notes;
	}
}
