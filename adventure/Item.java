package adventure;

/**
 * Item class - various items and objects in the game
 * 
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14)
 * Copyright (C) 2017 Joshua Nelson
 *
 */

public class Item {
    final String name;
    final String description;
    
    Item(String givenName, String givenDescription) {
	name = givenName;
	description = givenDescription;
    }
    
    Item(String givenName) {
	name = givenName;
	description = "";
    }
}
