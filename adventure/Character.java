/**
 * The character class; contains all temporary info about the character
 *
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14) 
 * Copyright (C) 2017 Joshua Nelson
 * 
 */

package adventure;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private Location location;
    private List<Item> inventory;
    private String name;

    Character() {
	location = Location.ROOM1;
	inventory = initialInventory();
    }

    Character(String givenName) {
	location = Location.ROOM1;
	inventory = initialInventory();
	name = givenName;
    }

    private List<Item> initialInventory() {
	List<Item> inventory = new ArrayList<>();

	inventory.add(new Item("backpack",
		"Your handy backpack. You brought it when you went hiking."));
	inventory.add(new Item("flashlight",
		"It's a flashlight. It's bright yellow color and the light "
			+ "is a little dim, but it's enough to make out your surroundings."));
	inventory.add(new Item("bottle",
		"It's full to the brim, and a little heavy to carry."));

	return inventory;
    }
}
