package readonly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

import adventure.Command;
import adventure.Location;
import adventure.Room;

public final class ReadOnly {

    public static final Map<Location, Room> rooms = createRooms();

    private static final Map<Set<String>, Command> synonyms = createSynonyms();

    private static final Map<Location, Room> createRooms() {

	Map<Location, Room> tempRooms = new HashMap<Location, Room>();

	tempRooms.put(Location.ROOM1, new Room(
		"You find yourself in a dimly lit room. You can make out a closed door, where light is "
			+ "creeping through.",
		"Your flashlight is brighter than you expected in the dim room. The room is made of wood planks, "
			+ "and the ceiling is sloped. There is a chest in the middle of the room.",
		new HashSet(Arrays.asList(Command.CHEST, Command.DOOR, Command.NEXT)), null));

	tempRooms.put(Location.CORRIDOR, new Room(
		"There's a hole in the roof. There's a ton of snow all over the passageway, and even with the light of the "
			+ "moon, you can't see to the end of the corridor.",
		"This whole corridor looks ready to collapse. The room has already caved in, and there's snow  "
			+ "all over the passageway. Broken planks stick out here and there amongst the wreckage. At the end of "
			+ "the passage, you can just make out a closed door.",
		new HashSet(Arrays.asList(Command.DOOR, Command.PREVIOUS, Command.SNOW)), null));

	tempRooms.put(Location.BASEMENT, new Room(
		"The snow is everywhere down here. The corners are dark and musty, although a harsh wind is quickly sweeping "
			+ "the smell away.\nYou've got to get out of here, but you can't see an exit in this accursed snow.",
		"The snow above is nothing compared to the snow here, which fills the room. "
			+ "It looks like this was a basement in another time. There's a broom in the corner and some kitchen supplies. "
			+ "\nThere's a ladder up to the corridor above, if you're careful you might be able to climb it. ",
		new HashSet(Arrays.asList(Command.CLIMB, Command.NEXT, Command.SNOW)), null));

	tempRooms.put(Location.ROOM1_REVISITED, new Room(
		"This is the room you woke up in. The door is ajar and you can see the remains of the"
			+ "collapsed corridor through it.",
		"This is the room you woke up in. The door is ajar and you can see the remains of the collapsed "
			+ "corridor through it. It held up surprisingly well to the snow, which spills in from the "
			+ "door. There's a non-descript chest in the center of the room.",
		new HashSet(Arrays.asList(Command.CLIMB, Command.CHEST, Command.PREVIOUS)), null));

	return tempRooms;

    }

    private static final Map<Set<String>, Command> createSynonyms() {
	Map<Set<String>, Command> tempSynonyms = new HashMap<Set<String>, Command>();

	Set<String> yes = new HashSet(Arrays.asList("yes", "ye", "y", "yea", "ok", "yeah",
		"why not", "sounds good"));
	Set<String> no = new HashSet(Arrays.asList("no", "n", "no thanks", "nah", "nope"));
	Set<String> quit = new HashSet(Arrays.asList("close", "quit", "q", "exit",
		"quit()", "exit()"));
	Set<String> look = new HashSet(Arrays.asList("look", "look around", "l"));
	Set<String> help = new HashSet(Arrays.asList("?", "help", "h", "info", "hint"));
	Set<String> inventory = new HashSet(Arrays.asList("inventory", "get inventory",
		"carrying", "show items", "i", "items"));
	Set<String> lookAt = new HashSet(Arrays.asList("inspect", "inspect the",
		"look at"));
	Set<String> drink = new HashSet(Arrays.asList("drink", "drink water", "water",
		"water bottle"));
	Set<String> keys = new HashSet(Arrays.asList("shortcuts", "hotkeys", "keybindings",
		"keys", "keyboard", "keymap"));
	Set<String> light = new HashSet(Arrays.asList( // please keep
		// this list in
		// order
		"use flashlight", "l", "light", "light flashlight",
		"turn on flashlight", "turn flashlight on", "flashlight on",
		"turn on light", "turn light on", "dim", "dim flashlight",
		"turn off flashlight", "turn flashlight off", "flashlight off",
		"turn off light", "turn light off"));

	tempSynonyms.put(yes, Command.YES);
	tempSynonyms.put(no, Command.NO);
	tempSynonyms.put(quit, Command.QUIT);
	tempSynonyms.put(look, Command.LOOK);
	tempSynonyms.put(light, Command.LIGHT);
	tempSynonyms.put(help, Command.HELP);
	tempSynonyms.put(inventory, Command.INVENTORY);
	tempSynonyms.put(drink, Command.DRINK);
	tempSynonyms.put(keys, Command.KEYS);
	tempSynonyms.put(lookAt, Command.LOOK_AT_ITEM);

	// INSPECT, KEYS, DRINK, QUIT, LIGHT, INVENTORY, LOOK, LOCATION,
	// HELP, YES, NO, LOOKATITEM
	return tempSynonyms;
    }

    public static final Command parseCommand(String s) {

	s = s.toLowerCase();

	for (Set<String> array : synonyms.keySet()) {
	    if (array.contains(s)) {
		return synonyms.get(array);
	    }
	}
	return null;
    }
}
