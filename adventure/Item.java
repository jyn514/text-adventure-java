package adventure;

/**
 * Item class - various items and objects in the game
 * 
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14)
 */

public class Item {
    private final String name;
    private final String description;
    
    Item(String givenName, String givenDescription) {
	name = givenName;
	description = givenDescription;
    }
    
    Item(String givenName) {
	name = givenName;
	description = null;
    }
}
