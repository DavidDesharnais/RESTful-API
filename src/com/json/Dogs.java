package com.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class Dogs {
	private List<Dog> allDogs = new ArrayList<Dog>();
	
	// Empty Constructor for Jackson API
	public Dogs() {
	}
	
	public Dogs(List<Dog> _allDogs) {
		allDogs = _allDogs;
	}
	
	public List<Dog> getList(){
		return allDogs;
	}
	public void SetList(List<Dog> _allDogs){
		allDogs = _allDogs;
	}
	public String getDogs() {
		String dogsString = "";
		for (Dog searchFido : allDogs) {
			dogsString += "Name: " + searchFido.getName() + ", Owner: " + searchFido.getOwner() + ", Notes: " + searchFido.getNotes() + System.getProperty("line.separator");
		}
		
		return dogsString;
	}
	
	public void postDogInList(Dog addFido) {
		allDogs.add(addFido);
	}
	
	public String deleteDogInList(String id) {
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
					allDogs.remove(searchFido);
					return "Dog removed!";
			}
		}
		return "Dog could not be removed from list.";
	}
	
	public String getDog(String id) {
		String dogString = "No dog by that id could be found.";
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				dogString = "Name: " + searchFido.getName() + ", Owner: " + searchFido.getOwner() + ", Notes: " + searchFido.getNotes();
				return dogString;
			}
		}
		
		return dogString;
	}
	
	public String putDogDetails(String id, String newID, String newName, String newOwner, String newNotes) {
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				searchFido.setId(newID);
				searchFido.setName(newName);
				searchFido.setOwner(newOwner);
				searchFido.setNotes(newNotes);
				return "Dog details updated!";
			}
		}
		
		return "No dog by that id could be found.";
	}
	
	public String getID(Dog fido) {
		return fido.getId();
	}
	
	public String putID(String id, String newID) {
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				searchFido.setId(newID);
				return "Dog ID updated!";
			}
		}
		
		return "No dog by that id could be found.";
	}
	
	public String getName(String id) {
		String dogName = "No dog by that id could be found.";
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				dogName = "Name: " + searchFido.getName();
				return dogName;
			}
		}

		return dogName;
	}
	
	public String putName(String id, String newName) {
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				searchFido.setName(newName);
				return "Dog Name updated!";
			}
		}
		
		return "No dog by that id could be found.";
	}
	
	public String getOwner(String id) {
		String dogOwner = "No dog by that id could be found.";
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				dogOwner = "Owner: " + searchFido.getOwner();
				return dogOwner;
			}
		}

		return dogOwner;
	}
	
	public String putOwner(String id, String newOwner) {
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				searchFido.setOwner(newOwner);
				return "Dog Owner updated!";
			}
		}
		
		return "No dog by that id could be found.";
	}
	
	public String getNotes(String id) {
		String dogNotes = "No dog by that id could be found.";
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				dogNotes = "Notes: " + searchFido.getNotes();
				return dogNotes;
			}
		}

		return dogNotes;
	}
	
	public String putNotes(String id, String newNotes) {
		for (Dog searchFido : allDogs) {
			if (searchFido.getId().equals(id)) {
				searchFido.setNotes(newNotes);
				return "Dog Notes updated!";
			}
		}
		
		return "No dog by that id could be found.";
	}
	
}
