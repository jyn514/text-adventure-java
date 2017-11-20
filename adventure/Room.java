package adventure;

/**
 * class Room - basis for rooms in the game
 * All rooms are initialized from readonly.Mappings
 * 
 * @author Joshua Nelson
 * @version 0.1 (2017-08-14) 
 * Copyright (C) 2017 Joshua Nelson
 * 
 */
import java.util.Set;
import java.util.HashSet;

public class Room {

    public final String descriptionWhenLight;
    public final Set<Command> actions;
    public final String descriptionWhenDark;
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