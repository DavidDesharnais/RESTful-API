// David Desharnais: Created in May 2019
package com.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWriter {  

  public static void main(String[] args) throws JsonParseException {  
	// Setting up example data for the list
	Dogs dogList = new Dogs();
	Dog lucky = new Dog("test", "Lucky", "Mary Johnson", "A Shiba Inu. Loves to hear his name. Loves eating dry food");
	Dog snowball = new Dog("two", "Snowball", "Freddie Mercury", "A Pommeranian. Likes to sleep all day. Sweet lap dog");
	Dog roy = new Dog("three", "Roy", "Marth of Fire Emblem", "A mutt that seems oddly human. Has red hair on top. Walks on two legs");
    
	// Showing random examples of using our methods
	System.out.println(dogList.getDog("test"));
	dogList.postDogInList(lucky);
	System.out.println(dogList.getName("test"));
	dogList.postDogInList(snowball);
	System.out.println(dogList.getNotes("two"));
	System.out.println(dogList.getDogs());
	dogList.putNotes("two", "A really silly rat. Acts like a dog and eats cheese");
	System.out.println(dogList.getDogs());
	dogList.postDogInList(roy);
	System.out.println(dogList.getDogs());
	dogList.putDogDetails("three", "apple", "Robin", "Lucina of Fire Emblem", "Likes to read books. Has fun with friends");
	System.out.println(dogList.getDogs());
	System.out.println(dogList.getDogs());
    ObjectMapper mapper = new ObjectMapper();
    System.out.println("NOW FOR READING");
    
    try {  
        // Writing to json file 
    	mapper.writeValue(new File("dogs.json"), dogList.getList());

    } catch (IOException e) {  
        e.printStackTrace();  
    } 
    
    try {
    	// Reading from json file
    	List<Dog> test = mapper.readValue(new File("dogs.json"), new TypeReference<List<Dog>>(){});
    	Dogs temp = new Dogs(test);
		System.out.println(temp.getDogs());
		System.out.println(temp.deleteDogInList("apple"));
		System.out.println(temp.getDogs());
		
	} catch (JsonMappingException e1) {
		// Catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// Catch block
		e1.printStackTrace();
	} 

  }  
}