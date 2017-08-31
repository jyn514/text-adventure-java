package adventure;

/**
 * class Location - basis for rooms in the game
 * 
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14) 
 * Copyright (C) 2017 Joshua Nelson
 * 
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

public class Room {

    String descriptionWhenLight;
    Set<Command> actions;
    String descriptionWhenDark;
    Set<Item> items;

    public Room(String darkDescription, String lightDescription,
	    Set<Command> givenActions, Set<Item> givenItems) {
	
	descriptionWhenLight = lightDescription;
	descriptionWhenDark = darkDescription;
	actions = givenActions;
	
	if (givenItems != null) {
	    items = givenItems;
	} else {
	    items = new HashSet<Item>();
	}
	
    }

    public Room(String description, Set<Command> givenActions, Set<Item> givenItems) {
	descriptionWhenLight = description;
	descriptionWhenDark = description;
	actions = givenActions;
	items = givenItems;
    }

}