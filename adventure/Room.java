package adventure;

/**
 * class Location - basis for rooms in the game
 * 
 * @author Joshua Nelson
 * @version 0.1 (2017-8-14) 
 * Copyright (C) 2017 Joshua Nelson
 * 
 */
import java.util.List;

public class Room {
    
    String descriptionWhenLight;
    String descriptionWhenDark;
    List<Command> actions;
    
    Room(String lightDescription, String darkDescription, List<Command> givenActions) {
	descriptionWhenLight = lightDescription;
	descriptionWhenDark = darkDescription;
	actions = givenActions;
    }
    
}